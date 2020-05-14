package KamatozasiVasarlasiStrategia;
import Intezmenyek.Allamkincstar;
import Portfolio.Egyenleg;

public class Vasarlas_MAPPlusz extends VasarlasiStrategia
{
    Allamkincstar allamkincstar = Allamkincstar.getInstance();
    Egyenleg myEgyenleg = Egyenleg.getInstance();

    public Vasarlas_MAPPlusz(long nevErtek) { super(nevErtek); }

    private long vasarolhatoAllomany = allamkincstar.getEladoMAPPluszAllomany();
    @Override
    public void Vasarlas()
    {
        if(nevErtek > vasarolhatoAllomany) nevErtek = vasarolhatoAllomany;
        allamkincstar.AllamPapirErtekesítes_MAPPlusz(nevErtek);
        myEgyenleg.addNevertek(nevErtek);
        System.out.println("Vásárolt MAP Plusz Állomány= " + nevErtek);
    }
}
