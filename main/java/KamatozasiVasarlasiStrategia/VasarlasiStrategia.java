package KamatozasiVasarlasiStrategia;

public abstract class VasarlasiStrategia
{
  protected long nevErtek;
  public VasarlasiStrategia(long nevErtek)
  {this.nevErtek = nevErtek;}

  public abstract void Vasarlas();
}
