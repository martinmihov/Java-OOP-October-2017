package inferno_demo.engine;

import inferno_demo.annotations.Inject;
import inferno_demo.core.Executable;
import inferno_demo.io.InputReader;
import inferno_demo.io.OutputWriter;
import inferno_demo.models.api.WeaponInterface;
import inferno_demo.repositories.Repository;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Engine implements Runnable {
    private static final String TERMINATE_COMMAND = "END";
    private static final String COMMAND_CLASS_PATH = "inferno_demo.core.commands.";
    private static final String COMMAND_CLASS_NAME_SUFFIX = "Command";

    private String[] params;
    private Repository<WeaponInterface> weaponRepository;
    private InputReader reader;
    private OutputWriter writer;

    public Engine(Repository<WeaponInterface> weaponRepository, InputReader reader, OutputWriter writer) {
        this.weaponRepository = weaponRepository;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run() {
        while (true) {
            this.params = this.reader.readLine().split(";");
            if (TERMINATE_COMMAND.equals(this.params[0])) {
                break;
            }
            try {
                String result = this.dispatchCommand(this.params[0], Arrays.stream(this.params).skip(1).toArray(String[]::new));
                if (result != null) {
                    this.writer.writeLine(result);
                }
                String debug = "";
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    private String dispatchCommand(String command, String[] tokens) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        this.params = tokens;
        Class<Executable> commandClass = (Class<Executable>) Class.forName(COMMAND_CLASS_PATH + command + COMMAND_CLASS_NAME_SUFFIX);
        Constructor<Executable> declaredConstructor = commandClass.getDeclaredConstructor();
        Executable executable = declaredConstructor.newInstance();
        injectDependencies(executable);
        return executable.execute();
    }

    private void injectDependencies(Executable executable) throws IllegalAccessException {
        Field[] fields = executable.getClass().getSuperclass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                Field[] currentFields = this.getClass().getDeclaredFields();
                for (Field currentField : currentFields) {
                    if (field.getType().equals(currentField.getType())) {
                        field.setAccessible(true);
                        field.set(executable, currentField.get(this));
                    }
                }
            }
        }
    }
}
