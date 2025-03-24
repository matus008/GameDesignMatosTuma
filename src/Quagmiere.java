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
            case 1 -> "Co? Já? To je naprostý nesmysl!";
            case 2 -> "Já jsem byl jen u párty, nic podezřelého se nedělo.";
            case 3 ->
                    "No, možná jsem byl trošku rozrušený... Ale to neznamená, že bych něco udělal. Prostě jsem nemohl přijmout, jak moc čas Herbert tráví s Chrisem.";
            case 4 -> "To bylo všechno, měj se!";
            default -> "Neplatná volba. Zkus to znovu.";
        };
    }
}
