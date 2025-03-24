public class Meg extends Npc {
    public Meg(String jmeno) {
        super(jmeno);
    }

    @Override
    public void setPromuv() {
        super.setPromuv("Ahoj, co chceš?");
    }

    @Override
    public String odpoved(int volba) {
        switch (volba) {
            case 1:
                return "Nikdy jsem neviděla nic podezřelého.";
            case 2:
                return "Mám se dobře, jsem ráda, že se mě ptáš.";
            case 3:
                return "O vraždě nic nevím, ale Cleveland se mi zdá divný.";
            case 4:
                return "Tak zase někdy, měj se.";
            default:
                return "Neplatná volba. Zkus to znovu.";
        }
    }
}
