// PRACTICA 3
using System;
//punto 1
/*
Console.CursorVisible = false;//error
ConsoleKeyInfo k = Console.ReadKey(true);
while (k.Key != ConsoleKey.End)
{
    Console.Clear();
    Console.Write($"{k.Modifiers}-{k.Key}-{k.KeyChar}");
    // muestra el modificador(shift-alt-ctrl), la tecla presionada, y la combinacion de ellas
    // por ej: SHIFT+r= shift-r-R
    k = Console.ReadKey(true);
}
*/

//punto 2
/*
double[,] v = new double[,]
{{1,3,4},
{6,8,23},
{34,52,1}};

ImprimirMatriz(v);
ImprimirMatrizConFormato(v,"0.00");

void ImprimirMatriz(double[,] matriz)
{
    for (int x = 0; x < matriz.GetLength(0); x++)
    {
        for (int y = 0; y < matriz.GetLength(1); y++)
        {
            Console.WriteLine(matriz[x, y]);
        }
    }
}

// punto 3

void ImprimirMatrizConFormato(double[,] matriz, string formatString){

  for (int x = 0; x < matriz.GetLength(0); x++)
    {
        for (int y = 0; y < matriz.GetLength(1); y++)
        {
            Console.Write($"| {matriz[x, y].ToString(formatString)} |");
        }
        Console.WriteLine();
    }
}
*/

//punto 4

double[,] m = new double[,]
{{1,3,4},
{6,8,23},
{34,52,1}};

imprimir(diagonal(m));
imprimir(otraDiagonal(m));

double[] otraDiagonal(double[,] m)
{
  
  if(m.GetLength(0)!=m.GetLength(1)){
    throw new ArgumentException("la matriz no es cuadrada");
  }else{
    double[] d= new double[m.GetLength(0)];
    for(int i=0;i<=(m.GetLength(0)-1);i++){
      d[i]=m[i,m.GetLength(0)-1-i];
    }
    return d;
  }
  
}

double[] diagonal(double[,] m)
{
  if(m.GetLength(0)!=m.GetLength(1)){
    throw new ArgumentException("la matriz no es cuadrada");
  }else{
    double[] d= new double[m.GetLength(0)];
    for(int i=0;i<=(m.GetLength(0)-1);i++){
      d[i]=m[i,i];
    }
    return d;
  }

}

void imprimir(double[] diagonal){
  foreach(double d in diagonal){
    Console.Write(d);
  }
}