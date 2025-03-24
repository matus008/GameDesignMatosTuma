
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BavitSeSNpc implements Command {
    private final Npc npc;
    private boolean odejit = false;
    private final Map<Integer, String> moznosti;

    public BavitSeSNpc(Npc npc) {
        this.npc = npc;
        this.npc.setPromuv();
        this.moznosti = new HashMap<>();
        inicializaceMoznosti();
    }

    private void inicializaceMoznosti() {
        if (npc instanceof Clevland) {
            moznosti.put(1, "Máš tušení, kdo mohl udělat tu věc?");
            moznosti.put(2, "Jak se ti vede s těmi IT projekty?");
            moznosti.put(3, "Slyšel jsem, že jsi viděl Quagmire. Můžeš to potvrdit?");
            moznosti.put(4, "Rozloučit se.");
        } else if (npc instanceof Herbert) {
            moznosti.put(1, "Jaký máš vztah s mým bratrem Chrisem?");
            moznosti.put(2, "Kde jsi byl minulou středu, kdy se to stalo?");
            moznosti.put(3, "Můžeš mi říct něco o mé sestře Meg?");
            moznosti.put(4, "Ukončit rozhovor.");
        } else if (npc instanceof Joye) {
            moznosti.put(1, "Co víš o posledních událostech?");
            moznosti.put(2, "Jak se dnes cítíš?");
            moznosti.put(3, "Viděla jsi něco neobvyklého?");
            moznosti.put(4, "Ukončit konverzaci.");
        } else if (npc instanceof Meg) {
            moznosti.put(1, "Máš nějaké podezření na někoho?");
            moznosti.put(2, "Co se stalo v poslední době?");
            moznosti.put(3, "Jak se ti daří v práci?");
            moznosti.put(4, "Rozloučit se.");
        } else if (npc instanceof Peter) {
            moznosti.put(1, "Co jsi dělal v den vraždy?");
            moznosti.put(2, "Jak se ti vede, kámo?");
            moznosti.put(3, "Máš nějaké informace o této záhadě?");
            moznosti.put(4, "Ukončit konverzaci.");
        } else if (npc instanceof Quagmiere) {
            moznosti.put(1, "Máš nějaké informace o podezřelých?");
            moznosti.put(2, "Co ti říkají, že se děje ve městě?");
            moznosti.put(3, "Jak se cítíš ohledně toho, co se stalo?");
            moznosti.put(4, "Rozloučit se.");
        }
    }

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

    @Override
    public boolean exit() {
        return false;
    }
}