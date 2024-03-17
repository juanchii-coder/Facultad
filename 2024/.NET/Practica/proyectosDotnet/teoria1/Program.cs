using System;
/*
Console.WriteLine("ingresar tu nombre: ");
String nombre = Console.ReadLine();
Console.WriteLine("Hola, "+ nombre+ ", ingresa un numero:");
String x = Console.ReadLine();
int num = int.Parse(x);
int total=0;
for (int i=0;i<=num;i++){
  total+=i;
}
Console.WriteLine("la sumatoria de todos los digitos del 1 al "+num+" es:");
Console.WriteLine(total);
Console.ReadLine();*/

// PRACTICA 1

//punto 1
/*
Console.Write("Hola ");
ConsoleKeyInfo tecla= Console.ReadKey(false);
if (tecla.Key == ConsoleKey.Enter){
  Console.WriteLine("mundo");
}else{
  Console.WriteLine(" <---- tecla equivocada, apretar ENTER");
}*/

//punto 2
/*
Console.WriteLine("hola \n mundo");//salto de linea
Console.WriteLine("hola \t mundo");//tab
Console.WriteLine("hola \" mundo");// permite que escriba comillas
Console.WriteLine("hola \\ mundo");// permite que escriba el slash al revez
*/

//punto 3
/*
String st = "c:\\windows\\system";
 Console.WriteLine(st);
 */

//punto 4
/*
Console.WriteLine("ingresar tu nombre: ");
String nombre="mundo";
ConsoleKeyInfo tecla= Console.ReadKey(); //lo dejo el true para que se vea el char elegido
if ((tecla.Key != ConsoleKey.Enter)){
  nombre=tecla.KeyChar+Console.ReadLine(); //agarro el char que se agarro en ReadKey y lo combino con el ReadLine
}
Console.WriteLine("Hola "+nombre);
*/

//punto 5
//A)
/*
Console.WriteLine("Nombre: ");
String st=Console.ReadLine();
*/
/*
if(st.Equals("Juan")){
  Console.WriteLine("¡Hola amigo!");
}else if (st.Equals("Maria")){
  Console.WriteLine("buen dia señora");
}else if (st.Equals("Alberto")){
  Console.WriteLine("Hola Alberto");
}else{
  Console.WriteLine("buenos dias "+ st);
}*/
/*
 switch (st)
 {
  case "Alberto":
    Console.WriteLine("¡Hola, tan amigos no somos!!!!");
  break;
  case "Maria":
    Console.WriteLine("¡Hola 8===D");
  break;
  case "Juan":
    Console.WriteLine("¡Hola bobogolico");
  break;
  default:
    Console.WriteLine("Hola mundo, clavecula");
    break;
 }
*/

//punto 6
/*
Console.WriteLine("ingresar algo y te digo cuantas letras tiene");

String st=Console.ReadLine();

if(st!=null){
  Console.WriteLine(st.Length+ " letras");
}*/

//punto 7
/*
Console.WriteLine("100".Length); //3
*/

//punto 8
/*
String st;
Console.WriteLine(st=Console.ReadLine());
Console.ReadLine();
*/

//punto 9
/*
Console.WriteLine("ingresar 2 strings separadas por un espacio");
String st=Console.ReadLine();
int cantChar =st.Length/2;
int cont=0;
bool ok=false;
bool ok2=false;
while (cont<cantChar)
{
  if (st[cont].Equals(st[st.Length-1-cont])){
    ok=true;
  }
  if (st[cont].Equals(st[cantChar+1+cont])){
    ok2=true;
  }
  cont++;
}
if (ok&&ok2)
{
  Console.WriteLine("es igual de atras para delante");
}else{
  Console.WriteLine("no es igual de atras para delante");
}
*/

//punto 10
/*
int multiplo=1;
int cont=1;
while (multiplo < 1000)
{
  multiplo= 19*cont;
  cont++;
  Console.Write(multiplo+" - ");
}
*/

//punto 11
/*
Console.WriteLine("10/3 = " + 10 / 3);
Console.WriteLine("10.0/3 = " + 10.0 / 3);
Console.WriteLine("10/3.0 = " + 10 / 3.0);
int a = 10, b = 3;
Console.WriteLine("Si a y b son variables enteras, si a=10 y b=3");
Console.WriteLine("entonces a/b = " + a / b);
double c = 3;
Console.WriteLine("Si c es una variable double, c=3");
Console.WriteLine("entonces a/c = " + a / c);
*/
//A) dependiendo de como se escriba el numero depende de como lo interprete el lenguaje, si se pone con .0
//   lo va a identificar como un double, amenos que ya sea uno

//B) el + en el string sirve para juntar strings por ej "hola"+ "mundo", es lo mismo que "holamundo"

//punto 12
/*
Console.WriteLine("escribe un numero y te dire sus divisores");
String st=Console.ReadLine();
int num= int.Parse(st);
Console.WriteLine("los divisores de "+num+" son:");
for (int i=1;i<=num;i++){
  if (num % i==0){
    Console.WriteLine(i);
  }
}
*/

//punto 13
/*
int a,b;
if ((b != 0) & (a/b > 5)) Console.WriteLine(a/b);
*/

//punto 14
/*
int a=5;
int b=7;
int c=0;
if (a<b){
  c=a;
}else{
  c=b;
}
*/

//punto 15
/*
int i = 0;
 for (int i = 1; i <= 10;)// el problema es que se declara la misma variable 2 veces
 {
 Console.WriteLine(i++);
 }

 int i = 0;
 for (i = 1; i <= 10;)// <------ solucion
 {
 Console.WriteLine(i++);
 }
*/

//punto 16
/*
int i = 1;
 if (--i == 0)
 {
 Console.WriteLine("cero1");// va a salir por aca
 }
 if (i++ == 0)
 {
 Console.WriteLine("cero2");
 }
 Console.WriteLine(--i);
 Console.WriteLine(i++);
 Console.WriteLine(i);
 */

// PRACTICA 2

//punto 10
/*
using System.Text;
object[] v = new object[10];
v[0] = new StringBuilder("Net");// v[0]="Net"
for (int i = 1; i < 10; i++)
{
  v[i] = v[i - 1];//v[0] a v[9]="Net"
}
(v[5] as StringBuilder).Insert(0, "Framework .");//v[5] a v[9]="framework .Net", v[0] a v[4]="Net"
foreach (StringBuilder s in v)
  Console.WriteLine(s);
//dibujar el estado de la pila y la mem. heap
*/
/*
de v[5] a v[9]=referencian a 2
de v[0] a v[4]=referencian a 1
mem. heap=  Net(1), Framework .Net(2)
*/
/*
//en este punto de la ejecución
v[5] = new StringBuilder("CSharp");
foreach (StringBuilder s in v)
  Console.WriteLine(s);
//dibujar el estado de la pila y la mem. heap
*/
/*
v[5]=referencia a 3, y de v[6] a v[9]=referencian a 2
v[0] a v[4]=referencian a 1
mem. heap=  Net(1), Framework .Net(2), CSharp(3)
*/
//en este punto de la ejecución

//punto 11
/*
el metodo split se utiliza para dividir un string en varias partes
*/
/*
string st = "hola como estas";//o por consola
Console.WriteLine(st);
String[] palabras = st.Split(" ");
foreach (var palabra in palabras)
{
  Console.WriteLine(palabra);
}
*/

//punto 12
/*
Console.WriteLine("escribir un mes en conosla: ");
String st = Console.ReadLine();
bool ok = false;
for (Meses m = Meses.Diciembre; m >= Meses.Enero; m--)
{

  Console.WriteLine(m.ToString());

  if (m.ToString().Equals(st))
  {
    ok = true;
  }
}
if (ok)
{
  Console.WriteLine(st + " es un mes");
}
else
{
  Console.WriteLine(st + " no es un mes");
}

enum Meses
{
  Enero, Febrero, Marzo, Abril, Mayo, Junio, julio,
  Agosto, Septiempre, Octubre, Noviembre, Diciembre
}
*/

//punto 13
/*
Console.WriteLine(args == null);//false
Console.WriteLine(args.Length);//0
*/

//punto 14
/*
int[]? vector = new int[0];// se crea un vector de cero lugares pero no significa que sea nulo
*/

//punto 15
//Console.WriteLine("¡Hola {0}!", args[0]);
//si se inicia el programa desde la terminal y se le manda algun parametro no pasa nada
//si se inicia el programa y nos e manda nada, se realiza una exepcion

//punto 16
/*
foreach (var nombres in args)
{
  Console.WriteLine("hola " + nombres);
}

for (var i = 0; i < args.Length; i++)
{
  Console.WriteLine("hola " + args[i]);
}
*/

//punto 17
/*
if (esPrimo(int.Parse(args[0])))
{
  Console.WriteLine("es primo");
}
else
{
  Console.WriteLine("no es primo");
}

bool esPrimo(int i)
{
  bool ok = true;
  for (int j = 2; j <= Math.Sqrt(i); j++)
  {
    if (i % j == 0)
    {
      ok = false;
    }
  }
  return ok;
}
*/

//punto 18
/*
Console.WriteLine(Fac(int.Parse(args[0])));
Console.WriteLine(FacR(int.Parse(args[0])));
Console.WriteLine(FacE_B(int.Parse(args[0])));

int FacE_B(int n) => n == 0 ? 1 : n * FacE_B(n - 1);
//expression-bodied method es cuando el metodo es de una linea sola, se utiliza "=>", la flecha
//si n==0 es V, devuelve lo que esta a la izquierda del ":", osea 1
//si es F, devuelve lo de la derecha

int FacR(int v)
{
  if (v > 1)
  {
    v *= FacR(v - 1);
  }
  else
  {
    v = 1;
  }
  return v;
}

int Fac(int n)
{
  int i;
  for (i = (n - 1); i > 1; i--)
  {
    n *= i;
  }
  return n;
}
*/

//punto19
/*
int resul1;
int resul2;
FacR(int.Parse(args[0]), out resul1);
Fac(int.Parse(args[0]), out resul2);
Console.WriteLine(resul1 + " y " + resul2);


void Fac(int n, out int resul)
{
  resul = n;
  for (int i = (n - 1); i > 1; i--)
  {
    resul *= i;
  }
}


void FacR(int v, out int resul)
{
  if (v == 0)
  {
    resul = 1;
  }
  else
  {
    int temp;
    FacR(v - 1, out temp);
    resul = v * temp;
  }
}
*/

//punto 20
/*
object a = 'A';
object b = 1;
Console.WriteLine(b);
Console.WriteLine(a);
Swap(ref a, ref b);
Console.WriteLine(b);
Console.WriteLine(a);

static void Swap(ref object a, ref object b)
{
  object c = a;
  a = b;
  b = c;
}
//por defecto los parametros de pasan por valor en c#
//entonces hay que indicarlo
*/

//punto 21
/*
Imprimir(1, "perro", 'a', 2.4, DateTime.UtcNow);
Imprimir(1, "perro", 'a');
Imprimir();
Imprimir("------------------");
void Imprimir(params object[] algo)
{
  foreach (object a in algo)
  {
    Console.Write(a + " ");
  }
  Console.WriteLine();
}
*/