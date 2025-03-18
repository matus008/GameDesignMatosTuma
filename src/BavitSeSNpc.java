public class BavitSeSNpc implements Command {
    private Npc npc;

    public BavitSeSNpc(Npc npc) {
        this.npc = npc;
    }

    @Override
    public String Execute() {
        System.out.println("Mluvíš s " + npc.getJmeno());
        return npc.getPromuv();
    }



    @Override
    public boolean exit() {
        return false;
    }
}