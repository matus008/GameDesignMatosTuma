public abstract class Npc {
   private final String jmeno;
   private  String promuv;

    public Npc(String jmeno) {
        this.jmeno = jmeno;

    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPromuv() {
        return promuv;
    }

    public void setPromuv(String promuv) {
        this.promuv = promuv;
    }

    public abstract void setPromuv();
}
