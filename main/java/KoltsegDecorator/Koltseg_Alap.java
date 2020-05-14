package KoltsegDecorator;

public class Koltseg_Alap implements IKoltseg
{
    @Override
    public String getKoltsegNem() { return "Pénzügyi eszköz költsége: "; }

    @Override
    public double getKoltseg(long nevErtek,int futamIdo){ return 0; }
}
