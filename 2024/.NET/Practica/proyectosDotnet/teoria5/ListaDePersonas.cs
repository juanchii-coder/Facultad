namespace teoria5;

public class ListaDePersonas
{
  private List<Persona>? _lista{get; set;}

  public ListaDePersonas(){
    _lista = new List<Persona>();
  }
 public void Agregar(Persona p)
 {
    _lista.Add(p);
 }

 public Persona this[int dni]
 {
    get{
      Persona x=new Persona();
      for(int i = 0;i<_lista.Count;i++)
      {
        if((int)_lista[i][2]==dni)
        {
          x=_lista[i];
          break;
        }
      }
      return x;
    }
  }

  public List<Persona> this[char letra]
  {
    get
    {
      List<Persona> l=new List<Persona>();
      for(int i = 0;i<_lista.Count;i++)
      {
        if(((string)_lista[i][0])[0]==letra){
          l.Add(_lista[i]);
        }
      }
      return l;
    }
    
  }

}