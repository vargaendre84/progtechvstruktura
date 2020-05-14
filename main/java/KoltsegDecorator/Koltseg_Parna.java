package KoltsegDecorator;

public class Koltseg_Parna extends KoltsegDecorator
{
    private static int parnaBeszerzesiKoltseg = 2000;

    public Koltseg_Parna(IKoltseg alapKoltseg) {super(alapKoltseg);}

    @Override
    public String getKoltsegNem() {
        return alapKoltseg.getKoltsegNem() + " párna vásárlási költsége, ";
    }

    @Override
    public double getKoltseg(long nevErtek, int futamIdo) {
        return alapKoltseg.getKoltseg(nevErtek, futamIdo) + parnaBeszerzesiKoltseg;
    }
}
