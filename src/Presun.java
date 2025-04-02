
import Game.Hrac;
import Game.MapLouder;

import java.util.Scanner;

public class Presun implements Command {
    private MapLouder mapa;
    private Hrac hrac;
    private Scanner sc;

    /**
     * Konstruktor třídy Presun
     * dostava objekt Game.MapLouder obsahující mapu hry
     */
    public Presun(MapLouder mapa) {
        this.mapa = mapa;
    }

    /**
     * Provádí přesun hráče do zvolené místnosti
     * vraci zprávu o úspěšném nebo neúspěšném přesunu
     */
    @Override
    public String Execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do které místnosti se chceš přesunout? Zadej číslo mistnosti: ");

        try {
            int roomID = Integer.parseInt(sc.nextLine());
            return mapa.go(roomID);
        } catch (NumberFormatException e) {
            return "Do této místnosti nemůžeš! Zkus to znovu.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
