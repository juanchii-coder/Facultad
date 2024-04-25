namespace teoria5;

class A
{
  /*
  static int s_a=0;
  static A() {
    s_a++;
  }
  public A() {
    s_a++;
  }*/

  /*
  static int s_a = 0;
  public static A() {
    s_a++;
  }
  A() {
    s_a++;
  }*/

  
  char c;
  static string st;
  void metodo1()
  {
    st = "string";
    c = 'A';
  }
  static void metodo2()
  {
    new A().c = 'a';// intendo de acceder a variables privadas de otro objeto
    st = "st2";
    //c = 'B';// intento de modificacion de variables no estaticas en un metodo estatico
    A.st = "otro string";
  }



}
