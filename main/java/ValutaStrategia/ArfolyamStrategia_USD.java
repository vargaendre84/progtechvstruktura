package ValutaStrategia;
import Portfolio.Egyenleg;

public class ArfolyamStrategia_USD extends ArfolyamStrategia
{
    Egyenleg myEgyenleg = Egyenleg.getInstance();

    public ArfolyamStrategia_USD(long nevErtek, double veteliArfolyam, double aktualisArfolyam)
    {
        super(nevErtek,veteliArfolyam,aktualisArfolyam);
    }

    @Override
    public void ArfolyamNyereseg()
    {
        double arfolyamNyereseg = nevErtek/veteliArfolyam * (aktualisArfolyam - veteliArfolyam);
        myEgyenleg.addArfolyamNyereseg(arfolyamNyereseg);
        System.out.println("Az amerikai Dollárban tartott összeg árfolyamnyeresége: " + arfolyamNyereseg);
    }
}