import KoltsegStrategia.KoltsegStrategia_KP;
import PenzugyiEszkozok.Valuta;
import PenzugyiEszkozok.Valuta_EUR;
import Portfolio.Egyenleg;
import ValutaStrategia.*;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EURArfolyamNyeresegEsKoltseg
{
    long befektetes1 = 10000000;
    double aktualisEURArfolyam = 360.0;
    final Egyenleg myEgyenleg = Egyenleg.getInstance();

    Valuta otthonitrezorEur = new Valuta_EUR(new Beszerzes_KP(befektetes1),
            new ArfolyamStrategia_EUR(befektetes1,330.0,aktualisEURArfolyam),
            new KoltsegStrategia_KP(befektetes1),
            "Euró beszerzés 2020.02.20.", "EUR");
    double expected1 = (10000000/330.0) * (360.0-330.0);

    @Test
    public void EurArfolyamNyeresegTest() throws Exception
    {
        Assert.assertTrue(true);
        otthonitrezorEur.ArfolyamNyereseg();
        assertEquals(expected1, myEgyenleg.getUtolsoArfolyamNyereseg(),0.0);
    }

    @Test
    public void EurArfolyamKoltsegTest() throws Exception
    {
        Assert.assertTrue(true);
        otthonitrezorEur.KoltsegSzamitas();
        expected1 = 200000 + 100000 + 50000 + 120000 + 250000 + 480000 + 260000;
        assertEquals(expected1, myEgyenleg.getUtolsoKoltseg(),0.0);
    }
}
