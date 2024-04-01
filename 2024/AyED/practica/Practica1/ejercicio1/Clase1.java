package ejercicio1;

public class Clase1 {

	public static void conFor(int a, int b) {
		// TODO Auto-generated method stub
		for(int i=a;i<=b;i++) {
			System.out.println(i);
		}
	}

	public static void conWhile(int a, int b) {
		// TODO Auto-generated method stub
		while(a<=b) {
			System.out.println(a);
			a++;
		}
	}

	public static void sinIterativas(int a, int b) {
		if(a<=b) {
			System.out.println(a);
			a++;
			sinIterativas(a,b);
		}
	}

}
