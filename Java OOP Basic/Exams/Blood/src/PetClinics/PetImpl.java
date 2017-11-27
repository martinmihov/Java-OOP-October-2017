package PetClinics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PetImpl implements Pet {
    private String name;
    private int age;
    private String kind;

    public PetImpl(String name, int age, String kind) {
        setName(name);
        setAge(age);
        setKind(kind);
    }

    public void setName(String name) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        Matcher matcher = pattern.matcher(name);

        if (matcher.find()){
            this.name = name;
        }
        else {
            throw new IllegalArgumentException("Invalid Operation!");
        }
    }

    public void setAge(int age) {
        if (age >=0 && age <= 100){
            this.age = age;
        }
        else {
            throw new IllegalArgumentException("Invalid Operation!");
        }
    }

    public void setKind(String kind) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        Matcher matcher = pattern.matcher(kind);

        if (matcher.find()){
            this.kind = kind;
        }
        else {
            throw new IllegalArgumentException("Invalid Operation!");
        }
    }


    @Override
    public String toString() {
        return String.format("%s %d %s",this.name,this.age,this.kind);
    }
}
