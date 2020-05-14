package KamatozasiVasarlasiStrategia;
import Portfolio.Egyenleg;

public class Kamatozas_Normal extends KamatozasiStrategia
{
    Kamatado kamatado = new Kamatado();
    Egyenleg myEgyenleg = Egyenleg.getInstance();
    private double aktualisKamat;

    public Kamatozas_Normal(long nevErtek, int futamIdo, int lejaratiIdo, double kamat, boolean tbsz)
    {
        super(nevErtek,futamIdo,lejaratiIdo,kamat,tbsz);
    }

    @Override
    public void Kamatozas()
    {
        aktualisKamat = (nevErtek * kamat * (1.0 - kamatado.getKamatado(tbsz))) * futamIdo;
        System.out.println("Kamatozás: " + aktualisKamat);
        myEgyenleg.addKamat(aktualisKamat);
    }
}
