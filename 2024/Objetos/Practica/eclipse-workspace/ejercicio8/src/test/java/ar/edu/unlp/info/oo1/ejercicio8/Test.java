package ar.edu.unlp.info.oo1.ejercicio8;

public class Test {

	public static void main(String[] args) {
		Gerente alan = new Gerente("Alan Turing");
		double aportesDeAlan = alan.aportes();
		//va al metodo aportes(clase gerente), va al metodo montoBasico(clase gerente)
		//este retorna 57000, y aportes retorna el 5% de montoBasico(2850.0)
		double sueldoBasicoDeAlan = alan.sueldoBasico();
		//va al metodo sueldoBasico(clase EmpleadoJererquico), este va a los metodos 
		//sueldoBasico(clase Empleado) y al metodo bonoPorCategoria(clase EmpleadoJerarquico)
		//este ultimo retorna al metodo sueldoBasico(clase EmpleadoJerarquico) 8000.0, en sueldoBasico(clase Empleado)
		//se va a los metodos montoBasico(clase Gerente) y al metodo aportes(clase Gerente), este retorna 2850.0, y el 
		//anterior retorna 57000, sueldoBasico(clase Empleado) retorna la suma de estos(59850.0), luego 
		//sueldoBasico(clase EmpleadoJerarquico) retorna la suma de los metodos que llamo(67850.0)
		//
		System.out.print("los aportes de alan son: "+aportesDeAlan+"\n El suelda basico de alan es: "+sueldoBasicoDeAlan);

	}

}
