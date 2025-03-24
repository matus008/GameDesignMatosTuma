public class Joye extends Npc {

    public Joye(String jmeno) {
        super(jmeno);
    }

    @Override
    public void setPromuv() {
        super.setPromuv("Ahoj, co potřebuješ?");
    }

    @Override
    public String odpoved(int volba) {
        switch (volba) {
            case 1:
                return "Nikdo podezřelý, ale něco mi na tom všem nesedí...";
            case 2:
                return "Mám se dobře, díky za optání.";
            case 3:
                return "O vraždě nic nevím, ale Herbert se mi zdá podivný.";
            case 4:
                return "Rozhovor končí, měj se!";
            default:
                return "Neplatná volba. Zkus to znovu.";
        }
    }
}
