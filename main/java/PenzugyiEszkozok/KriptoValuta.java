package PenzugyiEszkozok;

public abstract class KriptoValuta extends Valuta
{
    public KriptoValuta(String nev, String tipus) {
        super(nev, tipus);
    }
    public abstract void Beszerzes();
    public abstract void ArfolyamNyereseg();
    public abstract void KoltsegSzamitas();
    public abstract Object Clone();
}
