package KoltsegStrategia;
import KoltsegDecorator.IKoltseg;
import KoltsegDecorator.Koltseg_Alap;
import KoltsegDecorator.Koltseg_BankSzamla;
import Portfolio.Egyenleg;

public class KoltsegStrategia_Bank extends KoltsegStrategia
{
    Egyenleg myEgyenleg = Egyenleg.getInstance();

    public KoltsegStrategia_Bank(long nevErtek, int futamIdo)
    {
        super(nevErtek,futamIdo);
    }

    public void KoltsegSzamitas()
    {
        IKoltseg koltseg = new Koltseg_BankSzamla(new Koltseg_Alap());
        System.out.println(koltseg.getKoltsegNem());
        double aktualisKoltseg = koltseg.getKoltseg(nevErtek, futamIdo);
        System.out.println("Költség: " + aktualisKoltseg);
    }
}
