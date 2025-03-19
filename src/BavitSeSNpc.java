
import java.util.Scanner;

public class BavitSeSNpc implements Command {
    private Npc npcc;
    private String odpoved;
    private boolean odejit = false;

    public BavitSeSNpc(Npc npc) {
        this.npcc = npc;
    }


    @Override
    public String Execute() {
        npcc.setPromuv();
        System.out.println("Mluvíš s " + npcc.getJmeno() );
        Scanner scc = new Scanner(System.in);
        while (!odejit) {

            String odpoved = scc.next();
            return npcc.getPromuv1();

        }
        return "Nashledanou.";
    }



    @Override
    public boolean exit() {
        return false;
    }
}