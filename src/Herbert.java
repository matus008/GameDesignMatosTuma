public class Herbert extends Npc {
    public Herbert(String jmeno) {
        super(jmeno);
    }

    @Override
    public void setPromuv() {
        super.setPromuv("Ahoj, jsem Herbert. Jak ti mohu pomoci?");
    }

    @Override
    public String odpoved(int volba) {
        switch (volba) {
            case 1:
                return "";
            case 2:
                return "";
            case 3:
                return "";
            case 4:
                return "";
            default:
                return "";
        }
    }
}
