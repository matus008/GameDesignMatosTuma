
public class PouzitPredmet implements Command {
    private Item predmet;
    private Hrac hrac;

    /**
     * Konstruktor třídy PouzitPredmet
     */
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
                return "Nepodařilo se použít " + predmet.getNazevVeci() +
                        ". (zkus to třeba na nějakou skrytou místnost která je zamčená)";
            }
        } else {
            return "Předmět " + predmet.getNazevVeci() + " nemáš v inventáři.";
        }
    }

    /**
     * Metoda určuje zda příkaz ukončuje hru
     * vraci false protože použití předmětu neukončuje hru
     */
    @Override
    public boolean exit() {
        return false;
    }
}