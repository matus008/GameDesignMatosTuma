public class Herbert extends Npc {
    public Herbert(String jmeno) {
        super(jmeno);
    }
    public void setPromuv() {
        super.setPromuv("Ahooj mladence, jak ti mohu pomoct?");
    }

    @Override
    public String odpoved(int volba) {
        switch (volba) {
            case 1:
                return "No tvuj bracha jet muj nejoblibenejsi ze vsech lidi. Byl sem naprosto zhroucenej kdyz sem se dozvedel co se mu stalo.";
            case 2:
                return "Ve středu jsem byl na procházce v parku, koukat se na hriste plne dedi s potencialem.";
            case 3:
                return "Meg? Neviděl jsem ji už nějakou dobu, ale možná je u Quagmire dost se s ni bavi.";
            case 4:
                return "Papa doufam ze se jeste uvidime kloucu.";
            default:
                return "Neplatná volba. Zkus to znovu.";
        }
    }


}
