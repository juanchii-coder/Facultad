namespace teoria6;

static class Imprimidor
{
  public static void Imprimir(params IImprimidor[] objetos)
  {
    foreach (var objeto in objetos)
    {
      objeto.Imprimir();
    }
  }
}
