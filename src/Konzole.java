import java.util.HashMap;
import java.util.Queue;
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
    private Herbert herbert;
    private Meg meg;
    private Peter peter;
    private Joye joye;
    private Clevland clevland;
    private Quagmiere quagmiere;

    public Konzole(MapLouder svet) {
        this.svet = svet;
        inicializace();

    }

    public void executeCommand(){
    }

    public void inicializace(){
        Hrac hrac = new Hrac();
        komandy.put("mluvitSBrianem", new BavitSeSNpc(brian));
        komandy.put("mluvitSHerbertem", new BavitSeSNpc(herbert));
        komandy.put("mluvitSMeg", new BavitSeSNpc(meg));
        komandy.put("mluvitSPeterem", new BavitSeSNpc(peter));
        komandy.put("mluvitSJoye", new BavitSeSNpc(joye));
        komandy.put("mluvitSClevlandem", new BavitSeSNpc(clevland));
        komandy.put("mluvitSQuagmirem", new BavitSeSNpc(quagmiere));



        komandy.put("pouzitKladivo", new PouzitPredmet(kladivo, hrac));
        komandy.put("pouzitKlic", new PouzitPredmet(klíč, hrac));
        komandy.put("pouzitKrovinorez", new PouzitPredmet(křovinořez, hrac));

        komandy.put("exit", new Exit());
    }
    public void start(){
        System.out.println("Vítej ve hře! Zadej příkaz:");
        while (!exit) {
            System.out.print("> ");
            String input = sc.nextLine().trim();

            if (komandy.containsKey(input)) {
                String result = komandy.get(input).Execute();
                System.out.println(result);
            } else {
                System.out.println("Neznámý příkaz: " + input);
            }

            if (input.equals("exit")) {
                exit = true;
            }
        }
        System.out.println("Hra ukončena.");
    }
}
