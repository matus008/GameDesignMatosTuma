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
                return "Pozoroval jsem, že Quagmire se choval podezřele, když se řešily Herbertovy chvíle s Chrisem.";
            case 2:
                return "Během dne jsem slyšel, jak se mluvilo o Quagmireově neklidu kvůli tomu, jak Herbert tráví čas s Chrisem.";
            case 3:
                return "Mám pocit, že Quagmire byl motivován závistí, což by mohlo vysvětlovat, proč by mohl něco takového udělat.";
            case 4:
                return "Tak se měj, uvidíme se později.";
            default:
                return "Neplatná volba. Zkus to znovu.";
        }
    }
}
