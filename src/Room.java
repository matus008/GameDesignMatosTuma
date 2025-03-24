import java.util.ArrayList;

public class Room {
    private final String roomName;
    private final int roomNumber;
    private final ArrayList<Integer> possibles;
    private final ArrayList<Item> items;
    private boolean locked;
    private String requiredItem;

    public Room(String roomName, ArrayList<Integer> possibles, int roomNumber) {
        this.roomName = roomName;
        this.possibles = possibles;
        this.roomNumber = roomNumber;
        this.locked = locked;
        this.requiredItem = requiredItem;
        this.items = new ArrayList<>();
    }

    public ArrayList<Integer> getPossibles() {
        return possibles;
    }

    public String getRoomName() {
        return roomName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isLocked() {
        return locked;
    }

    public void unlock() {
        this.locked = false;
    }

    public String getRequiredItem() {
        return requiredItem;
    }


    public void addItem(Item item) {
        items.add(item);
    }


    public boolean removeItem(Item item) {
        return items.remove(item);
    }


    public ArrayList<Item> getItems() {
        return items;
    }

}
