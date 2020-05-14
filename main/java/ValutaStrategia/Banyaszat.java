package ValutaStrategia;
import PenzugyiEszkozok.KriptoValuta;

public class Banyaszat
{
    private int egyETHBanyaszatNapokSzama = 124;
    public static int egyEvNapokSzama = 365;

    public KriptoValuta[] kibocsatas(KriptoValuta ethereum, String nev, int futamIdo)
    {
        int mennyiseg = futamIdo * egyEvNapokSzama / egyETHBanyaszatNapokSzama;
        KriptoValuta[] temp = new KriptoValuta[mennyiseg];
        for (int i = 0; i < mennyiseg; i++)
        {
            temp[i] = (KriptoValuta)ethereum.Clone();
        }
        System.out.println(temp.length + " egységnyi " + nev + " lett kibányászva " + futamIdo + " év alatt");
        return temp;
    }
}
