import KamatozasiVasarlasiStrategia.*;
import KoltsegStrategia.KoltsegStrategia_Allampapir_JutalekEPSZ;
import PenzugyiEszkozok.AllamPapir;
import PenzugyiEszkozok.Allampapir_PMAP;
import Portfolio.Egyenleg;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PMAPKamatozasEsKoltsegTest
{
    final Egyenleg myEgyenleg = Egyenleg.getInstance();
    int befektetes = 1000000;
    int futamIdo = 3;

    AllamPapir PMAP2025J = new Allampapir_PMAP(new Vasarlas_PMAP(befektetes) , new Kamatozas_InflacioAlapu(befektetes,5,futamIdo,0.014,false),
            new KoltsegStrategia_Allampapir_JutalekEPSZ(befektetes,5,futamIdo),
            "Prémium Magyar Állampapír 2025-J", "PMAP");
    double expected2 =  1000000 * (0.014 + 0.039) * (1 - 0.15) +
            1000000 * (0.014 + 0.055) * (1 - 0.15) +
            1000000 * (0.014 + 0.048) * (1 - 0.15);

    @Test
    public void PMAPKamatTest() throws Exception
    {
        Assert.assertTrue(true);
        PMAP2025J.Kamatozas();
        assertEquals(expected2, myEgyenleg.getUtolsoKamat(),0.0);
    }

    double expected4 = 1000000 * 0.01 * 3 + 1000000*0.0022*3 + 1000000 * 0.02;
    @Test
    public void PMAPKoltsegTest() throws Exception
    {
        Assert.assertTrue(true);
        PMAP2025J.KoltsegSzamitas();
        assertEquals(expected4, myEgyenleg.getUtolsoKoltseg(),0.0);
    }

    @Test
    public void ZgetMerlegTest() throws Exception
    {
        Assert.assertTrue(true);
        assertEquals(expected2 - expected4, myEgyenleg.getUtolsoTranzakcioMerleg(),0.0);
    }
}
