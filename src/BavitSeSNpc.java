public class BavitSeSNpc implements Command {
    private Npc npcc;

    public BavitSeSNpc(Npc npc) {
        this.npcc = npc;
    }

    @Override
    public String Execute() {
        npcc.setPromuv();
        System.out.println("Mluvíš s " + npcc.getJmeno() );
        return npcc.getPromuv();
    }



    @Override
    public boolean exit() {
        return false;
    }
}