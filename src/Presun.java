public class Presun implements Command {
    private Room misto;
    private Hrac hrac;

    public Presun(Room misto, Hrac hrac) {
        this.misto = misto;
        this.hrac = hrac;

    }

    @Override
    public String Execute() {
        return "Přesouváš se na: " + misto.getRoomName() + hrac.moveTo(misto);
    }

    @Override
    public boolean exit() {
        return false;
    }
}
