import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

public class Konzole {
    private MapLouder mapLouder;
    private boolean exit = false;
    private Scanner sc;
    private HashMap<String, Command> komandy;
    private MapLouder svet;
    private Kladivo kladivo;
    private Klíč klíč;
    private Křovinořez křovinořez;
    private final Brian brian = new Brian("brian");
    private final Herbert herbert = new Herbert("herbert");
    private final Meg meg = new Meg("meg");
    private final Peter peter = new Peter("peter");
    private final Joye joye = new Joye("joye");
    private final Clevland clevland = new Clevland("clevland");
    private final Quagmiere quagmiere = new Quagmiere("quagmiere");


    public Konzole(MapLouder svet) {
        this.svet = svet;
        inicializace();

    }

    public void executeCommand(){
    }

    public void inicializace(){
        Hrac hrac = new Hrac();
        komandy = new HashMap<>();

        komandy.put("mluvitSBrianem", new BavitSeSNpc(brian));
        komandy.put("mluvitSHerbertem", new BavitSeSNpc(herbert));
        komandy.put("mluvitSMeg", new BavitSeSNpc(meg));
        komandy.put("mluvitSPeterem", new BavitSeSNpc(peter));
        komandy.put("mluvitSJoye", new BavitSeSNpc(joye));
        komandy.put("mluvitSClevlandem", new BavitSeSNpc(clevland));
        komandy.put("mluvitSQuagmirem", new BavitSeSNpc(quagmiere));

        komandy.put("prohledat", new Prohledat());

        komandy.put("presun", new Presun(svet));

        komandy.put("pouzitKladivo", new PouzitPredmet(kladivo, hrac));
        komandy.put("pouzitKlic", new PouzitPredmet(klíč, hrac));
        komandy.put("pouzitKrovinorez", new PouzitPredmet(křovinořez, hrac));

        komandy.put("exit", new Exit());
    }
    public void start(){
        System.out.println("Copak chces delat? Zadej příkaz:");
        sc = new Scanner(System.in);
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
        System.out.println("Skoncil si.");
    }
}
