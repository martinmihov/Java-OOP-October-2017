package solutions.pr11CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

abstract class Cat{
    String name;

    Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getClass().getName(), this.name);
    }
}

class Siamese extends Cat {
    int earSize;

    Siamese(String name, int earSize) {
        super(name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format(" %d", this.earSize));
        return sb.toString();
    }
}

class Cymric extends Cat {
    double furLength;

    Cymric(String name, double furLength) {
        super(name);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format(" %.2f", this.furLength));
        return sb.toString();
    }
}

class StreetExtraordinaire extends Cat{
    int decibelsOfMeows;

    StreetExtraordinaire(String name, int decibelsOfMeows) {
        super(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format(" %d", this.decibelsOfMeows));
        return sb.toString();
    }
}

public class Pr11CatLady
{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Cat> catsByName = new LinkedHashMap<>();
        String line = reader.readLine();

        while(!line.equals("End"))
        {
            String[] parameters = line.split("\\s+");
            String breed = parameters[0];
            String name = parameters[1];
            switch (breed)
            {
                case "Siamese":
                    int earSize = Integer.parseInt(parameters[2]);
                    catsByName.put(name, new Siamese(name, earSize));
                    break;
                case "Cymric":
                    double furLength = Double.parseDouble(parameters[2]);
                    catsByName.put(name, new Cymric(name, furLength));
                    break;
                case "StreetExtraordinaire":
                    int decibels = Integer.parseInt(parameters[2]);
                    catsByName.put(name, new StreetExtraordinaire(name, decibels));
                    break;
            }

            line = reader.readLine();
        }

        line = reader.readLine();
        System.out.println(catsByName.get(line));
    }
}
