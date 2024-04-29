namespace teoria6;

public class Vendedor:Empleados
{
  public double Comision{ get; set; }

    public Vendedor(string nombre, int dni, DateTime fechaDeIngreso, double salarioBase) : base(nombre, dni, fechaDeIngreso, salarioBase)
    {
    }

    public override double Salario{
    get { return SalarioBase + Comision; }
  }
  public override void AumentarSalario()
  {
    decimal aumento = Antiguedad() < 10 ? 0.05m : 0.10m;
    SalarioBase += SalarioBase * (double)aumento;
  }

  public override string ToString()
    {
        return $"Vendedor {base.ToString()}";
    }
}
