package Npc;

public class Brian extends Npc {
    public Brian(String jmeno) {
        super(jmeno);
    }

    @Override
    public String odpoved(int volba) {
        switch (volba) {
            case 1:
                return "Zkus se zeptat Npc.Joye ten bh mohl vedet.";
            case 2:
                return "Nevidel hele moc me zenajima.";
            case 3:
                return "Tam dole na konco ulice.";
            case 4:
                return "Dneska ne dneska uz sem se byl vyvencit.";
            default:
                return "Neplatná volba. Zkus to znovu.";
        }
    }

    @Override
    public void setPromuv() {
        super.setPromuv("Nazdar kamo. Jak ti muzu pomoct?");

    }
}
