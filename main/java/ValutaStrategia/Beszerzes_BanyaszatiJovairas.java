package ValutaStrategia;

public class Beszerzes_BanyaszatiJovairas extends BeszerzesiStrategia
{
    EthereumBlokklanc blokklanc = EthereumBlokklanc.getInstance();
    private double nevErtek;
    public Beszerzes_BanyaszatiJovairas(double nevErtek) { this.nevErtek = nevErtek; }

    @Override
    public void Beszerzes()
    {
        blokklanc.ujBanyaszottMennyisegHozzaadasa(nevErtek);
        System.out.println("Bányászott Ether Állomány= " + nevErtek);
    }

}
