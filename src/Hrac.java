import java.util.ArrayList;

public class Hrac {
    private ArrayList<Item> inventar;
    private String jmeno;
    private Room currentRoom;

    public Hrac() {
        this.currentRoom = null;

    }

    public boolean useItem(Item item) {
        inventar.remove(item);
        return true;
    }
    public void bavitSeSNpc(){}
    public boolean vzitItemDoInventare(Item item){
        return true;
    }
    public void sebratDukaz(){}
    public String prohledatMistnost(){
        return "Nasel jsi:";
    }
    public boolean moveTo(Room room){

        return true;
    }
}
