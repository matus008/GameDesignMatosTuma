package Npc;

public class Clevland extends Npc {
    public Clevland(String jmeno) {
        super(jmeno);
    }

    @Override
    public void setPromuv() {
        super.setPromuv("Cus co potrebujes ty decko ?");
    }

    @Override
    public String odpoved(int volba) {
        switch (volba) {
            case 1:
                return "Nikoho sem nevidel, ale Quagmire je mi podezřelý. Videl sem ho se poslendi doubou dost zaobyrat tvoji sestrou.";
            case 2:
                return "Docela pohoda, až na projekty z IT.";
            case 3:
                return "Zřejmě někdo kuchnul tvýho bráchu, co? Byl to frajer, je mi líto.";
            case 4:
                return "Měj se hezky!";
            default:
                return "Neplatná volba. Zkus to znovu.";
        }
    }
}