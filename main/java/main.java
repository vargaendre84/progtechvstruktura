import KoltsegDecorator.IKoltseg;
import KoltsegDecorator.Koltseg_Alap;
import KoltsegDecorator.Koltseg_Aram;
import KoltsegDecorator.Koltseg_BanyaGep;
import PenzugyiEszkozok.*;
import Portfolio.Eredmeny;
import ValutaStrategia.EthereumBlokklanc;
import ArfolyamObserver.*;
import KamatozasiVasarlasiStrategia.*;
import Intezmenyek.Allamkincstar;
import Intezmenyek.Jegybank;
import KoltsegStrategia.*;
import Portfolio.Egyenleg;
import ValutaStrategia.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

    public static void main(String[] args) throws IOException
    {
        Jegybank jegybank = Jegybank.getInstance();
        Allamkincstar allamkincstar = Allamkincstar.getInstance();
        Egyenleg myEgyenleg = Egyenleg.getInstance();
        EthereumBlokklanc blokklanc = EthereumBlokklanc.getInstance();

        long befektetes1 = 100000;
        int futamIdo = 3;
        int lejaratiIdo1 = 1;
        int lejaratiIdo5 = 5;
        double alapkamat25 = 0.025;
        double alapkamat35 = 0.035;
        double kamatpremium = 0.014;
        double bankikamat = 0.0001;
        double kamatvaltozas = 0.005;
        double veteliEURArfolyam = 320.0;
        double veteliUSDArfolyam = 328.0;
        double veteliETHArfolyam = 65570;
        double aktualisEURArfolyam = 360.0;  //2020.05.14
        double aktualisUSDArfolyam = 331.0;  //2020.05.14
        double aktualisETHArfolyam = 66712;  // 2020.05.14
        int cimletErtek = allamkincstar.getCimletErtek();
        int cimletekMaxSzama = allamkincstar.getCimletekMaxSzama();

        Eredmeny[] eredmenyek = new Eredmeny[9];
        eredmenyek[0] = new Eredmeny();
        eredmenyek[1] = new Eredmeny();
        eredmenyek[2] = new Eredmeny();
        eredmenyek[3] = new Eredmeny();
        eredmenyek[4] = new Eredmeny();
        eredmenyek[5] = new Eredmeny();
        eredmenyek[6] = new Eredmeny();
        eredmenyek[7] = new Eredmeny();
        eredmenyek[8] = new Eredmeny();

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        /*System.out.println("Adja meg milyen összeget akar befektetni: (magyar Forint)");
        befektetes1 = Integer.parseInt(reader.readLine());
        System.out.println("Hány évre szeretné lekötni? (maximum 5év lehetséges) ");
        futamIdo = Integer.parseInt(reader.readLine());
        if (futamIdo < 1) futamIdo = 1;
        else if (futamIdo > 5) futamIdo = 5;
*/
        System.out.println("");
        Penzvalto penzvalto = new Penzvalto();
        Arfolyam_Euro euroValuta = new Arfolyam_Euro(penzvalto);
        Arfolyam_USD dollarValuta = new Arfolyam_USD(penzvalto);
        Arfolyam_Kripto_Ethereum ethValuta = new Arfolyam_Kripto_Ethereum(penzvalto);

        /*System.out.print("Adja meg az aktuális EUR vételi árfolyamot: ");
        aktualisEURArfolyam = Double.parseDouble(reader.readLine());
        System.out.print("Adja meg az aktuális USD vételi árfolyamot: ");
        aktualisUSDArfolyam = Double.parseDouble(reader.readLine());
        System.out.print("Adja meg az aktuális Ethereum vételi árfolyamot: ");
        aktualisETHArfolyam = Double.parseDouble(reader.readLine());
        penzvalto.ArfolyamBeallitas(aktualisEURArfolyam,aktualisUSDArfolyam,aktualisETHArfolyam);
*/
        System.out.println("Aktuális EUR, USD és ETH árfolyam frissítve: ");
        euroValuta.Display();
        dollarValuta.Display();
        ethValuta.Display();

        allamkincstar.AllamPapirKibocsatas_PMAP(cimletErtek * cimletekMaxSzama);
        allamkincstar.AllamPapirKibocsatas_EMAP(cimletErtek * cimletekMaxSzama);
        allamkincstar.AllamPapirKibocsatas_MAPPlusz(cimletErtek * cimletekMaxSzama / 2);

        System.out.println("");
        AllamPapir EMAP2021_18 = new Allampapir_EMAP(new Vasarlas_EMAP(befektetes1), new Kamatozas_Normal(befektetes1,futamIdo,lejaratiIdo1,alapkamat25,false),
                new KoltsegStrategia_Allampapir_EPSZ(befektetes1,lejaratiIdo1,futamIdo),
                "EMAP 2021-18","Egyéves Állampapír értékpapír számlára");
        AllamPapir PMAP2025J = new Allampapir_PMAP(new Vasarlas_PMAP(befektetes1), new Kamatozas_InflacioAlapu(befektetes1,lejaratiIdo5,futamIdo,kamatpremium,true),
                new KoltsegStrategia_Allampapir_Alap(befektetes1,lejaratiIdo5,futamIdo),
                "PMAP 2025-J", "Prémium Állampapír Államkincstár számlára");
        AllamPapir MAPPluszN2025_19 = new Allampapir_MAPPlusz(new Vasarlas_MAPPlusz(befektetes1),
                new Kamatozas_Savos_Periodusos_Egyenletes(befektetes1,lejaratiIdo5,futamIdo,alapkamat35,lejaratiIdo1,kamatvaltozas),
                new KoltsegStrategia_Allampapir_Alap(befektetes1,lejaratiIdo5,futamIdo),
                "MAP Plusz N2025/19", "MÁP Plusz Állampapír Államkincstár számlára");

        System.out.println("");
        System.out.println(EMAP2021_18.getNev()  + " " + EMAP2021_18.getTipus());
        EMAP2021_18.Vasarlas();
        EMAP2021_18.Kamatozas();
        EMAP2021_18.KoltsegSzamitas();
        eredmenyek[0].nev = EMAP2021_18.getNev();
        eredmenyek[0].tipus = EMAP2021_18.getTipus();
        eredmenyek[0].nevErtek = myEgyenleg.getUtolsoHozzaadottNevertek();
        eredmenyek[0].hozam = myEgyenleg.getUtolsoKamat();
        eredmenyek[0].koltseg = myEgyenleg.getUtolsoKoltseg();
        eredmenyek[0].merleg = myEgyenleg.getUtolsoTranzakcioMerleg();

        System.out.println(PMAP2025J.getNev() + " " + PMAP2025J.getTipus());
        PMAP2025J.Vasarlas();
        PMAP2025J.Kamatozas();
        PMAP2025J.KoltsegSzamitas();
        eredmenyek[1].nev = PMAP2025J.getNev();
        eredmenyek[1].nevErtek = myEgyenleg.getUtolsoHozzaadottNevertek();
        eredmenyek[1].tipus = PMAP2025J.getTipus();
        eredmenyek[1].hozam = myEgyenleg.getUtolsoKamat();
        eredmenyek[1].koltseg = myEgyenleg.getUtolsoKoltseg();
        eredmenyek[1].merleg = myEgyenleg.getUtolsoTranzakcioMerleg();
        System.out.println(MAPPluszN2025_19.getNev());
        MAPPluszN2025_19.Vasarlas();
        MAPPluszN2025_19.Kamatozas();
        MAPPluszN2025_19.KoltsegSzamitas();
        eredmenyek[2].nev = MAPPluszN2025_19.getNev();
        eredmenyek[2].nevErtek = myEgyenleg.getUtolsoHozzaadottNevertek();
        eredmenyek[2].tipus = MAPPluszN2025_19.getTipus();
        eredmenyek[2].hozam = myEgyenleg.getUtolsoKamat();
        eredmenyek[2].koltseg = myEgyenleg.getUtolsoKoltseg();
        eredmenyek[2].merleg = myEgyenleg.getUtolsoTranzakcioMerleg();

        BankBetet otpBankBetet = new BankBetet(new Beszerzes_Utalas(befektetes1),
                new Kamatozas_Normal(befektetes1,futamIdo,lejaratiIdo1,bankikamat,false),
                new KoltsegStrategia_Bank(befektetes1,futamIdo),
                "OTP Bank 2020 Április", "Forintos Bankszámla");
        System.out.println("");
        System.out.println(otpBankBetet.getNev() + " " +  otpBankBetet.getTipus());
        otpBankBetet.Beszerzes();
        otpBankBetet.Kamatozas();
        otpBankBetet.KoltsegSzamitas();
        eredmenyek[3].nev = otpBankBetet.getNev();
        eredmenyek[3].nevErtek = myEgyenleg.getUtolsoHozzaadottNevertek();
        eredmenyek[3].tipus = otpBankBetet.getTipus();
        eredmenyek[3].hozam = myEgyenleg.getUtolsoKamat();
        eredmenyek[3].koltseg = myEgyenleg.getUtolsoKoltseg();
        eredmenyek[3].merleg = myEgyenleg.getUtolsoTranzakcioMerleg();

        Valuta otthonitrezor = new Valuta_HUF(new Beszerzes_KP(befektetes1),
                new ArfolyamStrategia_HUF(befektetes1),
                new KoltsegStrategia_KP(befektetes1),
                "Forint KP megtakarítás Otthoni trezorban", "HUF Valuta");
        Valuta parnaCihaEur = new Valuta_EUR(new Beszerzes_KP(befektetes1),
                new ArfolyamStrategia_EUR(befektetes1,veteliEURArfolyam,aktualisEURArfolyam),
                new KoltsegStrategia_KP_ParnaCiha(befektetes1),
                "Euró beszerzés 2020.02.20.", "EUR Valuta");
        Valuta parnaCihaUSD = new Valuta_USD(new Beszerzes_KP(befektetes1),
                new ArfolyamStrategia_USD(befektetes1,veteliUSDArfolyam,aktualisUSDArfolyam),
                new KoltsegStrategia_KP_ParnaCiha(befektetes1),
                "USD beszerzés 2020.04.21.", "USD Valuta");
        System.out.println("");
        System.out.println(otthonitrezor.getNev() + " " + otthonitrezor.getTipus());
        otthonitrezor.Beszerzes();
        otthonitrezor.ArfolyamNyereseg();
        otthonitrezor.KoltsegSzamitas();
        eredmenyek[4].nev = otthonitrezor.getNev();
        eredmenyek[4].nevErtek = myEgyenleg.getUtolsoHozzaadottNevertek();
        eredmenyek[4].tipus = otthonitrezor.getTipus();
        eredmenyek[4].hozam = myEgyenleg.getUtolsoArfolyamNyereseg();
        eredmenyek[4].koltseg = myEgyenleg.getUtolsoKoltseg();
        eredmenyek[4].merleg = myEgyenleg.getUtolsoTranzakcioMerleg();

        System.out.println(parnaCihaEur.getNev()  + " " + parnaCihaEur.getTipus());
        parnaCihaEur.Beszerzes();
        parnaCihaEur.ArfolyamNyereseg();
        parnaCihaEur.KoltsegSzamitas();
        eredmenyek[5].nev = parnaCihaEur.getNev();
        eredmenyek[5].nevErtek = myEgyenleg.getUtolsoHozzaadottNevertek();
        eredmenyek[5].tipus = parnaCihaEur.getTipus();
        eredmenyek[5].hozam = myEgyenleg.getUtolsoArfolyamNyereseg();
        eredmenyek[5].koltseg = myEgyenleg.getUtolsoKoltseg();
        eredmenyek[5].merleg = myEgyenleg.getUtolsoTranzakcioMerleg();

        System.out.println(parnaCihaUSD.getNev()  + " " + parnaCihaUSD.getTipus());
        parnaCihaUSD.Beszerzes();
        parnaCihaUSD.ArfolyamNyereseg();
        parnaCihaUSD.KoltsegSzamitas();
        eredmenyek[6].nev = parnaCihaUSD.getNev();
        eredmenyek[6].nevErtek = myEgyenleg.getUtolsoHozzaadottNevertek();
        eredmenyek[6].tipus = parnaCihaUSD.getTipus();
        eredmenyek[6].hozam = myEgyenleg.getUtolsoArfolyamNyereseg();
        eredmenyek[6].koltseg = myEgyenleg.getUtolsoKoltseg();
        eredmenyek[6].merleg = myEgyenleg.getUtolsoTranzakcioMerleg();

        KriptoValuta ethereum2020 = new Kripto_Ethereum(new Beszerzes_Utalas(befektetes1),
                new ArfolyamStrategia_Kripto_Ethereum(befektetes1,veteliETHArfolyam,aktualisETHArfolyam),
                new KoltsegStrategia_KriptoValuta(befektetes1),"Ethereum 2020","KriptoValuta" );
        System.out.println("");
        System.out.println(ethereum2020.getNev() + " " + ethereum2020.getTipus());
        ethereum2020.Beszerzes();
        ethereum2020.ArfolyamNyereseg();
        ethereum2020.KoltsegSzamitas();
        eredmenyek[7].nev = ethereum2020.getNev();
        eredmenyek[7].nevErtek = myEgyenleg.getUtolsoHozzaadottNevertek();
        eredmenyek[7].tipus = ethereum2020.getTipus();
        eredmenyek[7].hozam = myEgyenleg.getUtolsoArfolyamNyereseg();
        eredmenyek[7].koltseg = myEgyenleg.getUtolsoKoltseg();
        eredmenyek[7].merleg = myEgyenleg.getUtolsoTranzakcioMerleg();

        Banyaszat banyagep1 = new Banyaszat();
        KriptoValuta[] ethSorozat = banyagep1.kibocsatas(ethereum2020,"Bányászott Ethereum kriptovaluta",futamIdo);
        blokklanc.ujBanyaszottMennyisegHozzaadasa(ethSorozat.length);
        System.out.println(ethSorozat.length + " egységnyi Ethereum létrehozva és hozzáadva a Blokklánchoz");
        myEgyenleg.addNevertek(ethSorozat.length*(long)aktualisETHArfolyam);
        myEgyenleg.addArfolyamNyereseg(ethSorozat.length*(long)aktualisETHArfolyam);
        IKoltseg banyaszatiKoltseg = new Koltseg_Aram(new Koltseg_BanyaGep(new Koltseg_Alap()));
        double aktualisKoltseg = banyaszatiKoltseg.getKoltseg(ethSorozat.length,futamIdo);
        myEgyenleg.addKoltseg(aktualisKoltseg);

        System.out.println("A bányászat költsége = " + aktualisKoltseg);
        eredmenyek[8].nev = "Bányászott" + ethSorozat[0].getNev();
        eredmenyek[8].nevErtek = myEgyenleg.getUtolsoHozzaadottNevertek();
        eredmenyek[8].tipus = ethSorozat[0].getNev();
        eredmenyek[8].hozam = myEgyenleg.getUtolsoArfolyamNyereseg();
        eredmenyek[8].koltseg = myEgyenleg.getUtolsoKoltseg();
        eredmenyek[8].merleg = myEgyenleg.getUtolsoTranzakcioMerleg();

        System.out.println("");
        System.out.println("A portfólió összes névértéke= " + (long)myEgyenleg.getOsszesNevErtek());
        System.out.println("A portfólió összes kamata= " + (long)myEgyenleg.getOsszesKamat());
        System.out.println("A portfólió összes költsége= " + (long)myEgyenleg.getOsszesKoltseg());
        System.out.println("A portfólió egyenlege= " + (long)myEgyenleg.getMerleg());

        Eredmeny kivalasztottBefektetes = eredmenyek[0];
        for(Eredmeny temp : eredmenyek)
        {
            if( temp.hozam > kivalasztottBefektetes.hozam)
                kivalasztottBefektetes = temp;
        }
        System.out.println("");
        System.out.println("A legjobb hozamú befektetés neve, típusa: " + kivalasztottBefektetes.nev + " " + kivalasztottBefektetes.tipus);
        System.out.println(" -névértéke: " + kivalasztottBefektetes.nevErtek);
        System.out.println(" -hozama: " + kivalasztottBefektetes.hozam);
        System.out.println(" -költsége: " + kivalasztottBefektetes.koltseg);
        System.out.println(" -mérlege: " + kivalasztottBefektetes.merleg);

        for(Eredmeny temp : eredmenyek)
        {
            if( temp.merleg > kivalasztottBefektetes.merleg)
                kivalasztottBefektetes = temp;
        }
        System.out.println("");
        System.out.println("A legjobb mérlegű befektetés neve, típusa: " + kivalasztottBefektetes.nev + " " + kivalasztottBefektetes.tipus);
        System.out.println(" -névértéke: " + kivalasztottBefektetes.nevErtek);
        System.out.println(" -hozama: " + kivalasztottBefektetes.hozam);
        System.out.println(" -költsége: " + kivalasztottBefektetes.koltseg);
        System.out.println(" -mérlege: " + kivalasztottBefektetes.merleg);

        System.out.println("");
        for(int i = 0; i < eredmenyek.length; i++)
        {
            System.out.println(eredmenyek[i].nev + " " + eredmenyek[i].hozam + " " + eredmenyek[i].koltseg + " " + eredmenyek[i].merleg);
        }
    }
}