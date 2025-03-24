public abstract class Npc {
    private final String jmeno;
    private String promuv1;

    public Npc(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPromuv1() {
        return promuv1;
    }

    public void setPromuv(String promuv1) {
        this.promuv1 = promuv1;
    }


    public abstract String odpoved(int volba);

    public abstract void setPromuv();
}
