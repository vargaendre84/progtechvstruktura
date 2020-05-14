package KamatozasiVasarlasiStrategia;
import Intezmenyek.Allamkincstar;
import Portfolio.Egyenleg;

public class Vasarlas_EMAP extends VasarlasiStrategia
{
    Allamkincstar allamkincstar = Allamkincstar.getInstance();
    Egyenleg myEgyenleg = Egyenleg.getInstance();
    public Vasarlas_EMAP(long nevErtek) { super(nevErtek); }

    private long vasarolhatoAllomany = allamkincstar.getEladoEMAPAllomany();
    @Override
    public void Vasarlas()
    {
        if(nevErtek > vasarolhatoAllomany) nevErtek = vasarolhatoAllomany;
        allamkincstar.AllamPapirErtekesítes_EMAP(nevErtek);
        myEgyenleg.addNevertek(nevErtek);
        System.out.println("Vásárolt EMAP Állomány= " + nevErtek);
    }
}
