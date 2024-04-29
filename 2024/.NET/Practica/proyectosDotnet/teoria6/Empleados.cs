namespace teoria6;

public abstract class Empleados
{
  public string? Nombre{get;}
  public int DNI{get;}
  public DateTime FechaDeIngreso{get;}
  public double SalarioBase{get;protected set;}
  public abstract double Salario{get;}

  protected Empleados(string nombre, int dni, DateTime fechaDeIngreso, double salarioBase)
  {
    Nombre = nombre;
    DNI = dni;
    FechaDeIngreso = fechaDeIngreso;
    SalarioBase = salarioBase;
  }
  public abstract void AumentarSalario();
  public int Antiguedad()
  {
    return DateTime.Now.Year - FechaDeIngreso.Year;
  }
  public override string ToString()
    {
        return $"Nombre: {Nombre}, DNI: {DNI}, Antigüedad: {Antiguedad()}\nSalario base: {SalarioBase}, Salario: {Salario}";
    }
}
