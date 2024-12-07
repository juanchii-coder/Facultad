package ar.edu.unlp.info.oo1.primerParcialObjetos;

import java.time.LocalDate;
import java.util.Set;

public class Usuario {
	private String nombre;
	private Set<Entrada> entradas;
	
	public double comprarEntrada(Evento evento, boolean seguro) {
		Entrada entrada= new Entrada(evento, seguro);
		agregarEntrada(entrada);
		return entrada.getPrecio();
	}
	
	//monto total de entradas en un periodo (fecha1, fecha2)
	public double getMontoTotalDeEntradasEnUnPeriodo(LocalDate fechaInicio, LocalDate fechaFin) {
		return entradas.stream()
					   .filter(e -> e.isBetween(fechaInicio,fechaFin))
					   .mapToDouble(e -> e.getPrecio())
					   .sum();
	}
	//siguiente evento
	public Evento getSiguienteEvento() {
		Entrada x= entradas.stream()
					   .filter(e -> e.getEvento().getFecha().isAfter(LocalDate.now()))
					   .sorted((e1, e2) -> e1.getFecha().compareTo(e2.getFecha()))
					   .findFirst()
					   .orElse(null);
		return x.getEvento();
	}
	
	//agregar entrada
	public void agregarEntrada(Entrada entrada) {
		entradas.add(entrada);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Set<Entrada> getEntradas() {
		return entradas;
	}
	public void setEntradas(Set<Entrada> entradas) {
		this.entradas = entradas;
	}
	
	
}
