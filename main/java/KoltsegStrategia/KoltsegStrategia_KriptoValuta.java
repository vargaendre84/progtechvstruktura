package KoltsegStrategia;
import KoltsegDecorator.IKoltseg;
import KoltsegDecorator.Koltseg_Alap;
import Portfolio.Egyenleg;

public class KoltsegStrategia_KriptoValuta extends KoltsegStrategia
{
    Egyenleg myEgyenleg = Egyenleg.getInstance();
    private static int kriptofutamido = 1;

    public KoltsegStrategia_KriptoValuta(long nevErtek)
    {
        super(nevErtek, kriptofutamido);
    }

    public void KoltsegSzamitas()
    {
        IKoltseg koltseg = new Koltseg_Alap();
        System.out.println(koltseg.getKoltsegNem());
        double aktualisKoltseg = koltseg.getKoltseg(nevErtek, futamIdo);
        myEgyenleg.setUtolsoKoltseg(aktualisKoltseg);
        System.out.println("Költség: " + aktualisKoltseg);
    }
}
