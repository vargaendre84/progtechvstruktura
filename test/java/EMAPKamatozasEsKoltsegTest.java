import KamatozasiVasarlasiStrategia.*;
import KoltsegStrategia.KoltsegStrategia_Allampapir_EPSZ;
import PenzugyiEszkozok.AllamPapir;
import PenzugyiEszkozok.Allampapir_EMAP;
import Portfolio.Egyenleg;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

public class EMAPKamatozasEsKoltsegTest
{
    final Egyenleg myEgyenleg = Egyenleg.getInstance();
    int befektetes = 1000000;
    int futamIdo = 3;

    AllamPapir EMAP2021_18 = new Allampapir_EMAP(new Vasarlas_EMAP(befektetes), new Kamatozas_Normal(befektetes,futamIdo,1,0.025,false),
            new KoltsegStrategia_Allampapir_EPSZ(befektetes,1,futamIdo),
            "Egy éves magyar Állampapír 2021-18", "EMAP");
    double expected1 = 1000000 * 0.025 * (1-0.15) * 3;

    @Test
    public void EMAPKamatTest() throws Exception
    {
        Assert.assertTrue(true);
        EMAP2021_18.Kamatozas();
        assertEquals(expected1, myEgyenleg.getUtolsoKamat(),0.0);
    }

    double expected3 = 1000000 * 0.0022 *3 ;
    @Test
    public void EMAPKoltsegTest() throws Exception
    {
        Assert.assertTrue(true);
        EMAP2021_18.KoltsegSzamitas();
        assertEquals(expected3, myEgyenleg.getUtolsoKoltseg() ,0.0);
    }

    @Test
    public void ZgetMerlegTest() throws Exception
    {
        Assert.assertTrue(true);
        assertEquals(expected1 - expected3, myEgyenleg.getUtolsoTranzakcioMerleg(),0.0);
    }
}
