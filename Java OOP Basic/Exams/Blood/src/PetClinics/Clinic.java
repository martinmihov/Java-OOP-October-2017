package PetClinics;

public interface Clinic {

    boolean addPet(Pet pet);

    boolean release();

    boolean hasEmptyRooms();

    void print();

    void printRoom(int numberOfTheRoom);


}
