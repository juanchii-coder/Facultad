namespace teoria6;

public class Taxi: Auto
{
  public int Pasajeros { get; private set; }
    public Taxi(int pasajeros) : base("Ford")
    //si no se unas el :base se realiza por defecto sin parametros,
    //por eso se necesitaba el constructor sin parametros de Auto
    {
        this.Pasajeros = pasajeros;
    }
    public override void Acelerar() => Console.WriteLine("Velocidad = {0}", velocidad += 5);
}
