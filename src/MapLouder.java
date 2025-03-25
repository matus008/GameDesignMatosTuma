import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MapLouder {
    private static HashMap<Integer, Room> streetMap = new HashMap<>();
    private static int currentRoom = 3;
    private Hrac hrac;

    public boolean loud(){
        try(BufferedReader bf = new BufferedReader(new FileReader("src\\Mapa"))) {
            String line;
            while((line  = bf.readLine()) != null){

                String[] lines = line.split(";");
                String name = lines[1];
                int number = Integer.parseInt(lines[0]);
                ArrayList <Integer> possibles = new ArrayList<>();
                for (String part : lines[2].split(",")) {
                    possibles.add(Integer.parseInt(part));
                }
                streetMap.put(number, new Room( name, possibles,number));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public String go(int roomID) {
        Room current = streetMap.get(currentRoom);

        if (current == null) {
            return "Chyba: Neplatná aktuální místnost!";
        }

        if (!streetMap.containsKey(roomID)) {
            return "Tato místnost neexistuje.";
        }

        if (!current.getPossibles().contains(roomID)) {
            return "Nemůžeš se tam přesunout z aktuální místnosti.";
        }

        currentRoom = roomID;

        // Získání nové místnosti z mapy a nastavení jako aktuální místnost pro hráče
        Room novaMístnost = streetMap.get(currentRoom);
        hrac.setCurrentRoom(novaMístnost);  // Ujistíme se, že tuto metodu voláme správně

        return "Přesunul ses do: " + streetMap.get(currentRoom).getRoomName();
    }

    public static HashMap<Integer, Room> getStreetMap() {
        return streetMap;
    }

    public  int getCurrentRoom() {
        return currentRoom;
    }

    public MapLouder(Hrac hrac) {
        this.hrac = hrac;
        loud();
        // Nastavíme aktuální místnost hráče podle statické hodnoty currentRoom (např. 3)
        hrac.setCurrentRoom(streetMap.get(currentRoom));
    }

}
