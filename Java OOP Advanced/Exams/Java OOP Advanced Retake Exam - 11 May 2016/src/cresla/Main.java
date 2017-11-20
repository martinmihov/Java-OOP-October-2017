package cresla;

import cresla.engines.Engine;
import cresla.interfaces.InputReader;
import cresla.interfaces.OutputWriter;
import cresla.io.ConsoleInputReader;
import cresla.io.ConsoleOutputWriter;
import cresla.repositories.ReactorRepository;
import cresla.repositories.Repository;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        Repository repository = new ReactorRepository();
        Engine engine = new Engine(reader, writer, repository);
        engine.run();
    }
}
