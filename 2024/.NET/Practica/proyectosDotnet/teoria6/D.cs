namespace teoria6;

public class D:C
{
  public D(int id) : base(id){}

  public override void Imprimir()
  {
    Console.Write($"D_{_id} -->");
    base.Imprimir();
  }
}
