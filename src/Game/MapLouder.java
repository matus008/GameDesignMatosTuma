package Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MapLouder {
    private static HashMap<Integer, Room> streetMap = new HashMap<>();
    private static int currentRoom = 2;
    private Hrac hrac;

    /**
     * Nacte mapu z textoveho souboru a inicializuje mistnosti
     */
    public boolean loud() {
        try (BufferedReader bf = new BufferedReader(new FileReader("src\\Mapa"))) {
            String line;
            while ((line = bf.readLine()) != null) {
                String[] lines = line.split(";");
                String name = lines[1];
                int number = Integer.parseInt(lines[0]);
                ArrayList<Integer> possibles = new ArrayList<>();
                for (String part : lines[2].split(",")) {
                    possibles.add(Integer.parseInt(part));
                }
                Room room = new Room(name, possibles, number);
                streetMap.put(number, room);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /**
         * Nastaveni zamcenych mistnosti a predmentu potrebnych pro jejich otevreni
          */
        for (Room room : streetMap.values()) {
            switch (room.getRoomNumber()) {
                case 5:
                    room.setLocked(true);
                    room.setRequiredItem("kladivo");
                    break;
                case 10:
                    room.setLocked(true);
                    room.setRequiredItem("krovinorez");
                    break;
                case 8:
                    room.setLocked(true);
                    room.setRequiredItem("klic");
                    break;
                default:
                    break;
            }
        }

        return true;
    }

    /**
     * Pokusi se presunout hrace do cilove mistnosti

     * dostava ID mistnosti do ktere se hrac chce presunout
     * vraci zprava informujici o vysledku akce
     */
    public String go(int roomID) {
        Room current = streetMap.get(currentRoom);

        if (current == null) {
            return "Chyba: Neplatna aktualni mistnost";
        }

        if (!streetMap.containsKey(roomID)) {
            return "Tato mistnost neexistuje";
        }

        if (!current.getPossibles().contains(roomID)) {
            return "Nemuzes se tam presunout z aktualni mistnosti";
        }

        Room targetRoom = streetMap.get(roomID);

        if (targetRoom.isLocked()) {
            if (!hrac.hasItem(targetRoom.getRequiredItem())) {
                return "Mistnost " + targetRoom.getRoomName() + " je zamcena Potrebujes " + targetRoom.getRequiredItem() + "";
            } else {
                targetRoom.unlock();
            }
        }

        currentRoom = roomID;
        Room novaMistnost = streetMap.get(currentRoom);
        hrac.setCurrentRoom(novaMistnost);

        return "Presunul ses do: " + novaMistnost.getRoomName();
    }

    /**
     * Vrati mapu vsech mistnosti
     */
    public static HashMap<Integer, Room> getStreetMap() {
        return streetMap;
    }

    /**
     * Vrati aktualni mistnost

     * vraci id aktualni mistnosti
     */
    public int getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Konstruktor pro Game.MapLouder inicializuje mapu a nastavi startovni mistnost pro hrace
     */
    public MapLouder(Hrac hrac) {
        this.hrac = hrac;
        loud();
        hrac.setCurrentRoom(streetMap.get(currentRoom));
    }

    /**
     * Zobrazi mozne dostupne mistnosti z aktualni lokace
     * vraci String obsahujici seznam dostupnych mistnosti
     */
    public String zobrazMapu() {
        Room currentRoom = streetMap.get(this.currentRoom);
        if (currentRoom == null) {
            return "Aktualni mistnost neexistuje";
        }

        ArrayList<Integer> dostupneMistnosti = currentRoom.getPossibles();

        StringBuilder mapa = new StringBuilder();
        mapa.append("Jsi v mistnosti: ").append(currentRoom.getRoomName()).append("\n");
        mapa.append("Muzes jit do techto mistnosti: ");

        for (Integer roomID : dostupneMistnosti) {
            Room room = streetMap.get(roomID);
            mapa.append(room.getRoomName()).append(" ");
        }

        return mapa.toString();
    }

    /**
     * Zobrazi celkovou mapu vsech mistnosti a jejich propojeni
     */
    public void zobrazeniCelkoveMapy() {
        for (Room room : MapLouder.getStreetMap().values()) {
            String propojeni = room.getPossibles().toString().replace("[", "").replace("]", "");
            // konkretne s radkem 121 sem se nechal inspirovat internetem
            System.out.println("Mistnost " + room.getRoomNumber() + ": " + room.getRoomName() + " - propojena s mistnostmi: " + propojeni);
        }
    }
}
