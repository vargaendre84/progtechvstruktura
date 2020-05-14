package KoltsegDecorator;

abstract class KoltsegDecorator implements IKoltseg
{
    protected IKoltseg alapKoltseg;
    public KoltsegDecorator(IKoltseg alapKoltseg) {this.alapKoltseg = alapKoltseg;}
}
