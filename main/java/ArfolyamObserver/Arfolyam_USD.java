package ArfolyamObserver;

public class Arfolyam_USD implements IDisplay,IObserver
{
    private double usdArfolyam;
    private ISubject penzvalto;

    public Arfolyam_USD(ISubject penzvalto )
    {
        this.penzvalto = penzvalto;
        penzvalto.RegisterObserver(this);
    }

    @Override
    public void Update(double eurArfolyam, double usdArfolyam,double kriptoETHArfolyam)
    {
        this.usdArfolyam = usdArfolyam;
    }

    public double getArfolyam()
    {
        return usdArfolyam;
    }

    @Override
    public void Display()
    {
        System.out.println("Az amerikai dollár árfolyama: " + usdArfolyam);
    }
}
