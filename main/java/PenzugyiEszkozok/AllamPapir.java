package PenzugyiEszkozok;

public abstract class AllamPapir extends PenzugyiEszkoz implements IAllamPapir
{
    public AllamPapir(String nev, String tipus) {
        super(nev, tipus);
    }
    public abstract void Vasarlas();
    public abstract void Kamatozas();
    public abstract void KoltsegSzamitas();
}
