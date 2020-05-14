import ArfolyamObserver.Arfolyam_Euro;
import ArfolyamObserver.Arfolyam_Kripto_Ethereum;
import ArfolyamObserver.Arfolyam_USD;
import ArfolyamObserver.Penzvalto;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class ArfolyamTest
{
    Penzvalto penzvalto = new Penzvalto();
    Arfolyam_Euro euroValuta = new Arfolyam_Euro(penzvalto);
    Arfolyam_USD dollarValuta = new Arfolyam_USD(penzvalto);
    Arfolyam_Kripto_Ethereum ethValuta = new Arfolyam_Kripto_Ethereum(penzvalto);
    double tesztEURArfolyam = 360.0;
    double tesztUSDArfolyam = 321.0;
    double tesztETHArfolyam = 65410;

    @Test
    public void getEURArfolyam() throws Exception
    {
        penzvalto.ArfolyamBeallitas(tesztEURArfolyam,tesztUSDArfolyam,tesztETHArfolyam);
        Assert.assertTrue(true);
        double expected = 360.0;
        assertEquals(expected,euroValuta.getArfolyam(),0.01);
    }

    @Test
    public void getUSDArfolyam() throws Exception
    {
        penzvalto.ArfolyamBeallitas(tesztEURArfolyam,tesztUSDArfolyam,tesztETHArfolyam);
        Assert.assertTrue(true);
        double expected = 321.0;
        assertEquals(expected, dollarValuta.getArfolyam(),0.01);;
    }

    @Test
    public void getETHArfolyam() throws Exception
    {
        penzvalto.ArfolyamBeallitas(tesztEURArfolyam,tesztUSDArfolyam,tesztETHArfolyam);
        Assert.assertTrue(true);
        double expected = 65410;
        assertEquals(expected, ethValuta.getArfolyam(),0.01);;
    }
}

