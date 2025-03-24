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
                return "Mám s tvým bratrem dobrý vztah, ale občas mě štve jeho chování.";
            case 2:
                return "Ve středu jsem byl na procházce v parku, byl to klidný den.";
            case 3:
                return "Meg? Neviděl jsem ji už nějakou dobu, ale možná je u Quagmire.";
            case 4:
                return "Papa doufam ze se jeste uvidime.";
            default:
                return "Neplatná volba. Zkus to znovu.";
        }
    }


}
