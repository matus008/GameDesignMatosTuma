

public class Prohledat implements Command {



    private Hrac hrac;
    private MapLouder svet;

    public Prohledat(Hrac hrac, MapLouder svet ) {
        this.hrac = hrac;
        this.svet = svet;
    }

    public String Execute() {
        // Získání aktuální místnosti hráče
        Room currentRoom = hrac.getCurrentRoom();

        // Pokud hráč není v žádné místnosti
        if (currentRoom == null) {
            return "Nejsi v žádné místnosti.";
        }

        // Předání MapLouder (ne Room) do metody prohledání
        return "Prohledáváš: " + currentRoom.getRoomName() + "\n" + hrac.prohledatMistnost(svet);
    }

    @Override
    public boolean exit() {
        return false;
    }

}
