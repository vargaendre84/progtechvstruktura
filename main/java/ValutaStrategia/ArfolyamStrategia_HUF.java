package ValutaStrategia;
import Portfolio.Egyenleg;

public class ArfolyamStrategia_HUF extends ArfolyamStrategia
{
    Egyenleg myEgyenleg = Egyenleg.getInstance();
    private static double hufArfolyam = 0.0;

    public ArfolyamStrategia_HUF(long nevErtek)
    {
        super(nevErtek,hufArfolyam,hufArfolyam);
    }

    @Override
    public void ArfolyamNyereseg()
    {
        double arfolyamNyereseg = hufArfolyam;
        myEgyenleg.addArfolyamNyereseg(arfolyamNyereseg);
        System.out.println("Az magyar Forintban tartott összegnek nincs árfolyamnyeresége: " + arfolyamNyereseg);
    }
}
