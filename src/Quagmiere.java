public class Quagmiere extends Npc {

    public Quagmiere(String jmeno) {
        super(jmeno);
    }

    @Override
    public void setPromuv() {
        super.setPromuv("Ahoj, co potřebuješ? Hm?");
    }

    @Override
    public String odpoved(int volba) {
        switch (volba) {
            case 1:
                return "Nikdo podezřelý, ale něco mi říká, že bys měl zkontrolovat Herberta.";
            case 2:
                return "Byl jsem na párty, jinak nic zvláštního.";
            case 3:
                return "O vraždě nevím, ale Herbert se choval divně.";
            case 4:
                return "To bylo všechno, měj se!";
            default:
                return "Neplatná volba. Zkus to znovu.";
        }
    }
}
