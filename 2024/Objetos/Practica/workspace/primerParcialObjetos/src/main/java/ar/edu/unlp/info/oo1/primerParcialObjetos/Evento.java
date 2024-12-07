package ar.edu.unlp.info.oo1.primerParcialObjetos;

import java.time.LocalDate;

public abstract class Evento {
	private String nombre;
	private LocalDate fecha;
	private double precioInscripcion;
	private double precioRemera;
	
	public double consultarAsistencia(LocalDate fecha) {
		double total= this.getCostoBase()+ this.getCostoAdicional();
		if(this.fecha == fecha) {
			total*=1.2;
		}
		return total;
		
	}
	
	protected abstract double getCostoAdicional();

	private double getCostoBase() {
		return this.precioInscripcion+this.precioRemera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getPrecioInscripcion() {
		return precioInscripcion;
	}

	public void setPrecioInscripcion(double precioInscripcion) {
		this.precioInscripcion = precioInscripcion;
	}

	public double getPrecioRemera() {
		return precioRemera;
	}

	public void setPrecioRemera(double precioRemera) {
		this.precioRemera = precioRemera;
	}
	
}
