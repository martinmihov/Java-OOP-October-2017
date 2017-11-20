package exam.engines;

import exam.core.HealthManager;
import exam.io.ConsoleInputReader;
import exam.io.ConsoleOutputWriter;
import exam.utilities.Constants;
import exam.utilities.InputParser;

import java.util.List;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private HealthManager healthManager;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter,
                  InputParser inputParser, HealthManager healthManager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.healthManager = healthManager;
    }

    public void run() {
        String inputLine;

        while (true) {
            inputLine = this.inputReader.readLine();
            List<String> commandParams = this.inputParser.parseInput(inputLine);

            this.dispatchCommand(commandParams);
            //INPUT_TERMINATING_COMMAND - this is your terminated command
            if (inputLine.equals(Constants.INPUT_TERMINATING_COMMAND)) {
                break;
            }
        }
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);
        String output = "";

        switch (command) {
            case "checkCondition":
                output = this.healthManager.checkCondition(commandParams.get(0));
                if (output != null) {
                    outputWriter.writeLine(output.trim());
                }
                break;
            case "createOrganism":
                output = this.healthManager.createOrganism(commandParams.get(0));
                if (output != null) {
                    outputWriter.writeLine(output.trim());
                }
                break;
            case "addCluster":
                output = this.healthManager.addCluster(commandParams.get(0), commandParams.get(1),
                        Integer.parseInt(commandParams.get(2)), Integer.parseInt(commandParams.get(3)));
                if (output != null) {
                    outputWriter.writeLine(output.trim());
                }
                break;
            case "addCell":
                output = this.healthManager.addCell(commandParams.get(0), commandParams.get(1),
                        commandParams.get(2), commandParams.get(3), Integer.parseInt(commandParams.get(4)),
                        Integer.parseInt(commandParams.get(5)), Integer.parseInt(commandParams.get(6)),
                        Integer.parseInt(commandParams.get(7)));
                if (output != null) {
                    outputWriter.writeLine(output.trim());
                }
                break;
            case "activateCluster":
                output = this.healthManager.activateCluster(commandParams.get(0));
                if (output != null) {
                    outputWriter.writeLine(output.trim());
                }
                break;
            case "BEER IS COMING":
                break;
        }
    }
}
