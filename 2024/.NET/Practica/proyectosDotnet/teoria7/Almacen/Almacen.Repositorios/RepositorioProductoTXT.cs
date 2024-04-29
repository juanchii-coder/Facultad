namespace Almacen.Repositorios;

using System;
using Almacen.Aplicacion;
public class RepositorioProductoTXT : IRepositorioProducto
{
  readonly string _nombreArch = "productos.txt";
  public void AgregarProducto(Producto producto)
  {
    int nuevoId=ObtenerUltimoId()+1;
    producto.Id=nuevoId;
    new Producto();
    using var sw = new StreamWriter(_nombreArch, true);
    sw.WriteLine(producto.Id);
    sw.WriteLine(producto.Nombre);
    sw.WriteLine(producto.Precio);
  }

  private int ObtenerUltimoId()
        {
            if (!File.Exists(_nombreArch))
                return 0; // Si el archivo no existe, comenzamos desde 0
            
            int ultimoId = 0;
            using var sr = new StreamReader(_nombreArch);
            while (!sr.EndOfStream)
            {
                ultimoId = int.Parse(sr.ReadLine() ?? "0");
                // Saltar nombre y precio
                sr.ReadLine(); 
                sr.ReadLine();
            }
            return ultimoId;
        }

  public List<Producto> ListarProductos()
  {
    var resultado = new List<Producto>();
    using var sr = new StreamReader(_nombreArch);
    while (!sr.EndOfStream)
    {
      var producto = new Producto();
      producto.Id = int.Parse(sr.ReadLine() ?? "");
      producto.Nombre = sr.ReadLine() ?? "";
      producto.Precio = int.Parse(sr.ReadLine() ?? "");
      resultado.Add(producto);
    }
    return resultado;
  }

  public Producto? GetProducto(int id)
  {
      Producto producto=new Producto();
      using var sr = new StreamReader(_nombreArch);
      while(!sr.EndOfStream)
      {
        int productoId=int.Parse(sr.ReadLine());
        if(productoId == id)
        {
          producto.Id=productoId;
          producto.Nombre=sr.ReadLine() ?? "";
          producto.Precio = int.Parse(sr.ReadLine() ?? "");
          return producto;
        }
        else
        {
          sr.ReadLine(); // Nombre
          sr.ReadLine(); // Precio
        }
      }
      return null;
  }

  public void ModificarProducto(Producto producto)
  {
      var productos = ListarProductos();
      var index = productos.FindIndex(p => p.Id == producto.Id);

      if (index >= 0)
      {
        productos[index] = producto;
        using var sw = new StreamWriter(_nombreArch, false); // false para sobreescribir
        foreach (var p in productos)
        {
          sw.WriteLine(p.Id);
          sw.WriteLine(p.Nombre);
          sw.WriteLine(p.Precio);
        }
      }
  }

  public void EliminarProducto(int id)
  {
      var productos = ListarProductos();
      var productoEliminar = productos.Find(p => p.Id == id);
      if (productoEliminar != null)
      {
        productos.Remove(productoEliminar);

        using var sw = new StreamWriter(_nombreArch, false);
        foreach (var p in productos)
        {
          sw.WriteLine(p.Id);
          sw.WriteLine(p.Nombre);
          sw.WriteLine(p.Precio);
        }
      }
  }
}
