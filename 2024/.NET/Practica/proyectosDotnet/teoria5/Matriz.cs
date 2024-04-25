namespace teoria5;

public class Matriz
{
  private double[,] _matriz;
  private int _columnas{ get; }
  private int _filas{ get; }

  public double this[int fila, int columna]
  {
    get => _matriz[fila, columna];
    set => _matriz[fila, columna] = value;
  }

  public double[] DiagonalSecundaria
  {
    get
    {
      double[] diagonal = new double[Math.Min(_filas, _columnas)];
      for (int i = 0; i < diagonal.Length; i++)
      {
        diagonal[i] = _matriz[i, _columnas - 1 - i];
      }
      return diagonal;
    }
  }

  public double[] DiagonalPrincipal
  {
    get
    {
      double[] diagonal = new double[Math.Min(_filas, _columnas)];
      for (int i = 0; i < diagonal.Length; i++)
      {
        diagonal[i] = _matriz[i, i];
      }
      return diagonal;
    }
  }
  public Matriz(int filas, int columnas)
  {
    _matriz = new double[columnas,filas];
    _columnas = columnas;
    _filas=filas;
  }
  
  public Matriz(double[,] matriz)
  {
    _matriz=matriz;
    _columnas=matriz.GetLength(0);
    _filas=matriz.GetLength(1);
  }

  public int GetLength(int i){
    return _matriz.GetLength(i);
  }

  public void SetElemento(int fila, int columna, double elemento)
  {
    _matriz[fila,columna]=elemento;
  }

  public double GetElemento(int fila, int columna)
  {
    return _matriz[fila,columna];
  }

  public void imprimir()
  {
    for (int i = 0; i < (_matriz.GetLength(0) * _matriz.GetLength(1)); i++)
    {
      System.Console.WriteLine(_matriz[i / _matriz.GetLength(1), i % _matriz.GetLength(1)]);
    }
  }

  public void imprimir(string formatString)
  {
    for (int i = 0; i < _filas; i++)
    {
        for (int j = 0; j < _columnas; j++)
        {
            Console.Write(formatString, _matriz[i, j]);
        }
        Console.WriteLine(); // Nueva línea después de imprimir una fila completa
    }
}

  public double[] GetFila(int fila)
  {
    double[] f=new double[_matriz.GetLength(0)];
    for(int i = 0;i<_matriz.GetLength(0);i++)
    {
      f[i]=_matriz[i,fila];
    }
    return f;
  }

  public double[] GetColumna(int columna)
  {
    double[] c=new double[_matriz.GetLength(1)];
    for(int i = 0;i<_matriz.GetLength(1);i++)
    {
      c[i]=_matriz[columna,i];
    }
    return c;
  }

  public double[] GetDiagonalPrincipal()
  {
    if(_matriz.GetLength(0)!=_matriz.GetLength(1))
    {
    throw new ArgumentException("la matriz no es cuadrada");
    }
    else
    {
      double[] d= new double[_matriz.GetLength(0)];
      for(int i=0;i<=(_matriz.GetLength(0)-1);i++)
      {
        d[i]=_matriz[i,i];
      }
      return d;
    }
  }
  public double[] GetDiagonalSecundaria()
  {
    if(_matriz.GetLength(0)!=_matriz.GetLength(1))
    {
      throw new ArgumentException("la matriz no es cuadrada");
    }
    else
    {
      double[] d= new double[_matriz.GetLength(0)];
        
      for(int i=0;i<=(_matriz.GetLength(0)-1);i++)
      {
        d[i]=_matriz[i,_matriz.GetLength(0)-1-i];
      }
      return d;
    }
  }
  public double[][] getArregloDeArreglo(){
    double[][] vv = new double[_matriz.GetLength(0)][];
    for (int j = 0; j < _matriz.GetLength(0); j++)
    {
      vv[j] = new double[_matriz.GetLength(0)];
    }
    for (int i = 0; i < (_matriz.GetLength(0) * _matriz.GetLength(1)); i++)
    {
      vv[i / _matriz.GetLength(1)][i % _matriz.GetLength(1)] = _matriz[i / _matriz.GetLength(1), i % _matriz.GetLength(1)];
      Console.WriteLine(" / " + i / _matriz.GetLength(1) + " y % " + i % _matriz.GetLength(1));
    }
    return vv;
  }
  public void sumarle(Matriz m)
  {
    if ((_matriz.GetLength(0) == m.GetLength(0)) & (_matriz.GetLength(1) == _filas))
    {
      for (int i = 0; i < (_matriz.GetLength(0) * _matriz.GetLength(1)); i++)
      {
        _matriz[i / _matriz.GetLength(1), i % _matriz.GetLength(1)] = _matriz[i / _matriz.GetLength(1), i % _matriz.GetLength(1)] + m.GetElemento(i / _filas, i % _filas);
      }
    }
  }
  
  public void restarle(Matriz m)
  {
    if ((_matriz.GetLength(0) == m.GetLength(0)) & (_matriz.GetLength(1) == _filas))
    {
      for (int i = 0; i < (_matriz.GetLength(0) * _matriz.GetLength(1)); i++)
      {
        _matriz[i / _matriz.GetLength(1), i % _matriz.GetLength(1)] = _matriz[i / _matriz.GetLength(1), i % _matriz.GetLength(1)] - m.GetElemento(i / _matriz.GetLength(1), i % _matriz.GetLength(1));
      }
    }
  }
  public void multiplicarPor(Matriz m){
    int fila1 = _matriz.GetLength(0);
    int columna1 = _matriz.GetLength(1);
    int fila2 = _columnas;
    int columna2 = _filas;

    if ((fila1 != columna2)&&(fila2 != columna1))
    {
      throw new ArgumentException("no se puede hacer la multiplicacion");

    }
    else
    {
      //las coordenadas de los numeros de las matrices empiezan en [0,0]
      // el for funciona mediante el indice, en este caso, i,j,x, 
      //al finalizar el recorrido se le suma 1 al indice, y empieza d nuevo el loop,
      //hasta que el indice no cumpla las condiciones

      //  ( indice  ; condicion; +1 )
      for (int i = 0; i < fila1; i++)//loop de 0 a cant de filas de matriz 1 -1
      {
        for (int j = 0; j < columna2; j++)//loop de 0 a cant de filas de matriz 2 -1
        {
          double sum = 0;
          for (int x = 0; x < columna1; x++)//loop para que haga la suma
          {
            sum += _matriz[i, x] * m.GetElemento(x, j);
          }
          _matriz[i, j] = sum;//el resultado de suma se le agrega a la matriz final
        }
      }
    }
  }
}
