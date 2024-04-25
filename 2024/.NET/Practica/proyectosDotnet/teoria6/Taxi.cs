namespace teoria6;

public class Taxi: Auto
{
  public override void Acelerar() => Console.WriteLine("Velocidad = {0}", velocidad += 5);
}
