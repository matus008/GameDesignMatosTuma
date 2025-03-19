import java.util.ArrayList;
import java.util.Scanner;

public class Presun implements Command {
    private final MapLouder mapLouder;
    private Hrac hrac;
    private Scanner sc;

    public Presun( Hrac hrac, MapLouder mapLouder) {
        this.hrac = hrac;
        this.sc = new Scanner(System.in);
        this.mapLouder = mapLouder;

    }

    @Override
    public String Execute() {
        System.out.println("Kam potrebujes jit?");
        String input = sc.next();
        int cislo = Integer.parseInt(input);
        for (int i = 0; i < MapLouder.getStreetMap().size(); i ++ ){
           // int koste  = (MapLouder.getStreetMap().get(i).getPossibles());
           // if (cislo == koste){
            //    mapLouder.go(cislo);
            //}
        }

        return "Přesouváš se na: " ;// +misto.getRoomName() + misto.getPossibles();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
