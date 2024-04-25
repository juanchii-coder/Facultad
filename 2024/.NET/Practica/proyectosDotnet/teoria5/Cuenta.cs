
namespace teoria5;

public class Cuenta
{
  private int _numCuenta;
  static int _numCuentasCreadas;
  static int _numDepositos;
  static double _totalDepositos;
  static int _numExtracciones;
  static double _totalExtracciones;
  static int _accionesDenegadas;
  private double _monto;
  static double _montoTotal;
  static List<Cuenta> s_cuentas = new List<Cuenta>();
   public static List<Cuenta> Cuentas{
    get {
      List<Cuenta> misCuentas = new List<Cuenta>(s_cuentas);
      return misCuentas;
    }
  }

  public Cuenta(){
    _numCuentasCreadas++;
    _numCuenta=_numCuentasCreadas;
    _monto=0;
    System.Console.WriteLine($"se creo la cuenta con ID={_numCuenta}");
    s_cuentas.Add(this);
  }

  public static void ImprimirDetalle()
  {
    System.Console.WriteLine( $@"
    CUENTAS CREADAS:{_numCuentasCreadas}
    DEPOSITOS:{_numDepositos}
    EXTRACCIONES:{_numExtracciones}
    - Total depositado:{_totalDepositos}
    - Total extraido:{_totalExtracciones}
    - saldo:{_montoTotal}
    se denegaron {_accionesDenegadas} operaciones por falta de fondos");
  }

  public Cuenta Depositar(double monto){
    _monto+=monto;
    _montoTotal+=monto;
    _numDepositos++;
    _totalDepositos+=monto;
    System.Console.WriteLine($"se depositaron {monto} en la cuenta {_numCuenta} (saldo{_monto})");
    return this;
  }

  public Cuenta Extraer(double monto){
    if (_monto>=monto){
      _monto-=monto;
      _montoTotal-=monto;
      _numExtracciones++;
      _totalExtracciones+=monto;
      System.Console.WriteLine($"se extrajo {monto} de la cuenta {_numCuenta} (saldo{_monto})");
    }else{
      _accionesDenegadas++;
      System.Console.WriteLine("operacion denegada");
    }
    return this;
  }
}
