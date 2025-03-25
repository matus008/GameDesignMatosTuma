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


        for (Room room : streetMap.values()) {
            switch(room.getRoomNumber()){
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
                    room.setRequiredItem("klyc");
                    break;
                default:
                    break;
            }
        }

        return true;
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

        Room targetRoom = streetMap.get(roomID);

        if(targetRoom.isLocked()){
            if(!hrac.hasItem(targetRoom.getRequiredItem())){
                return "Místnost " + targetRoom.getRoomName() + " je zamčená. Potřebuješ " + targetRoom.getRequiredItem() + ".";
            } else {

                targetRoom.unlock();
            }
        }

        currentRoom = roomID;
        Room novaMístnost = streetMap.get(currentRoom);
        hrac.setCurrentRoom(novaMístnost);

        return "Přesunul ses do: " + novaMístnost.getRoomName();
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

        hrac.setCurrentRoom(streetMap.get(currentRoom));
    }
    public String zobrazMapu() {
        Room currentRoom = streetMap.get(this.currentRoom);
        if (currentRoom == null) {
            return "Aktuální místnost neexistuje!";
        }

        ArrayList<Integer> dostupneMistnosti = currentRoom.getPossibles();

        StringBuilder mapa = new StringBuilder();
        mapa.append("Jsi v místnosti: ").append(currentRoom.getRoomName()).append("\n");
        mapa.append("Můžeš jít do těchto místností: ");

        for (Integer roomID : dostupneMistnosti) {
            Room room = streetMap.get(roomID);
            mapa.append(room.getRoomName()).append(" ");
        }

        return mapa.toString();
    }
    public void zobrazeniCelkoveMapy() {
        System.out.println("Mapu hry tvoří následující místnosti a jejich propojení:");
        for (Room room : MapLouder.getStreetMap().values()) {
            String propojeni = room.getPossibles().toString().replace("[", "").replace("]", "");
            //konkretne s radkem 121 sem se nechal inspirovat internetem
            System.out.println("Místnost " + room.getRoomNumber() + ": " + room.getRoomName() + " - propojena s místnostmi: " + propojeni);
        }
    }

}
