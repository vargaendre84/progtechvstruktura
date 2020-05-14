package KoltsegStrategia;
import KoltsegDecorator.*;
import Portfolio.Egyenleg;

public class KoltsegStrategia_KP_ParnaCiha extends KoltsegStrategia
{
    Egyenleg myEgyenleg = Egyenleg.getInstance();
    private static int kpFutamido = 1;

    public KoltsegStrategia_KP_ParnaCiha(long nevErtek) { super(nevErtek,kpFutamido); }

    @Override
    public void KoltsegSzamitas()
    {
        IKoltseg koltseg = new Koltseg_Parna(new Koltseg_Alap());
        double aktualisKoltseg = koltseg.getKoltseg(nevErtek, kpFutamido);
        myEgyenleg.setUtolsoKoltseg(aktualisKoltseg);
        System.out.println(koltseg.getKoltsegNem());
        System.out.println("Aktuális költség= " + aktualisKoltseg + " , de semmilyen védelem vagy biztosítás nincs.");
    }
}
