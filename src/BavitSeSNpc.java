
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
            moznosti.put(1, "Viděl jsi někoho podezřelého?");
            moznosti.put(2, "Jak se máš?");
            moznosti.put(3, "Co víš o vraždě?");
            moznosti.put(4, "Ukončit konverzaci.");
        } else if (npc instanceof Herbert) {
            moznosti.put(1, "Viděl jsi někoho podezřelého?");
            moznosti.put(2, "Jak se máš?");
            moznosti.put(3, "Co víš o vraždě?");
            moznosti.put(4, "Ukončit konverzaci.");
        } else if (npc instanceof Joye) {
            moznosti.put(1, "Viděl jsi někoho podezřelého?");
            moznosti.put(2, "Jak se máš?");
            moznosti.put(3, "Co víš o vraždě?");
            moznosti.put(4, "Ukončit konverzaci.");
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