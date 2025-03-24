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
        return switch (volba) {
            case 1 -> "Co? Já? Nevim od vcerejsiho vecera sem ji nevidel.";
            case 2 -> "No nemuzu misim se doma neceho zbavit jeste.";
            case 3 ->
                    "uh...Ja sk-k-k-klep nemam hele.";
            case 4 -> "To bylo všechno, měj se!";
            default -> "Neplatná volba. Zkus to znovu.";
        };
    }
}
