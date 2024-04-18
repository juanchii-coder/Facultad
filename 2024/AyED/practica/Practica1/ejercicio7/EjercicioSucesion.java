package ejercicio7;

import java.util.*;

public class EjercicioSucesion {

	public List<Integer> calcularSucesion(int x) {
		List<Integer> lista=new ArrayList<>();
    	if(x<1) {
	    	if(x%2==0) {
	    		x=(x/2);
	    	}else {
	    		x=3*x+1;
	    	}
	    	lista.add(x);
	    	lista.addAll(calcularSucesion(x));
	    	
    	}
    	lista.add(1);
    	return lista;
    }
}
