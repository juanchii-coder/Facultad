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
	}

}
