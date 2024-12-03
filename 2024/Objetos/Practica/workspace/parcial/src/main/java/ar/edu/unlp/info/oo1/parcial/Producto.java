package ar.edu.unlp.info.oo1.parcial;

public abstract class Producto {
	private String nombre;
	private double costoUnitario;
	private String descripcion;
	
	public Producto(String nombre, double costoUnitario, String descripcion) {
		this.nombre = nombre;
		this.costoUnitario = costoUnitario;
		this.descripcion = descripcion;
	}
	
	public abstract double calcularImpuesto(int cantidad);

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
