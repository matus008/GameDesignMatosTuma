public class Joye extends Npc {

    public Joye(String jmeno) {
        super(jmeno);
    }

    @Override
    public void setPromuv() {
        super.setPromuv("Ahoj, co potřebuješ?");
    }

    @Override
    public String odpoved(int volba) {
        return switch (volba) {
            case 1 -> "No jasne ze vim, nekde doma tady mam jeho klice, zkus se u me doma porozhlidnout a snad je najdes. Hlavne o tom nikomu nic nerikej.";
            case 2 -> "Pohodka hele, ale az uvidis tveho tatu tak mu rekni ze dneska do hospody nejedu.";
            case 3 ->
                    "Stojim si za tim, že právě Quagmire v tom bude mit prsty, byl dost žárlivej..";
            case 4 -> "Tak zase nekdy a pak mi vrat ty klyce nekdy.";
            default -> "Neplatná volba. Zkus to znovu.";
        };
    }
}
