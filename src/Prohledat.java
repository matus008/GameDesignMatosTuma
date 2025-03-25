

public class Prohledat implements Command {



    private Hrac hrac;
    private MapLouder svet;

    public Prohledat(Hrac hrac, MapLouder svet ) {
        this.hrac = hrac;
        this.svet = svet;
    }

    public String Execute() {
        Room currentRoom = hrac.getCurrentRoom();

        if (currentRoom == null) {
            return "Nejsi v žádné místnosti.";
        }

        return "Prohledáváš: " + currentRoom.getRoomName() + "\n" + hrac.prohledatMistnost(svet);
    }

    @Override
    public boolean exit() {
        return false;
    }

}
