package KamatozasiVasarlasiStrategia;
import Portfolio.Egyenleg;

public class Kamatozas_InflacioAlapu extends KamatozasiStrategia
{
    private double kamatPremium;
     private double aktualisKamat;

    Kamatado kamatado = new Kamatado();
    Inflacio inflacio = new Inflacio();
    Egyenleg myEgyenleg = Egyenleg.getInstance();

    public Kamatozas_InflacioAlapu(long nevErtek, int lejaratiIdo, int futamIdo, double kamatPremium, boolean tbsz)
    {
        super(nevErtek,futamIdo,lejaratiIdo,kamatPremium,tbsz);
        this.kamatPremium = kamatPremium;
    }

    @Override
    public void Kamatozas()
    {
        aktualisKamat = 0.0;
        int aktualisEv = 2020;
        if( futamIdo > lejaratiIdo) futamIdo = lejaratiIdo;
        for(int i = 0; i < futamIdo; i++)
        {
            aktualisKamat += nevErtek * (kamatPremium + inflacio.getEvesInflacio(aktualisEv)) * (1.0 - kamatado.getKamatado(tbsz));
            aktualisEv++;
        }
        System.out.println("Kamatozás: " + aktualisKamat) ;
        myEgyenleg.addKamat(aktualisKamat);
    }
}
