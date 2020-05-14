package PenzugyiEszkozok;
import KamatozasiVasarlasiStrategia.KamatozasiStrategia;
import KamatozasiVasarlasiStrategia.VasarlasiStrategia;
import KoltsegStrategia.KoltsegStrategia;

public class Allampapir_PMAP extends AllamPapir
{
    VasarlasiStrategia vasarlas;
    KamatozasiStrategia kamat;
    KoltsegStrategia koltseg;

    public Allampapir_PMAP(VasarlasiStrategia vasarlas, KamatozasiStrategia kamat, KoltsegStrategia koltseg, String nev, String tipus)
    {
        super(nev, tipus);
        this.vasarlas = vasarlas;
        this.kamat = kamat;
        this.koltseg = koltseg;
    }

    @Override
    public void Vasarlas() {vasarlas.Vasarlas();}
    @Override
    public void Kamatozas() {
        kamat.Kamatozas();
    }
    @Override
    public void KoltsegSzamitas(){koltseg.KoltsegSzamitas();}

}
