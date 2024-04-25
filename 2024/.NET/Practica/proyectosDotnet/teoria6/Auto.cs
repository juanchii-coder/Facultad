namespace teoria6;

public class Auto
{
  protected double velocidad;
  public virtual void Acelerar() => Console.WriteLine("Velocidad = {0}", velocidad += 10);
}
