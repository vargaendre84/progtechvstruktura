package KoltsegStrategia;
import KoltsegDecorator.IKoltseg;
import KoltsegDecorator.Koltseg_Alap;
import KoltsegDecorator.*;
import Portfolio.Egyenleg;

public class KoltsegStrategia_Banyaszat extends KoltsegStrategia
{
    Egyenleg myEgyenleg = Egyenleg.getInstance();

    public KoltsegStrategia_Banyaszat(long nevErtek, int futamIdo)
    {
        super(nevErtek,futamIdo);
    }

    public void KoltsegSzamitas()
    {
        IKoltseg koltseg = new Koltseg_Aram(new Koltseg_BanyaGep(new Koltseg_Alap()));
        System.out.println(koltseg.getKoltsegNem());
        double aktualisKoltseg = koltseg.getKoltseg(nevErtek, futamIdo);
        System.out.println("Költség: " + aktualisKoltseg);
    }
}
