package KoltsegStrategia;
import KoltsegDecorator.IKoltseg;
import KoltsegDecorator.Koltseg_Alap;
import Portfolio.Egyenleg;

public class KoltsegStrategia_Allampapir_Alap extends KoltsegStrategia_Allampapir
{
    public KoltsegStrategia_Allampapir_Alap(long nevErtek, int lejaratiIdo, int futamIdo)
    {
        super(nevErtek, lejaratiIdo, futamIdo);
    }

    public void KoltsegSzamitas() {
        Egyenleg myEgyenleg = Egyenleg.getInstance();
        IKoltseg koltseg = new Koltseg_Alap();
        System.out.println(koltseg.getKoltsegNem());
        double aktualisKoltseg = koltseg.getKoltseg(nevErtek,futamIdo);
        System.out.println("Költség: " + aktualisKoltseg);
        myEgyenleg.addKoltseg(aktualisKoltseg);
    }
}
