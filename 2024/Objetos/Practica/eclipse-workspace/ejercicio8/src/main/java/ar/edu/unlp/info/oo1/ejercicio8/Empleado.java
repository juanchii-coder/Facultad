package ar.edu.unlp.info.oo1.ejercicio8;

public abstract class Empleado {
	private String nombre;

	public Empleado(String nombre) {
		this.nombre = nombre;
	}
	
	public double montoBasico() {
		// TODO Auto-generated method stub
		return 35000;
	}
	
	public double aportes() {
		// TODO Auto-generated method stub
		return 13500;
	}

	public double sueldoBasico() {
		double valor = this.montoBasico()+this.aportes();
		return valor;
	}
	
}
