import KamatozasiVasarlasiStrategia.Kamatado;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

public class KamatadoTest
{
    @Test
    public void getKamatAdoTbsz() throws Exception
    {
        Assert.assertTrue(true);
        Kamatado kamatado = new Kamatado();
        double expected = 0.0;
        assertEquals(expected,kamatado.getKamatado(true),0.0);
    }

    @Test
    public void getKamatAdoNemTbsz() throws Exception
    {
        Assert.assertTrue(true);
        Kamatado kamatado = new Kamatado();
        double expected = 0.15;
        assertEquals(expected,kamatado.getKamatado(false),0.0);
    }
}
