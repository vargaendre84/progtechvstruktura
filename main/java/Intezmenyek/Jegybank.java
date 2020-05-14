package Intezmenyek;

public class Jegybank  //lazy
{
    //long: 2^63 = 9*10^18
    //magyaro 2018-as gdp: 4,2*10^13
    //https://www.ksh.hu/docs/hun/xstadat/xstadat_eves/i_qpt015.html
    private String nev = "Magyar Nemzeti Bank";
    private double alapkamat = 0.009;  //2020.03.25.  mnb.hu
    private long keszpenzallomany = 6620000 * 1000000;  // forrás: 2020.01.20. mnb.hu
    private static volatile Jegybank instance = null;

    private Jegybank() {}

    public static Jegybank getInstance()
    {
        if(instance == null)
        {
            instance = new Jegybank();
        }
        return instance;
    }
}
