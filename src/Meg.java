public class Meg extends Npc {
    public Meg(String jmeno) {
        super(jmeno);
    }

    @Override
    public void setPromuv() {
        super.setPromuv("No konecne mam signal ahoj Stewie...");
    }

    @Override
    public String odpoved(int volba) {
        return switch (volba) {
            case 1 ->
                    "Vubec nevim je tady tma a zima rekla bych ze nekdy ve sklepe.";
            case 2 -> "Nekdo me unesl a omracil konecne jsem se probrala.";
            case 3 ->
                    "Na ulici vcera vecer";
            case 4 -> "Prosim pomoc mi.";
            default -> "Neplatná volba. Zkus to znovu.";
        };
    }
}
