package Npc;

public class Peter extends Npc {
    public Peter(String jmeno) {
        super(jmeno);
    }

    @Override
    public void setPromuv() {
        super.setPromuv("Cau Stewie jak to jde ? ");
    }

    @Override
    public String odpoved(int volba) {
        switch (volba) {
            case 1:
                return "No na zahrade prece zkus se tam porozhlidnout.";
            case 2:
                return "Vubec nevim, potrebuju ted ale chili cas o samote.";
            case 3:
                return "Nevim ale my ho rozhodne nemame.";
            case 4:
                return "Tak se měj, uvidíme se později.";
            default:
                return "Neplatná volba. Zkus to znovu.";
        }
    }
}
