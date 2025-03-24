public class Clevland extends Npc {
    public Clevland(String jmeno) {
        super(jmeno);
    }

    @Override
    public void setPromuv() {
        super.setPromuv("Cus co potrebujes ty decko ? ");
    }

    @Override
    public String odpoved(int volba) {
        switch (volba) {
            case 1:
                return "nikoho sem nevidel, ale Herbert je mi podezdrelej";
            case 2:
                return "DOcela pohodka az na projekty z IT.";
            case 3:
                return "Ze nekdo kuchnul tvyho brachu co, byl to frajer je mi lito.";
            case 4:
                return "Měj se hezky!";
            default:
                return "Neplatna volba. Zkus to znovu.";
        }
    }
}
