import java.util.HashMap;
import java.util.Scanner;

public class Konzole {
    private MapLouder svet;
    private boolean exit = false;
    private Scanner sc;
    private HashMap<String, Command> komandy;
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
    private Hrac hrac;

    /**
     * Konstruktor inicializuje hrace a herni svet
     */
    public Konzole() {
        hrac = new Hrac();
        kladivo = new Kladivo("kladivo");
        klíč = new Klíč("klic");
        křovinořez = new Křovinořez("krovinorez");
        svet = new MapLouder(hrac);
        inicializace();
    }

    /**
     * Inicializuje dostupne prikazy ve hre
     */
    public void inicializace() {
        komandy = new HashMap<>();

        komandy.put("zavolatBrian", new BavitSeSNpc(brian));
        komandy.put("zavolatHerbert", new BavitSeSNpc(herbert));
        komandy.put("zavolatMeg", new BavitSeSNpc(meg));
        komandy.put("zavolatPeter", new BavitSeSNpc(peter));
        komandy.put("zavolatJoye", new BavitSeSNpc(joye));
        komandy.put("zavolatClevland", new BavitSeSNpc(clevland));
        komandy.put("zavolatQuagmire", new BavitSeSNpc(quagmiere));
        komandy.put("prohledat", new Prohledat(hrac, svet));
        komandy.put("presun", new Presun(svet));
        komandy.put("pouzitKladivo", new PouzitPredmet(kladivo, hrac));
        komandy.put("pouzitKlic", new PouzitPredmet(klíč, hrac));
        komandy.put("pouzitKrovinorez", new PouzitPredmet(křovinořez, hrac));
        komandy.put("exit", new Exit());
    }

    /**
     * Spousti hru a spracovava prikazy od hrace
     */
    public void start() {
        System.out.println("Vitej ve hre Zde je mapa mistnosti a jejich propojeni");
        svet.zobrazeniCelkoveMapy();
        System.out.println("----------------------------------");
        System.out.println("Pribeh Ses ve svete Family Guy a zjistilo se ze nekdo zavrazdil tveho bratra a tvoje sestra je nezvestna Potrebujes splnit vsechny ukoly aby jsi dosahl sveho Hodne stesti");
        System.out.println("Ukoly Najdi vsechny dukazy promluv si se vsemi obyvateli mesta dostan se do vsech mistnosti a hlavne ODHAL VRAHA");
        System.out.println("Toto jsou tve moznosti ktere ve hre muzes delat presun prohledat zavolat + clovek kteremu chces zavolat napr zavolatMeg pouzit + predmet napr pouzitKladivo");
        System.out.println("Copak chces delat Zadej prikaz");

        sc = new Scanner(System.in);
        while (!exit) {
            System.out.println("----------------------------------");
            System.out.print("prikaz - - > ");
            String input = sc.nextLine().trim();

            if (komandy.containsKey(input)) {
                String result = komandy.get(input).Execute();
                System.out.println(result);
            } else {
                System.out.println("Neznamy prikaz " + input);
            }

            if (input.equals("exit")) {
                exit = true;
            }

            System.out.println(svet.zobrazMapu());

            if (hrac.jeHraDokoncena()) {
                System.out.println("Gratuluji Odhalil jsi ze za tim vsim byl Quagmire ted se probouzis ze snu a jdes na snidani");
                break;
            }
        }
        System.out.println("Skoncil sis");
    }
}
