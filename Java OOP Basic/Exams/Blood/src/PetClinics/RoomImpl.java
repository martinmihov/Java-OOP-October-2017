package PetClinics;

public class RoomImpl implements Room {

    private Pet pet;
    boolean isEmpty;

    public RoomImpl() {
        this.isEmpty = false;
    }

    @Override
    public void add(Pet pet) {
        this.pet = pet;
        this.isEmpty = false;
    }

    @Override
    public boolean isEmpty() {
        return this.isEmpty;
    }

    @Override
    public void release() {
        this.pet = null;
        this.isEmpty = true;
    }

    @Override
    public String toString() {
        if (this.isEmpty){
            return "Room empty";
        }
        return this.pet.toString();
    }
}
