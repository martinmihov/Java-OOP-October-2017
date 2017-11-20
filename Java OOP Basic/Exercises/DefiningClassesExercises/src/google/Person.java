package google;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private CompanyInfo companyInfo;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void addCompanyInfo(String name, String department, double salary) {
        this.companyInfo = new CompanyInfo(name, department, salary);
    }

    public void addPokemon(String name, String type) {
        this.pokemons.add(new Pokemon(name, type));
    }

    public void addParent(String name, String birthDay) {
        this.parents.add(new Parent(name, birthDay));
    }

    public void addChild(String name, String birthDay) {
        this.children.add(new Child(name, birthDay));
    }

    public void addCar(String model, int speed) {
        this.car = new Car(model, speed);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.name).append(System.lineSeparator());
        sb.append("Company:").append(this.companyInfo == null ? "" : System.lineSeparator() + this.companyInfo).append(System.lineSeparator())
                .append("Car:").append(this.car == null ? "" : System.lineSeparator() + this.car).append(System.lineSeparator())
                .append("Pokemon:").append(this.pokemons.size() == 0 ? "" : System.lineSeparator() + String.join(System.lineSeparator(), this.pokemons.stream().map(Pokemon::toString).collect(Collectors.toList()))).append(System.lineSeparator())
                .append("Parents:").append(this.parents.size() == 0 ? "" : System.lineSeparator() + String.join(System.lineSeparator(), this.parents.stream().map(Parent::toString).collect(Collectors.toList()))).append(System.lineSeparator())
                .append("Children:").append(this.children.size() == 0 ? "" : System.lineSeparator() + String.join(System.lineSeparator(), this.children.stream().map(Child::toString).collect(Collectors.toList()))).append(System.lineSeparator());
        return sb.toString();
    }

    private class CompanyInfo {
        private String name;
        private String department;
        private double salary;

        private CompanyInfo(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("%s %s %.2f", this.name, this.department, this.salary);
        }
    }

    private class Pokemon {
        private String name;
        private String type;

        private Pokemon(String name, String type) {
            this.name = name;
            this.type = type;
        }

        @Override
        public String toString() {
            return this.name + " " + this.type;
        }
    }

    private class Parent extends Person {
        private String birthDay;

        private Parent(String name, String birthDay) {
            super(name);
            this.birthDay = birthDay;
        }

        @Override
        public String toString() {
            return super.name + " " + this.birthDay;
        }
    }

    private class Child extends Person {
        private String birthDay;

        private Child(String name, String birthDay) {
            super(name);
            this.birthDay = birthDay;
        }

        @Override
        public String toString() {
            return super.name + " " + this.birthDay;
        }
    }

    private class Car {
        private String model;
        private int speed;

        private Car(String model, int speed) {
            this.model = model;
            this.speed = speed;
        }

        @Override
        public String toString() {
            return this.model + " " + this.speed;
        }
    }
}