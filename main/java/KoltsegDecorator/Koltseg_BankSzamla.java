package KoltsegDecorator;

public class Koltseg_BankSzamla extends KoltsegDecorator
{
    public Koltseg_BankSzamla(IKoltseg alapKoltseg) {super(alapKoltseg);}
    private int bankSzamlaDij = 20000;  //OTP bankszámla díj

    @Override
    public String getKoltsegNem()
    {
        return alapKoltseg.getKoltsegNem() + " bankszámla éves díja, ";
    }

    @Override
    public double getKoltseg(long nevErtek,int futamIdo)
    {
        return alapKoltseg.getKoltseg(nevErtek,futamIdo) + bankSzamlaDij*futamIdo;
    }
}
