import java.util.HashMap;
import java.util.Scanner;

public class Konzole {
    private boolean exit = false;
    private Scanner sc;
    private HashMap<String, Command> komandy;
    private MapLouder svet;
    private Kladivo kladivo;
    private Klíč klíč;
    private Křovinořez křovinořez;
    private Brian brian;
    public Konzole(MapLouder svet) {
        this.svet = svet;
        inicializace();

    }

    public void executeCommand(){
    }
    public void start(){

    }
    public void inicializace(){
        Hrac hrac = new Hrac();
        komandy.put("mluv", new BavitSeSNpc(brian));
        komandy.put("exit", new Exit());

        komandy.put("pouzitKladivo", new PouzitPredmet(kladivo, hrac));
        komandy.put("pouzitKlic", new PouzitPredmet(klíč, hrac));
        komandy.put("pouzitKrovinorez", new PouzitPredmet(křovinořez, hrac));


    }
}
