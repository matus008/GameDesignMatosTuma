
import java.util.Scanner;

public class Presun implements Command {
    private MapLouder mapa;
    private Hrac hrac;
    private Scanner sc;

    public Presun(MapLouder mapa) {
        this.mapa = mapa;
    }

    @Override
    public String Execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do které místnosti se chceš přesunout? Zadej číslo: ");

        try {
            int roomID = Integer.parseInt(sc.nextLine());
            return mapa.go(roomID);
        } catch (NumberFormatException e) {
            return "Do teto mistnosti nemuzes! zkus to znova";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
