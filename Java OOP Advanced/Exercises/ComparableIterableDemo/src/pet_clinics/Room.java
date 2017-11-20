package pet_clinics;

public class Room {
    private Pet pet;

    public Room(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return this.pet;
    }

    @Override
    public String toString() {
        return this.pet.toString();
    }
}
