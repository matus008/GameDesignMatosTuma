import java.util.ArrayList;

public class Room {
    private String roomName;
    private ArrayList <Integer> possibles;
    private int roomNumber;

    public Room(String roomName, ArrayList<Integer> possibles, int roomNumber) {
        this.roomName = roomName;
        this.possibles = possibles;
        this.roomNumber = roomNumber;
    }
}
