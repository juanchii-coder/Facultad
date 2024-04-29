namespace teoria6;

public class Auto
{
  protected double velocidad;// se pasa de privada(porque no tenia nada) a protected
  public string Marca { get; private set; } = "Ford";
  public Auto(string marca) => this.Marca = marca;
  public virtual void Acelerar() => Console.WriteLine("Velocidad = {0}", velocidad += 10);

  private Persona _dueño1, _dueño2;
  public Persona GetPrimerDueño() => _dueño1;
  protected Persona SegundoDueño
  {
    set => _dueño2 = value;
  }
 }