//punto 5
/*
double[,] matriz = new double[,]
{{1,4,7},
{3,2,9},
{5,6,8}};
double[][] x;
x = GetArregloDeArreglo(matriz);
imprimir(x);

double[][] GetArregloDeArreglo(double[,] matriz)
{
  double[][] vv = new double[matriz.GetLength(0)][];
  for (int j = 0; j < matriz.GetLength(0); j++)
  {
    vv[j] = new double[matriz.GetLength(0)];
  }
  for (int i = 0; i < (matriz.GetLength(0) * matriz.GetLength(1)); i++)
  {
    vv[i / matriz.GetLength(1)][i % matriz.GetLength(1)] = matriz[i / matriz.GetLength(1), i % matriz.GetLength(1)];
    Console.WriteLine(" / " + i / matriz.GetLength(1) + " y % " + i % matriz.GetLength(1));
  }
  return vv;
}
void imprimir(double[][] vv)
{
  foreach (double[] v in vv)
  {
    foreach (double num in v)
    {
      Console.WriteLine(num);
    }
  }
}
*/

//punto 6
/*
double[,] A = new double[,]
{ { 1, 1 },
{ 2, 2 },
{ 3, 3 } };

double[,] B = new double[,]
{ { 1, 1 },
{ 2, 2 },
{ 3, 3 } };

double[,] C = new double[,]
{ { 1, 1, 1 },
{ 2, 2, 2 } };

double[,]? suma = Suma(A, B);
double[,]? resta = Resta(A, B);
double[,] multi = Multiplicacion(A, C);

Console.WriteLine("matriz A:");
imprimir(A);

Console.WriteLine("matriz B:");
imprimir(B);

Console.WriteLine("matriz C:");
imprimir(C);

Console.WriteLine("matriz suma:");
imprimir(suma);

Console.WriteLine("matriz resta:");
imprimir(resta);

Console.WriteLine("matriz multiplicacion:");
imprimir(multi);

double[,]? Suma(double[,] A, double[,] B)
{
  double[,] suma = new double[A.GetLength(0), A.GetLength(1)];
  if ((A.GetLength(0) == B.GetLength(0)) & (A.GetLength(1) == B.GetLength(1)))
  {
    for (int i = 0; i < (A.GetLength(0) * A.GetLength(1)); i++)
    {
      suma[i / A.GetLength(1), i % A.GetLength(1)] = A[i / A.GetLength(1), i % A.GetLength(1)] + B[i / A.GetLength(1), i % A.GetLength(1)];
    }
  }
  return suma;
}
double[,]? Resta(double[,] A, double[,] B)
{
  double[,] resta = new double[A.GetLength(0), A.GetLength(1)];
  if ((A.GetLength(0) == B.GetLength(0)) & (A.GetLength(1) == B.GetLength(1)))
  {
    for (int i = 0; i < (A.GetLength(0) * A.GetLength(1)); i++)
    {
      resta[i / A.GetLength(1), i % A.GetLength(1)] = A[i / A.GetLength(1), i % A.GetLength(1)] - B[i / A.GetLength(1), i % A.GetLength(1)];
    }
  }
  return resta;
}
double[,] Multiplicacion(double[,] A, double[,] B)
{
  double[,] multi = new double[A.GetLength(0), A.GetLength(1)];
  if ((A.GetLength(0) == B.GetLength(1)) & (A.GetLength(1) == B.GetLength(0)))
  {
    for (int i = 0; i < (A.GetLength(0) * A.GetLength(1)); i++)
    {
      multi[i / A.GetLength(1), i % A.GetLength(1)] = A[i / A.GetLength(1), i % A.GetLength(1)] * B[i % A.GetLength(1), i / A.GetLength(1)];
    }
  }
  else
  {
    throw new ArgumentException("no se puede hacer la multiplicacion");
  }
  return multi;
}
void imprimir(double[,] v)
{
  if (v != null)
  {
    for (int i = 0; i < v.GetLength(0); i++)
    {

      for (int j = 0; j < v.GetLength(1); j++)
      {
        Console.Write($"| {v[i, j]} |");
      }
      Console.WriteLine();
      Console.WriteLine("------------");
    }
  }
  else
  {
    Console.WriteLine("no hay nada en el vector");
  }
}
*/

//punto 13
/*
Stack<int> binario=new Stack<int>();
Console.WriteLine("escribir un numero para pasarlo a binario");
string? num;
num= Console.ReadLine();
int numero=int.Parse(num);
while(numero>0){
  binario.Push(numero%2);
  numero/=2;
}
foreach(int nume in binario){
  Console.Write(nume);
}
*/

//punto 14
/*
String? texto = Console.ReadLine();
Console.WriteLine($"el texto es: {texto}");

int[] clave = new int[] { 5, 3, 9, 7 };

Console.WriteLine(CifrarTexto(texto, clave));

string CifrarTexto(String texto, int[] clave)
{
  Queue<int> key = new Queue<int>(clave);
  string textoCifrado = "";

  foreach (char caracter in texto)
  {
    int desplazar = key.Dequeue();
    key.Enqueue(desplazar);
    int valor;
    if (caracter.ToString() != " ")
    {
      Letras letra = (Letras)Enum.Parse(typeof(Letras), caracter.ToString());
      valor = (int)letra;
    }
    else
    {
      valor = 29;
    }

    int nuevoValor = (valor + desplazar - 1) % 29 + 1;

    textoCifrado += Enum.GetName(typeof(Letras), nuevoValor);
  }

  return textoCifrado;
}

enum Letras
{ A, B, C, D, E, F, G, H, I, J, K, L, M, N, Ñ, O, P, Q, R, S, T, U, V, W, X, Y, Z }
*/