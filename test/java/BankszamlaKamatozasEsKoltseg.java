import KamatozasiVasarlasiStrategia.Kamatozas_Normal;
import KoltsegStrategia.KoltsegStrategia_Bank;
import Portfolio.Egyenleg;
import PenzugyiEszkozok.BankBetet;
import ValutaStrategia.Beszerzes_Utalas;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BankszamlaKamatozasEsKoltseg
{
    long befektetes1 = 3000000;
    int futamIdo = 3;
    final Egyenleg myEgyenleg = Egyenleg.getInstance();
    BankBetet otpBankBetet = new BankBetet(new Beszerzes_Utalas(befektetes1),
            new Kamatozas_Normal(befektetes1,futamIdo,1,0.0001,false),
            new KoltsegStrategia_Bank(befektetes1,futamIdo),
            "OTP BankBetét 2020 Április", "OTP Bank betét");
    double expected = 3000000 * 0.0001 * 3 * 0.85;

    @Test
    public void BankSzamlaKamatTest() throws Exception
    {
        Assert.assertTrue(true);
        otpBankBetet.Kamatozas();
        assertEquals(expected, myEgyenleg.getUtolsoKamat(),0.0);
    }

    double expected1 = 0;
    @Test
    public void BankSzamlaKoltsegTest() throws Exception
    {
        Assert.assertTrue(true);
        otpBankBetet.KoltsegSzamitas();

        assertEquals(expected1, myEgyenleg.getUtolsoKoltseg(),0.0);
    }
}
