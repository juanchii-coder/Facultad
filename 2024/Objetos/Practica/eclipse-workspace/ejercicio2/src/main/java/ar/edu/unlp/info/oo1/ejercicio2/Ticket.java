package ar.edu.unlp.info.oo1.ejercicio2;

import java.time.*;

public class Ticket {
	private LocalDate fecha;
	private Integer cantidadDeProductos;
	private Double pesoTotal;
	private Double precioTotal;
	
	
	
	public Ticket(){
		this.fecha = LocalDate.now();
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public Integer getCantidadDeProductos() {
		return cantidadDeProductos;
	}
	
	public void setCantidadDeProductos(Integer cantidadDEProductos) {
		this.cantidadDeProductos = cantidadDEProductos;
	}
	
	public Double getPesoTotal() {
		return pesoTotal;
	}
	
	public void setPesoTotal(Double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
	
	public Double getPrecioTotal() {
		return precioTotal;
	}
	
	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	
	public Double impuesto() {
		return this.precioTotal*0.21;
	}
	
	
}
