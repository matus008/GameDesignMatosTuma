import java.util.ArrayList;
import java.util.HashMap;

public class Hrac {
    private ArrayList<Item> inventar;
    private String jmeno;
    private Room currentRoom;

    public Hrac() {
        inventar = new ArrayList<>();
        currentRoom = null;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    // s touto metodou mi pomohla umela inteligence
    public String prohledatMistnost(MapLouder mapa) {
        Room room = mapa.getStreetMap().get(mapa.getCurrentRoom());
        if (room == null) {
            return "Nejsi v žádné místnosti.";
        }

        // Zde už prohledáváme aktuální místnost hráče
        HashMap<Integer, Item[]> lootTable = new HashMap<>();
        lootTable.put(3, new Item[]{ new Křovinořez("krovinorez"), new Kladivo("kladivo") });
        lootTable.put(5, new Item[]{ new Důkaz("dukaz") });
        lootTable.put(8, new Item[]{ new Klíč("klyc") });
        lootTable.put(9, new Item[]{ new Důkaz("dukaz") });
        lootTable.put(11, new Item[]{ new Důkaz("dukaz") });

        if (lootTable.containsKey(room.getRoomNumber())) {
            Item[] items = lootTable.get(room.getRoomNumber());
            StringBuilder nalezeneVeci = new StringBuilder();

            for (Item item : items) {
                addItem(item);
                nalezeneVeci.append(item.getNazevVeci()).append(", ");
            }

            return "Našel jsi: " + nalezeneVeci.substring(0, nalezeneVeci.length() - 2);
        }

        return "V této místnosti nic není.";
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
