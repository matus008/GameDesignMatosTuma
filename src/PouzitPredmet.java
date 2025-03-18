public class PouzitPredmet implements Command {

    private Item predmet;
    private Hrac hrac;

    public PouzitPredmet(Item predmet, Hrac hrac) {
        this.predmet = new Kladivo("kladivo");
        this.hrac = hrac;
    }

    @Override
    public String Execute() {
        return "Používáš předmět: " + predmet.getNazevVeci() + " - " +  hrac.useItem(predmet);
    }

    @Override
    public boolean exit() {
        return false;
    }
}
