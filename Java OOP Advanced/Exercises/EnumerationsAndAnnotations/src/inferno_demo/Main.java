package inferno_demo;

import inferno_demo.io.ConsoleInputReader;
import inferno_demo.io.ConsoleOutputWriter;
import inferno_demo.io.InputReader;
import inferno_demo.io.OutputWriter;
import inferno_demo.models.api.WeaponInterface;
import inferno_demo.engine.Engine;
import inferno_demo.repositories.Repository;
import inferno_demo.repositories.WeaponRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        InputReader reader = new ConsoleInputReader(bufferedReader);
        OutputWriter writer = new ConsoleOutputWriter();
        Repository<WeaponInterface> weaponRepository = new WeaponRepository<>();
        Runnable engine = new Engine(weaponRepository, reader, writer);

        engine.run();
    }
}
