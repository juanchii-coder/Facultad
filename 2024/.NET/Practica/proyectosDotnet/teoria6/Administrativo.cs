namespace teoria6;

public class Administrativo:Empleados
{
  public double Premio{ get; set; }

    public Administrativo(string nombre, int dni, DateTime fechaDeIngreso, double salarioBase) : base(nombre, dni, fechaDeIngreso, salarioBase)
    {
    }

    public override double Salario{
    get { return SalarioBase + Premio; }
  }
  public override void AumentarSalario()
  {
    decimal aumento = 0.01m * Antiguedad();
    SalarioBase += SalarioBase * (double)aumento;
  }

  public override string ToString()
    {
        return $"Administrativo {base.ToString()}";
    }
}
