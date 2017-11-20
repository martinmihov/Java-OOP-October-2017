package exam;

import exam.core.HealthManager;
import exam.engines.Engine;
import exam.io.ConsoleInputReader;
import exam.io.ConsoleOutputWriter;
import exam.utilities.InputParser;

public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        InputParser inputParser = new InputParser();
        HealthManager healthManager = new HealthManager();
        Engine engine = new Engine(inputReader, outputWriter, inputParser, healthManager);

        engine.run();
    }
}
