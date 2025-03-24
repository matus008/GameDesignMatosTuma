public class Peter extends Npc {
    public Peter(String jmeno) {
        super(jmeno);
    }

    @Override
    public void setPromuv() {
        super.setPromuv("Ahoj, co chceš?");
    }

    @Override
    public String odpoved(int volba) {
        switch (volba) {
            case 1:
                return "Nikdy jsem neviděl nic podezřelého, ale měl bys zkontrolovat Quagmire.";
            case 2:
                return "Dneska jsem byl na pivu s Joe, všechno v pohodě.";
            case 3:
                return "Vím, že si někdo pohrál s Chrisem. Bylo to brutální.";
            case 4:
                return "Tak se měj, uvidíme se později.";
            default:
                return "Neplatná volba. Zkus to znovu.";
        }
    }
}
