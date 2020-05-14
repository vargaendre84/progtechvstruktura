import KoltsegDecorator.IKoltseg;
import KoltsegDecorator.Koltseg_Alap;
import KoltsegDecorator.Koltseg_Aram;
import KoltsegDecorator.Koltseg_BanyaGep;
import KoltsegStrategia.KoltsegStrategia_KriptoValuta;
import PenzugyiEszkozok.KriptoValuta;
import PenzugyiEszkozok.Kripto_Ethereum;
import Portfolio.Egyenleg;
import ValutaStrategia.ArfolyamStrategia_Kripto_Ethereum;
import ValutaStrategia.Banyaszat;
import ValutaStrategia.Beszerzes_Utalas;
import ValutaStrategia.EthereumBlokklanc;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BanyaszatMennyisegKoltseg
{
    long befektetes1 = 1000000;
    double veteliETHArfolyam = 65500;
    double aktualisETHArfolyam = 65800;
    int futamIdo = 5;
    final Egyenleg myEgyenleg = Egyenleg.getInstance();
    EthereumBlokklanc blokklanc = EthereumBlokklanc.getInstance();

    KriptoValuta ethereum2020 = new Kripto_Ethereum(new Beszerzes_Utalas(befektetes1),
            new ArfolyamStrategia_Kripto_Ethereum(befektetes1,veteliETHArfolyam,aktualisETHArfolyam),
            new KoltsegStrategia_KriptoValuta(befektetes1),"Ethereum 2020","KriptoValuta" );
    Banyaszat banyagep1 = new Banyaszat();
    int mennyiseg = 0;

    @Test
    public void ALetrehozottMennyisegTest() throws Exception
    {
        KriptoValuta[] ethSorozat = banyagep1.kibocsatas(ethereum2020,"Bányászott Ethereum kriptovaluta",futamIdo);
        mennyiseg = ethSorozat.length;
        blokklanc.ujBanyaszottMennyisegHozzaadasa(mennyiseg);
        System.out.println(ethSorozat.length + " egységnyi Ethereum létrehozva és hozzáadva a Blokklánchoz");
        Assert.assertTrue(true);
        double expected = 14;
        assertEquals(expected, mennyiseg,0.0);
    }

    @Test
    public void BanyaszatiKoltsegTest() throws Exception
    {
        IKoltseg banyaszatiKoltseg = new Koltseg_Aram(new Koltseg_BanyaGep(new Koltseg_Alap()));
        double aktualisKoltseg = banyaszatiKoltseg.getKoltseg(mennyiseg,futamIdo);
        myEgyenleg.addKoltseg(aktualisKoltseg);
        Assert.assertTrue(true);
        double expected = 1500000 + futamIdo * 200000;
        assertEquals(expected, aktualisKoltseg,0.0);
    }
}
