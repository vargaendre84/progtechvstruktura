package KamatozasiVasarlasiStrategia;

public class Kamatado implements IKamatado
{
    private static final double alapkamatado = 0.15;
    private static final double tbszkamatado = 0;

    public double getKamatado(boolean tbsz)
    {
        if(tbsz)
            return tbszkamatado;
        else
            return alapkamatado;
    }
}

/*
4.
public double getKamatado()  //getKamatAdoNemTbsz passed: expected = 0.15; actual=0.15;
    {                           //getKamatAdoTbsz passed
        if(tbsz)
            return tbszkamatado;
        else
            return alapkamatado;
    }

3.
public double getKamatado()   //getKamatAdoNemTbsz failed: expected = 0.15; actual=1.0;
    {
        if(tbsz)
            return tbszkamatado;
        else
            return 1;
    }

2.
public double getKamatado()   //getKamatAdoTbsz passed: expected = 0.0; actual=0.0;
    {
        if(tbsz)
            return tbszkamatado;
        else
            return 1;
    }

1.
public double getKamatado()  //getKamatAdoTbsz failed: expected = 0.0; actual=1.0;
    {
        return 1;
    }
 */
