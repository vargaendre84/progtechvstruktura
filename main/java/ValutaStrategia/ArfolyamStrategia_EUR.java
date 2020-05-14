package ValutaStrategia;
import Portfolio.Egyenleg;

public class ArfolyamStrategia_EUR extends ArfolyamStrategia
{
    Egyenleg myEgyenleg = Egyenleg.getInstance();

    public ArfolyamStrategia_EUR(long nevErtek, double veteliArfolyam, double aktualisArfolyam)
    {
        super(nevErtek,veteliArfolyam,aktualisArfolyam);
    }

    @Override
    public void ArfolyamNyereseg()
    {
        double arfolyamNyereseg = nevErtek/veteliArfolyam * (aktualisArfolyam - veteliArfolyam);
        myEgyenleg.addArfolyamNyereseg(arfolyamNyereseg);
        System.out.println("Az Euróban tartott összeg árfolyamnyeresége: " + arfolyamNyereseg);
    }
}
