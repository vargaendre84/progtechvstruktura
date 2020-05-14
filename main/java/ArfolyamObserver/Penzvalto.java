package ArfolyamObserver;

import java.util.ArrayList;

public class Penzvalto implements ISubject
{
    private ArrayList<IObserver> observers;
    private double EurArfolyam;
    private double USDArfolyam;
    private double kriptoETHArfolyam;

    public Penzvalto()
    {
        observers = new ArrayList<IObserver>();
    }

    @Override
    public void RegisterObserver(IObserver o) {
        observers.add(o);
    }

    @Override
    public void RemoveObserver(IObserver o) {
        int i = observers.indexOf(o);
        if(i >= 0) observers.remove(i);
    }

    @Override
    public void NotifyObservers() {
        for(int i = 0; i < observers.size(); i++)
        {
            IObserver observer = (IObserver)observers.get(i);
            observer.Update(EurArfolyam,USDArfolyam,kriptoETHArfolyam);
        }
    }

    public void MegvaltozottAzArfolyam(){NotifyObservers();}
    public void ArfolyamBeallitas(double EurArfolyam, double USDArfolyam, double kriptoETHArfolyam)
    {
        this.EurArfolyam = EurArfolyam;
        this.USDArfolyam = USDArfolyam;
        this.kriptoETHArfolyam = kriptoETHArfolyam;
        MegvaltozottAzArfolyam();
    }
}
