package ValutaStrategia;
import Portfolio.Egyenleg;

public class Beszerzes_KP extends BeszerzesiStrategia
{
    Egyenleg myEgyenleg = Egyenleg.getInstance();
    private long nevErtek;
    public Beszerzes_KP(long nevErtek) { this.nevErtek = nevErtek; }

    @Override
    public void Beszerzes()
    {
        myEgyenleg.addNevertek(nevErtek);
        System.out.println("Készpénzmozgás= " + nevErtek);
    }
}
