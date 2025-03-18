public class Prohledat implements Command {

    private Room lokace;
    private Hrac hrac;

    public Prohledat(Room lokace) {
        this.lokace = lokace;
    }

    @Override
    public String Execute() {
        return "Prohledáváš: " + lokace.getRoomName() + hrac.prohledatMistnost();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
