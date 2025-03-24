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
        return switch (volba) {
            case 1 ->
                    "Nikdy jsem nic podezřelého neviděla, ale slyšela jsem, že Quagmire měl neustále problém s Herbertovým vztahem s Chrisem.";
            case 2 -> "Jsem v pohodě, ale věci kolem mě se zdají být komplikované – hlavně kvůli té zášti Quagmirea.";
            case 3 ->
                    "Myslím, že Quagmire nemohl přijmout, že Herbert trávil tolik času s Chrisem. To by mohl být klíč k celé věci.";
            case 4 -> "Tak zase někdy, měj se.";
            default -> "Neplatná volba. Zkus to znovu.";
        };
    }
}
