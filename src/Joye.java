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
                return "Viděla jsem, jak se Quagmire neklidně potuloval, když se mluvilo o tom, kolik času Herbert tráví s Chrisem.";
            case 2:
                return "Cítím se docela fajn, ale slyšela jsem, že Quagmire byl fakt podrážděný kvůli tomu vztahu.";
            case 3:
                return "Mám podezření, že právě Quagmire mohl mít něco společného s tím, co se stalo – byl totiž dost žárlivý.";
            case 4:
                return "Rozhovor končí, měj se!";
            default:
                return "Neplatná volba. Zkus to znovu.";
        }
    }
}
