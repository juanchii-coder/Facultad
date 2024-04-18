package ejercicio7;

import java.util.*;

public class TestArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		List<Integer> numeros=new ArrayList();
		Scanner s=new Scanner(System.in);
		int num=1;
		while(num!=0) {
			num=s.nextInt();
			numeros.add(num);
		}
		Iterator<Integer> it=numeros.iterator();
		while(it.hasNext()) {
			System.out.println(((Integer)it.next()).intValue());
		}*/
		/*
		List<Integer> numeros=new LinkedList();
		Scanner s=new Scanner(System.in);
		int num=1;
		while(num!=0) {
			num=s.nextInt();
			numeros.add(num);
		}
		Iterator<Integer> it=numeros.iterator();
		while(it.hasNext()) {
			System.out.println(((Integer)it.next()).intValue());
		}
		*/
		/*
		ArrayList<Integer> lista1 = new ArrayList<>();
        lista1.add(1);
        lista1.add(2);
        lista1.add(1);

        ArrayList<Integer> lista2 = new ArrayList<>();
        lista2.add(1);
        lista2.add(2);
        lista2.add(3);

        System.out.println("¿La lista 1 es capicúa? " + esCapicua(lista1));
        System.out.println("¿La lista 2 es capicúa? " + esCapicua(lista2));
	    }
	
	    public static boolean esCapicua(ArrayList<Integer> lista) {
	        int inicio = 0;
	        int fin = lista.size() - 1;// size menos uno porque el indice empieza en cero
	
	        while (inicio < fin) {
	            if (!lista.get(inicio).equals(lista.get(fin))) {//verifica si el numero del principio no es igual al ultimo
	                return false; // No es capicúa
	            }
	            inicio++;//avanza uno desde el principio
	            fin--;//retrocede uno desde el final
	        }
	        return true; // Es capicúa
	    }
		*/
	    EjercicioSucesion a=new EjercicioSucesion();
	    List<Integer> numeros=new ArrayList<>();
	    
	    numeros=a.calcularSucesion(17);
	    
	    Iterator<Integer> it=numeros.iterator();
		while(it.hasNext()) {
			System.out.println(((Integer)it.next()).intValue());
		}
    

	}
}
