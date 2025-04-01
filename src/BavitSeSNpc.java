import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Třída reprezentující rozhovor s NPC ve hře.
 */
public class BavitSeSNpc implements Command {
    private final Npc npc;
    private boolean odejit = false;
    private final Map<Integer, String> moznosti;

    /**
     * Konstruktor inicializující NPC a možnosti rozhovoru.
     *
     * urci NPc se kterým hráč komunikuje
     */
    public BavitSeSNpc(Npc npc) {
        this.npc = npc;
        this.npc.setPromuv();
        this.moznosti = new HashMap<>();
        inicializaceMoznosti();
    }

    /**
     * Inicializuje možnosti rozhovoru na základě typu NPC.
     */
    private void inicializaceMoznosti() {
        if (npc instanceof Clevland) {
            moznosti.put(1, "Máš tušení, kdo mohl udělat tu věc?");
            moznosti.put(2, "Jak se mas dneska M");
            moznosti.put(3, "Nevis jeste neco dalsiho o mem bratrovy ? ");
            moznosti.put(4, "Tak cau musim jit dal hledat dukazy. ");
        } else if (npc instanceof Herbert) {
            moznosti.put(1, "Jaký máš vztah s mým bratrem Chrisem?");
            moznosti.put(2, "Kde jsi byl minulou středu, kdyz se to stalo?");
            moznosti.put(3, "Můžeš mi říct něco o mé sestře Meg?");
            moznosti.put(4, "Tak cau musim jit dal hledat dukazy.");
        } else if (npc instanceof Joye) {
            moznosti.put(1, "Nevis jak bych se mohl dostat to domu Quegmire ?");
            moznosti.put(2, "Jak se dnes cítíš?");
            moznosti.put(3, "Neiděl jsi něco divnyho posledni dobou? ");
            moznosti.put(4, "Tak cau musim jit dal hledat dukazy.");
        } else if (npc instanceof Meg) {
            moznosti.put(1, "Cau segra kde ses prosimte ? ");
            moznosti.put(2, "Stalo se ti neco? ");
            moznosti.put(3, "Kde jsi byla kdyz se ti to stalo?");
            moznosti.put(4, "Tak cau drz se posnazim se ti pomoct.");
        } else if (npc instanceof Peter) {
            moznosti.put(1, "Nevis kde mame kladivo a krovinorez ? ");
            moznosti.put(2, "Kdy si myslis ze by to mohl udelat tato ? ");
            moznosti.put(3, "Nevis kdo tady ma studenej sklep hele ?");
            moznosti.put(4, "Tak cau musim jit dal hledat dukazy.");
        } else if (npc instanceof Quagmiere) {
            moznosti.put(1, "Nevis neco o moji sestre ? ");
            moznosti.put(2, "Tata se ptal, jestli vecer plati pivo ? ");
            moznosti.put(3, "Nemuzu se podivaat natvuj sklep mame projekt ve skole na to. ");
            moznosti.put(4, "Uvudime se zas jindy zatim ahoj.");
        }
    }

    /**
     * Spustí rozhovor s NPC a umožní hráči vybírat možnosti.
     * vraci výsledku rozhovoru.
     */
    @Override
    public String Execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mluvis s " + npc.getJmeno());
        System.out.println(npc.getPromuv1());

        while (!odejit) {
            System.out.println("Vyber moznost:");

            for (Map.Entry<Integer, String> entry : moznosti.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            int volba;
            try {
                volba = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Neplatna volba. Zkus to znovu.");
                continue;
            }

            System.out.println(npc.odpoved(volba));

            if (volba == 4) {
                odejit = true;
                return "Končíš rozhovor s " + npc.getJmeno() + ".";
            }
        }
        return "Nashledanou!";
    }

    /**
     * Určuje, zda příkaz ukončuje hru.
     *
     * @return Vždy vrací false, protože rozhovor s NPC hru neukončuje.
     */
    @Override
    public boolean exit() {
        return false;
    }
}
