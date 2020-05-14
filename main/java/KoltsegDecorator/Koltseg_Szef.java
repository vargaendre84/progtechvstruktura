package KoltsegDecorator;

public class Koltseg_Szef extends KoltsegDecorator
{
    private static int szefBeszerzesiKoltseg = 120000;
    private static int szefBeszerelesiKoltseg = 250000;
    public Koltseg_Szef(IKoltseg alapKoltseg) {super(alapKoltseg);}

    @Override
    public String getKoltsegNem() {
        return alapKoltseg.getKoltsegNem() + " + széf vásárlási és beszerelési költsége ";
    }

    @Override
    public double getKoltseg(long nevErtek, int futamIdo) {
        return alapKoltseg.getKoltseg(nevErtek, futamIdo) + szefBeszerzesiKoltseg + szefBeszerelesiKoltseg;
    }
}
