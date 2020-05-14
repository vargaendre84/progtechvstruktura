package KoltsegDecorator;

public class Koltseg_Aram extends KoltsegDecorator
{
    private static int evesAramSzamla = 200000;
    public Koltseg_Aram(IKoltseg alapKoltseg) {super(alapKoltseg);}

    @Override
    public String getKoltsegNem() {
        return alapKoltseg.getKoltsegNem() + " éves áramdíj, ";
    }

    @Override
    public double getKoltseg(long nevErtek, int futamIdo)
    {
        return alapKoltseg.getKoltseg(nevErtek,futamIdo) + evesAramSzamla*futamIdo;
    }
}
