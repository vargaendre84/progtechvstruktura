package Portfolio;

public class Egyenleg    //greedy singleton
{
    public String portfolio;
    private static final Egyenleg instance = new Egyenleg();
    private Egyenleg() {}
    public static Egyenleg getInstance()
    {
        return instance;
    }

    private long osszesNevErtek;
    private long utolsoHozzaadottNevertek;
    private double osszesKamat;
    private double utolsoHozzaadottKamat;
    private double osszesKoltseg;
    private double utolsoHozzaadottKoltseg;
    private double osszesArfolyamNyereseg;
    private double utolsoHozzaadottArfolyamNyereseg;
    private boolean otthoniTrezorKialakitva;

    public Egyenleg(int osszesNevErtek, double osszesKamat, double osszesKoltseg, double osszesArfolyamNyereseg, boolean otthoniTrezorKialakitva)
    {
        this.osszesNevErtek = osszesNevErtek;
        this.osszesKamat = osszesKamat;
        this.osszesKoltseg = osszesKoltseg;
        this.osszesArfolyamNyereseg = osszesArfolyamNyereseg;
        this.otthoniTrezorKialakitva = otthoniTrezorKialakitva;
    }

    public long getUtolsoHozzaadottNevertek() { return utolsoHozzaadottNevertek; }
    public long getOsszesNevErtek() { return osszesNevErtek; }
    public void addNevertek(long novekmeny)
    {
        osszesNevErtek += novekmeny;
        utolsoHozzaadottNevertek = novekmeny;
    }
    public double getUtolsoKamat() { return utolsoHozzaadottKamat; }
    public double getOsszesKamat() { return osszesKamat; }
    public void addKamat(double novekmeny)
    {
        osszesKamat += novekmeny;
        utolsoHozzaadottKamat = novekmeny;
        utolsoHozzaadottArfolyamNyereseg = 0;
    }
    public double getUtolsoKoltseg() { return utolsoHozzaadottKoltseg; }
    public double getOsszesKoltseg() { return osszesKoltseg; }
    public void addKoltseg(double novekmeny)
    {
        utolsoHozzaadottKoltseg = novekmeny;
        osszesKoltseg += novekmeny;
    }
    public void setUtolsoKoltseg(double novekmeny)
    {
        utolsoHozzaadottKoltseg = novekmeny;
    }
    public double getUtolsoArfolyamNyereseg() { return utolsoHozzaadottArfolyamNyereseg; }
    public double getOsszesArfolyamNyereseg() { return osszesArfolyamNyereseg; }
    public void addArfolyamNyereseg(double novekmeny)
    {
        osszesArfolyamNyereseg += novekmeny;
        utolsoHozzaadottArfolyamNyereseg = novekmeny;
        utolsoHozzaadottKamat = 0;
    }

    public double getUtolsoTranzakcioMerleg() {return (utolsoHozzaadottKamat + utolsoHozzaadottArfolyamNyereseg - utolsoHozzaadottKoltseg);}
    public double getMerleg() {return (osszesKamat + osszesArfolyamNyereseg - osszesKoltseg);}

    public boolean getOtthoniTrezorKialakitva() {return otthoniTrezorKialakitva;}
    public void setOtthoniTrezorKialakitva(boolean ertek) { otthoniTrezorKialakitva = ertek;}
}