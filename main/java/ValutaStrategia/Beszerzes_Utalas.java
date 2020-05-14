package ValutaStrategia;
import Portfolio.Egyenleg;

public class Beszerzes_Utalas extends BeszerzesiStrategia
{
    Egyenleg myEgyenleg = Egyenleg.getInstance();
    private long nevErtek;
    public Beszerzes_Utalas(long nevErtek) { this.nevErtek = nevErtek; }

    @Override
    public void Beszerzes()
    {
        myEgyenleg.addNevertek(nevErtek);
        System.out.println("Átutalt összeg= " + nevErtek);
    }
}
