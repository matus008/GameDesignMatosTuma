import java.util.ArrayList;

public class Hrac {
    private ArrayList<Item> inventar;
    private String jmeno;
    private Room currentRoom;

    public Hrac() {
        inventar = new ArrayList<>();
        currentRoom = null;
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }


    public boolean useItem(Item item) {
        return inventar.remove(item);
    }


    public void addItem(Item item) {
        inventar.add(item);
    }
    public void removeItem(String itemName) {
        for (int i = 0; i < inventar.size(); i++) {
            if (inventar.get(i).getNazevVeci().equals(itemName)) {
                inventar.remove(i);
                break;
            }
        }
    }

    public boolean hasItem(String itemName) {
        for (Item i : inventar) {
            if (i.getNazevVeci().equals(itemName)) {
                return true;
            }
        }
        return false;
    }


    public String zobrazInventar() {
        if (inventar.isEmpty()) {
            return "Tvůj inventář je prázdný.";
        }
        String result = "V inventáři máš: ";
        for (Item i : inventar) {
            result += i.getNazevVeci() + " ";
        }
        return result;
    }
}
