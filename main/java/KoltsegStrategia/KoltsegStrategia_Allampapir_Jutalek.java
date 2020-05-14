package KoltsegStrategia;
import KoltsegDecorator.*;
import Portfolio.Egyenleg;

public class KoltsegStrategia_Allampapir_Jutalek extends KoltsegStrategia_Allampapir
{
    public KoltsegStrategia_Allampapir_Jutalek(long nevErtek, int lejaratiIdo, int futamIdo)
    { super(nevErtek, lejaratiIdo, futamIdo); }

    public void KoltsegSzamitas()
    {
        Egyenleg myEgyenleg = Egyenleg.getInstance();
        IKoltseg koltseg = new Koltseg_Alap();
        if(futamIdo < lejaratiIdo)
            koltseg = new Koltseg_VisszaValtas(new Koltseg_Jutalek(new Koltseg_Alap()));
        else koltseg = new Koltseg_Jutalek(new Koltseg_Alap());
        System.out.println(koltseg.getKoltsegNem());
        double aktualisKoltseg = koltseg.getKoltseg(nevErtek,futamIdo);
        System.out.println("Költség: " + aktualisKoltseg);
        myEgyenleg.addKoltseg(aktualisKoltseg);
    }
}
