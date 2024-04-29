namespace Almacen.Aplicacion;

public class AgregarProductoUseCase(IRepositorioProducto repo)
{
  public void Ejecutar(Producto producto)
  {
    repo.AgregarProducto(producto);
  }
}

