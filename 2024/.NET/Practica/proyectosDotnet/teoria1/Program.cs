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