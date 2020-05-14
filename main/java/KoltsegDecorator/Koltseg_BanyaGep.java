package KoltsegDecorator;

public class Koltseg_BanyaGep extends KoltsegDecorator
{
    private static int banyagepBeszerzesiKoltseg = 120000;
    public Koltseg_BanyaGep(IKoltseg alapKoltseg) {super(alapKoltseg);}

    @Override
    public String getKoltsegNem() {
        return alapKoltseg.getKoltsegNem() + " + bányagép beszerzésim költsége ";
    }

    @Override
    public double getKoltseg(long nevErtek, int futamIdo) {
        return alapKoltseg.getKoltseg(nevErtek, futamIdo) + banyagepBeszerzesiKoltseg;
    }
}
