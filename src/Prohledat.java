public class Prohledat implements Command {

    private Room lokace;
    private Hrac hrac;


    @Override
    public String Execute() {
        return "Prohledáváš: " + lokace.getRoomName() + hrac.prohledatMistnost(this.lokace);
    }

    @Override
    public boolean exit() {
        return false;
    }
}
