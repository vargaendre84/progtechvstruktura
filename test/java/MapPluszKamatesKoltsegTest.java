import KamatozasiVasarlasiStrategia.*;
import KoltsegStrategia.KoltsegStrategia_Allampapir_Jutalek;
import PenzugyiEszkozok.AllamPapir;
import PenzugyiEszkozok.Allampapir_MAPPlusz;
import Portfolio.Egyenleg;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MapPluszKamatesKoltsegTest {
    final Egyenleg myEgyenleg = Egyenleg.getInstance();
    int befektetes = 1000000;
    int futamIdo = 3;

    AllamPapir MAPPluszN2025_19 = new Allampapir_MAPPlusz(new Vasarlas_MAPPlusz(befektetes),
            new Kamatozas_Savos_Periodusos_Egyenletes(befektetes, 5, futamIdo, 0.035, 1, 0.005),
            new KoltsegStrategia_Allampapir_Jutalek(befektetes, 5, futamIdo),
            "MAP Plusz N2025/19", "MAP Plusz");
    double expected2 = 1000000*0.035 + 1000000*0.04 + 1000000*0.045;

    @Test
    public void MAPPluszKamatTest() throws Exception {
        Assert.assertTrue(true);
        MAPPluszN2025_19.Kamatozas();
        assertEquals(expected2, myEgyenleg.getUtolsoKamat(), 0.0);
    }

    double expected4 = 1000000 * 0.01 * 3 + 1000000*0.02;

    @Test
    public void MAPPluszKoltsegTest() throws Exception {
        Assert.assertTrue(true);
        MAPPluszN2025_19.KoltsegSzamitas();
        assertEquals(expected4, myEgyenleg.getUtolsoKoltseg(), 0.0);
    }

    @Test
    public void ZgetMerlegTest() throws Exception {
        Assert.assertTrue(true);
        assertEquals(expected2 - expected4, myEgyenleg.getUtolsoTranzakcioMerleg(), 0.0);
    }
}