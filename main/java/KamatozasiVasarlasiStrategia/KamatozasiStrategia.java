package KamatozasiVasarlasiStrategia;

public abstract class KamatozasiStrategia
{
    protected long nevErtek;
    protected int futamIdo;
    protected int lejaratiIdo;
    protected double kamat;
    protected boolean tbsz;
    public KamatozasiStrategia(long nevErtek, int futamIdo, int lejaratiIdo, double kamat, boolean tbsz)
    {
        this.nevErtek = nevErtek;
        this.futamIdo = futamIdo;
        this.lejaratiIdo = lejaratiIdo;
        this.kamat = kamat;
        this.tbsz = tbsz;
    }

    public abstract void Kamatozas();
}
