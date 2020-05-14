import KamatozasiVasarlasiStrategia.Inflacio;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

public class InflacioTest
{
    @Test
    public void getEvesInflacioDefault() throws Exception
    {
        Assert.assertTrue(true);
        Inflacio inf = new Inflacio();
        double expected = 0.034;
        assertEquals(expected,inf.getEvesInflacio(2019),0.0);
    }

    @Test
    public void getEvesInflacio2020() throws Exception
    {
        Assert.assertTrue(true);
        Inflacio inf = new Inflacio();
        double expected = 0.039;
        assertEquals(expected,inf.getEvesInflacio(2020),0.0);
    }
}
