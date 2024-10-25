package ar.edu.unlp.info.oo1.ejercicio8;

public abstract class EmpleadoJerarquico extends Empleado{

	public EmpleadoJerarquico(String nombre) {
		super(nombre);
	}
	
	public double sueldoBasico() {
		double valor =super.sueldoBasico() + this.bonoPorCategoria();
		return valor;
	}
	
	public double montoBasico() {
		// TODO Auto-generated method stub
		return 45000;
	}
	
	public double bonoPorCategoria() {
		// TODO Auto-generated method stub
		return 8000;
	}
}
