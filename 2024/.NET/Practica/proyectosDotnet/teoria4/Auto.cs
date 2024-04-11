namespace teoria4;

public class Auto
{
  string _marca;
  int _modelo;

  public Auto(){
    _marca = "fiat";
    _modelo = DateTime.Now.Year;
  }

  public Auto(string marca):this()
  {
    _marca = marca;
  }

  public Auto(string marca, int modelo){
    _marca = marca;
    _modelo = modelo;
  }
  public string descripcion(){
    return $"este auto es un modelo {_modelo} de la marca {_marca}";
  }
}
