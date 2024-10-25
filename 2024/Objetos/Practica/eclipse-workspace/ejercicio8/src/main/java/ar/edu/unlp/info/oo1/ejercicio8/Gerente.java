package ar.edu.unlp.info.oo1.ejercicio8;

public class Gerente extends EmpleadoJerarquico {

	public Gerente(String nombre) {
		super(nombre);
	}

	public double aportes() {
		// TODO Auto-generated method stub
		return this.montoBasico()*0.05d;
	}

	public double montoBasico() {
		// TODO Auto-generated method stub
		return 57000;
	}
	

}
