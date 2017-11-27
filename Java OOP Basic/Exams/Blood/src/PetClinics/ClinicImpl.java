package PetClinics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClinicImpl implements Clinic,Iterable<Room> {
    private String name;
    private List<Room> rooms;
    private Iterator<Room> accomodationIterator;
    private Iterator<Room> releaseIterator;

    public ClinicImpl(String name,int numberOfRooms) {
        this.name = name;
        setRooms(numberOfRooms);
        this.accomodationIterator = new AccomodationIterator();
        this.releaseIterator = new ReleaseIterator();
    }

    @Override
    public boolean addPet(Pet pet) {
        while(accomodationIterator.hasNext()){
            Room room = accomodationIterator.next();
            if (room == null){
                room = new RoomImpl();
                room.add(pet);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean release() {
        while (releaseIterator.hasNext()){
            Room room = releaseIterator.next();
            if (room != null){
                room.release();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasEmptyRooms() {
        for (Room room : rooms) {
            if (room == null){
                return true;
            }
        }
        return false;
    }

    @Override
    public void print() {
        for (Room room : rooms) {
            if (room == null){
                System.out.println("Room empty");
            }
            else {
                System.out.println(room);
            }
        }
    }

    @Override
    public void printRoom(int numberOfTheRoom) {
        Room room = rooms.get(numberOfTheRoom - 1);
        if (room == null){
            System.out.println("Room empty");
        }
        else {
            System.out.println(room);
        }
    }

    private void setRooms(int numberOfRooms) {
        if (numberOfRooms % 2 == 0){
            throw new IllegalArgumentException("Invalid Operation!");
        }
        else{
            this.rooms = new ArrayList<>();
            for (int i = 0; i < numberOfRooms; i++) {
                this.rooms.add(null);
            }
        }
    }

    @Override
    public Iterator<Room> iterator() {
        return new PrintIterator();
    }

    private final class PrintIterator implements Iterator<Room>{

        int index = 0;
        @Override
        public boolean hasNext() {
            return index < rooms.size();
        }

        @Override
        public Room next() {
            return rooms.get(index++);
        }
    }

    private final class AccomodationIterator implements Iterator<Room> {
        int index = rooms.size() / 2;
        int counterLeft = index - 1;
        int counterRight = index + 1;

        @Override
        public boolean hasNext() {
            return this.index == rooms.size() / 2 || counterLeft >= 0 || counterRight < rooms.size();
        }


        @Override
        public Room next() {
            if (rooms.get(index) == null){
                return rooms.get(index++);
            }
            if (rooms.get(counterLeft) != null && rooms.get(counterRight) != null && rooms.get(index) != null){
                counterRight++;
                counterLeft++;
            }
            if (rooms.get(counterLeft) == null){
                return rooms.get(counterLeft);
            }
            else {
                return rooms.get(counterRight);
            }
        }
    }

    private final class ReleaseIterator implements  Iterator<Room> {

        int index = rooms.size() / 2;
        boolean continueLooping = true;
        @Override
        public boolean hasNext() {
            return continueLooping;
        }

        @Override
        public Room next() {
            for (int i = index; i < rooms.size(); i++) {
                if (rooms.get(i) != null){
                    continueLooping = false;
                    return rooms.get(i);
                }
            }
            for (int i = 0; i < index; i++) {
                if (rooms.get(i) != null){
                    continueLooping = false;
                    return rooms.get(i);
                }
            }
            continueLooping = false;
            return null;
        }
    }
}
