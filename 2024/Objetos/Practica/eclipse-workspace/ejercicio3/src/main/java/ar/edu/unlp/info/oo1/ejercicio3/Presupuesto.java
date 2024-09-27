package ar.edu.unlp.info.oo1.ejercicio3;

import java.time.*;
import java.util.*;

public class Presupuesto {
	private LocalDate fecha;
	private String cliente;
	private List<Item> items;
	
	
	
	public Presupuesto(String cliente) {
		this.cliente = cliente;
		this.fecha=LocalDate.now();
	    this.items = new ArrayList<Item>();

	}

	public Presupuesto() {
		 this.fecha = LocalDate.now();
		 this.items = new ArrayList<Item>();
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void agregarItem(Item item) {
		this.items.add(item);
	}

	public Integer calcularTotal() {
		Integer total=0;
		for(Item i:items) {
			total+=i.costo();
		}
		return total;
	}
	
	
}
