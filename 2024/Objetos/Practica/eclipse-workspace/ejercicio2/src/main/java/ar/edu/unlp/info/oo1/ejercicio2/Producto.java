package ar.edu.unlp.info.oo1.ejercicio2;

public class Producto {
	private Double peso;
	private Integer precioPorKilo;
	private String descripcion;
	
	
	
	public Producto() {
		this.peso = 0.0;
		this.precioPorKilo = 0;
		this.descripcion = "";
	}

	public Double getPeso() {
		return peso;
	}
	
	public void setPeso(Object peso) {
		this.peso = (Double)peso;
	}
	
	public Integer getPrecioPorKilo() {
		return precioPorKilo;
	}
	
	public void setPrecioPorKilo(Integer precioPorKilo) {
		this.precioPorKilo = precioPorKilo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Double getPrecio() {
		return this.peso*this.precioPorKilo;
	}
	
}
