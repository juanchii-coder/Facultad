package ar.edu.unlp.info.oo1.primerParcialObjetos;

public class Sede {
	private String nombre;
	private double precioXDia;
	private int cantDias;
	
	
	public double calcularPrecioTotal() {
		return this.precioXDia*this.cantDias;
	}
}
