package KoltsegDecorator;

public class Koltseg_Riaszto extends KoltsegDecorator
{
    private static int riasztoBeszerzesiKoltseg = 200000;
    private static int riasztoBeszerelesiKoltseg = 100000;
    private static int riasztoUzemeltetesiKoltsegEvente = 50000;

    public Koltseg_Riaszto(IKoltseg alapKoltseg) {super(alapKoltseg);}

    @Override
    public String getKoltsegNem() {
        return alapKoltseg.getKoltsegNem() + " + riasztó vásárlási, beszerelési és üzemeltetési költsége ";
    }

    @Override
    public double getKoltseg(long nevErtek, int futamIdo) {
        return alapKoltseg.getKoltseg(nevErtek, futamIdo)
                + riasztoBeszerzesiKoltseg + riasztoBeszerelesiKoltseg + riasztoUzemeltetesiKoltsegEvente*futamIdo;
    }
}
