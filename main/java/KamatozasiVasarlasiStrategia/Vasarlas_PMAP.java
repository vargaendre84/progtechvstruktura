package KamatozasiVasarlasiStrategia;
import Intezmenyek.Allamkincstar;
import Portfolio.Egyenleg;

public class Vasarlas_PMAP extends VasarlasiStrategia
{
    Allamkincstar allamkincstar = Allamkincstar.getInstance();
    Egyenleg myEgyenleg = Egyenleg.getInstance();

    public Vasarlas_PMAP(long nevErtek) { super(nevErtek); }

    private long vasarolhatoAllomany = allamkincstar.getEladoPMAPAllomany();
    @Override
    public void Vasarlas()
    {
        if(nevErtek > vasarolhatoAllomany) nevErtek = vasarolhatoAllomany;
        allamkincstar.AllamPapirErtekesítes_PMAP(nevErtek);
        myEgyenleg.addNevertek(nevErtek);
        System.out.println("Vásárolt PMAP Állomány= " + nevErtek);
    }
}
