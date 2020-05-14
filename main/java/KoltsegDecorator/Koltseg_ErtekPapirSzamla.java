package KoltsegDecorator;

public class Koltseg_ErtekPapirSzamla extends KoltsegDecorator
{
    public Koltseg_ErtekPapirSzamla(IKoltseg alapKoltseg) {super(alapKoltseg);}
    private double ertekpapirSzamlaDij = 0.0022;  //OTP értékpapírszámla 2020.03.01-től

    @Override
    public String getKoltsegNem()
    {
        return alapKoltseg.getKoltsegNem() + " értékpapír számla éves díja, ";
    }

    @Override
    public double getKoltseg(long nevErtek, int futamIdo)
    {
       return alapKoltseg.getKoltseg(nevErtek, futamIdo) + nevErtek*ertekpapirSzamlaDij*futamIdo;
    }
}
