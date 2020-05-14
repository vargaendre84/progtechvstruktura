import KoltsegStrategia.KoltsegStrategia_KP;
import Portfolio.Egyenleg;
import ValutaStrategia.ArfolyamStrategia_USD;
import ValutaStrategia.Beszerzes_KP;
import PenzugyiEszkozok.Valuta_USD;
import PenzugyiEszkozok.Valuta;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class USDArfolyamNyeresegtest
{
    long befektetes2 = 1000000;
    double aktualisUSDArfolyam = 321.0;
    final Egyenleg myEgyenleg = Egyenleg.getInstance();

    Valuta otthonitrezorUSD = new Valuta_USD(new Beszerzes_KP(befektetes2),
            new ArfolyamStrategia_USD(befektetes2,335.0,aktualisUSDArfolyam),
            new KoltsegStrategia_KP(befektetes2),
            "USD beszerzés 2020.04.21.", "USD");
    double expected2 = (1000000/335.0) * (321.0-335.0) ;

    @Test
    public void USDArfolyamNyeresegTest() throws Exception
    {
        Assert.assertTrue(true);
        otthonitrezorUSD.ArfolyamNyereseg();
        assertEquals(expected2, myEgyenleg.getUtolsoArfolyamNyereseg(),0.1);
    }
}
