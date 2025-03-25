public class PouzitPredmet implements Command {
    private Item predmet;
    private Hrac hrac;

    public PouzitPredmet(Item predmet, Hrac hrac) {
        this.predmet = predmet;
        this.hrac = hrac;
    }

    @Override
    public String Execute() {
        if (hrac.hasItem(predmet.getNazevVeci())) {
            boolean used = hrac.useItem(predmet);
            if (used) {
                return "Použil jsi předmět: " + predmet.getNazevVeci() + ".";
            } else {
                return "Nepodařilo se použít " + predmet.getNazevVeci() + ".(zkus to treba na nejakou skrytou zed a treba ji zboris)";
            }
        } else {
            return "Předmět " + predmet.getNazevVeci() + " nemáš v inventáři.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}