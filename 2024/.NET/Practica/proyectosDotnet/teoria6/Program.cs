using teoria6;

/*
A[] vector = [new A(3),new B(5),new C(15),new D(41)];
foreach (A a in vector)
{
  a.Imprimir();
}
*/
/*
A[] vector = [ new C(1),new D(2),new B(3),new D(4),new B(5)];
foreach (A a in vector)
{
  if (a.GetType() == typeof(B)) // Verifica que el tipo exacto es B
  {
    a.Imprimir();
  }
}*/
/*
B_3 --> A_3
B_5 --> A_5
*//*
Taxi t = new Taxi(3);
Console.WriteLine($"Un {t.Marca} con {t.Pasajeros} pasajeros");*/
Empleados[] empleados = new Empleados[] {
  new Administrativo("Ana", 20000000, DateTime.Parse("26/4/2018"), 10000) {Premio=1000},
  new Vendedor("Diego", 30000000, DateTime.Parse("2/4/2010"), 10000) {Comision=2000},
  new Vendedor("Luis", 33333333, DateTime.Parse("30/12/2011"), 10000) {Comision=2000}
};
foreach (Empleados e in empleados)
{
  Console.WriteLine(e);
  Console.WriteLine("-----------------------------------------------------");
  e.AumentarSalario();
  Console.WriteLine(e);
  Console.WriteLine("-----------------------------------------------------");
}