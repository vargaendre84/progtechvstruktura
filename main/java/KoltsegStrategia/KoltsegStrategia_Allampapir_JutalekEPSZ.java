package KoltsegStrategia;
import KoltsegDecorator.*;
import Portfolio.Egyenleg;

public class KoltsegStrategia_Allampapir_JutalekEPSZ extends KoltsegStrategia_Allampapir
{
    public KoltsegStrategia_Allampapir_JutalekEPSZ(long nevErtek, int lejaratiIdo, int futamIdo)
    { super(nevErtek, lejaratiIdo, futamIdo); }

    public void KoltsegSzamitas()
    {
        Egyenleg myEgyenleg = Egyenleg.getInstance();
        IKoltseg koltseg;
        if(futamIdo < lejaratiIdo)
            koltseg = new Koltseg_VisszaValtas(new Koltseg_Jutalek(new Koltseg_ErtekPapirSzamla(new Koltseg_Alap())));
        else koltseg = new Koltseg_Jutalek(new Koltseg_ErtekPapirSzamla(new Koltseg_Alap()));
        System.out.println(koltseg.getKoltsegNem());
        double aktualisKoltseg = koltseg.getKoltseg(nevErtek,futamIdo);
        myEgyenleg.addKoltseg(aktualisKoltseg);
        System.out.println("Költség: " + aktualisKoltseg);

    }
}
