package algo;

public class EjercicioTiempoEjecucion {

	public static void main(String[] args) {
		int i = 0; 
		int j =0;
		int n=3500;
		int cont=0;
		while(i<1000) 
			for( int k = i; k <= n; k++ ) { 
				i++; 
				j++;
		} 
		
		for( int p = 0; p < n*n; p++ ) {
			for( int q = 0; q < p; q++ ) {
				j--;
				cont++;
			}
		}
		System.out.println(i);
		System.out.println(j);
		System.out.println(cont);
	}

}
