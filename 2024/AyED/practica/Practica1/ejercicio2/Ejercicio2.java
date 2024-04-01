package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
		System.out.println("esbribe un numero: ");
		int num=s.nextInt();
		System.out.println("multiplos de "+num);
		Clase2.Multiplos(num);
	}

}
