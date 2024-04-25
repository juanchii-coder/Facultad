using teoria5;
/*
Cuenta c1 = new Cuenta();
c1.Depositar(100).Depositar(50).Extraer(120).Extraer(50);
Cuenta c2 = new Cuenta();
c2.Depositar(200).Depositar(800);
new Cuenta().Depositar(20).Extraer(20);
c2.Extraer(1000).Extraer(1);*/

new Cuenta();
new Cuenta();
List<Cuenta> cuentas = Cuenta.Cuentas;
// se recuperó la lista de cuentas creadas
cuentas[0].Depositar(50);
// se depositó 50 en la primera cuenta de la lista devuelta
cuentas.RemoveAt(0);
Console.WriteLine(cuentas.Count);
// se borró un elemento de la lista devuelta
// pero la clase Cuenta sigue manteniendo todos 
// los datos "La cuenta id: 1 tiene 50 de saldo"
cuentas = Cuenta.Cuentas;
// se recuperó nuevamente la lista de cuentas
Console.WriteLine(cuentas.Count);
cuentas[0].Extraer(30);