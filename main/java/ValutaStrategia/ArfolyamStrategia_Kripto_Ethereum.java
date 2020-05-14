package ValutaStrategia;
import Portfolio.Egyenleg;

public class ArfolyamStrategia_Kripto_Ethereum extends ArfolyamStrategia
{
    Egyenleg myEgyenleg = Egyenleg.getInstance();

    public ArfolyamStrategia_Kripto_Ethereum(long nevErtek, double veteliArfolyam, double aktualisArfolyam)
    {
        super(nevErtek,veteliArfolyam,aktualisArfolyam);
    }

    @Override
    public void ArfolyamNyereseg()
    {
        double arfolyamNyereseg = nevErtek/veteliArfolyam * (aktualisArfolyam - veteliArfolyam);
        myEgyenleg.addArfolyamNyereseg(arfolyamNyereseg);
        System.out.println("Az Ethereumban tartott összeg árfolyamnyeresége: " + arfolyamNyereseg);
    }
}
