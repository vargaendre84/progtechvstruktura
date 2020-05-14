package KoltsegStrategia;
import KoltsegDecorator.*;
import Portfolio.Egyenleg;

public class KoltsegStrategia_KP extends KoltsegStrategia
{
    Egyenleg myEgyenleg = Egyenleg.getInstance();
    private static int kpFutamido = 1;

    public KoltsegStrategia_KP(long nevErtek) { super(nevErtek,kpFutamido); }

    @Override
    public void KoltsegSzamitas()
    {
        IKoltseg koltseg = new Koltseg_Biztositas(new Koltseg_Riaszto(new Koltseg_Szef(new Koltseg_Alap())));
        double aktualisKoltseg = koltseg.getKoltseg(nevErtek, kpFutamido);
        System.out.println(koltseg.getKoltsegNem());
        if(myEgyenleg.getOtthoniTrezorKialakitva())
        {
            System.out.println("Otthoni trezor rendszer már ki van alakítva, nem szükséges újra kifizetni az árát");
            myEgyenleg.setUtolsoKoltseg(koltseg.getKoltseg(nevErtek,kpFutamido));
        }
        else
        {
            myEgyenleg.addKoltseg(aktualisKoltseg);
            myEgyenleg.setOtthoniTrezorKialakitva(true);
        }
        System.out.println("Aktuális költség= " + aktualisKoltseg);
    }
}
