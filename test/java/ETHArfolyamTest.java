import KoltsegStrategia.KoltsegStrategia_KriptoValuta;
import PenzugyiEszkozok.Kripto_Ethereum;
import PenzugyiEszkozok.Valuta;
import Portfolio.Egyenleg;
import ValutaStrategia.ArfolyamStrategia_Kripto_Ethereum;
import ValutaStrategia.Beszerzes_Utalas;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ETHArfolyamTest
{
    long befektetes2 = 1000000;
    double aktualisETHArfolyam = 65800;
    final Egyenleg myEgyenleg = Egyenleg.getInstance();

    Valuta ethereum2020 = new Kripto_Ethereum(new Beszerzes_Utalas(befektetes2),
            new ArfolyamStrategia_Kripto_Ethereum(befektetes2,65570,aktualisETHArfolyam),
            new KoltsegStrategia_KriptoValuta(befektetes2),
            "Ethereum 2020.04.21.", "ETH");
    double expected2 = ((double)1000000/65570) * (65800.0-65570) ;

    @Test
    public void ETHArfolyamNyeresegTest() throws Exception
    {
        Assert.assertTrue(true);
        ethereum2020.ArfolyamNyereseg();
        assertEquals(expected2, myEgyenleg.getUtolsoArfolyamNyereseg(),0.0);
    }
}
