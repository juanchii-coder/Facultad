namespace teoria5;

public class Persona
{
  private string? _Nombre{ get; set; }
  private char _Sexo{ get; set; }
  private int _DNI{ get; set; }
  private DateTime _FechaNacimiento{ get; set; }

  public object? this[int id]
  {
    get
    { 
      if(id == 0)
      {
        return _Nombre;
      }
      else if(id==1)
      {
        return _Sexo;
      }
      else if(id==2)
      {
        return _DNI;
      }
      else if(id==3)
      {
        return _FechaNacimiento;
      }
      else return null;
    }
  }

  public void modificarValor(int id, object valor)
  {
    if(id == 0)
    {
      _Nombre=(string)valor;
    }
    else if(id==1)
    {
      _Sexo=(char)valor;
    }
    else if(id==2)
    {
      _DNI=(int)valor;
    }
    else if(id==3)
    {
      _FechaNacimiento=(DateTime)valor;
    }
    else System.Console.WriteLine("id no valido");
  }
  
}
