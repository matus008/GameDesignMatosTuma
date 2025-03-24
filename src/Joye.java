public class Joye extends Npc {

    public Joye(String jmeno) {
        super(jmeno);
    }

    @Override
    public void setPromuv() {
        super.setPromuv("Ahoj, jsem Joye. Jak ti mohu pomoci?");
    }

    @Override
    public String odpoved(int volba) {
        switch (volba) {
            case 1:
                return "Joye říká: 'Nikdo podezřelý se neobjevil v okolí.'";
            case 2:
                return "Joye říká: 'Mám se v pořádku, děkuji.'";
            case 3:
                return "Joye říká: 'O vraždě nic nevím, ale mám pocit, že Peter něco skrývá.'";
            default:
                return "Neznámá volba. Zkus to znovu.";
        }
    }
}
