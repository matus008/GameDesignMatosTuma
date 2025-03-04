import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MapLouder {
    private static HashMap<Integer, Room> streetMap = new HashMap<>();
    private static int currentRoom = 1;

    public boolean loud(){
        try(BufferedReader bf = new BufferedReader(new FileReader("src\\Map.txt"))) {
            String line;
            while((line  = bf.readLine()) != null){
                System.out.println("funguje");
                String[] lines = line.split(";");
                String name = lines[1];
                int number = Integer.parseInt(lines[0]);
                ArrayList <Integer> possibles = new ArrayList<>();
                for (String part : lines[2].split(",")) {
                    possibles.add(Integer.parseInt(part));
                }
                streetMap.put(number, new Room( name, possibles,number));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public static  boolean go(int roomID){
        Room rom = streetMap.get(currentRoom);
        if (streetMap.containsKey(roomID)) {
            for (int posibl : rom.getPossibles()) {
                if (posibl == roomID) {
                    currentRoom = roomID;
                    System.out.println(currentRoom);
                    System.out.println("presun funguje");
                    return true;
                }
            }
        }
        return false;

    }

}
