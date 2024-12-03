package ar.edu.unlp.info.oo1.parcial;

import java.time.LocalDate;
import java.util.List;

public class Pedido {
	private Cliente cliente;
	private LocalDate fecha;
	private List<ItemPedido> itemsPedidos;
	
	
	
	public Pedido(Cliente cliente) {
		this.cliente = cliente;
		this.fecha = LocalDate.now();
	}
	
	public void agregarItem(ItemPedido item){
		itemsPedidos.add(item);
	}
	
	public double calcularCostoTotal() {
		return this.itemsPedidos.stream()
				.mapToDouble(item -> item.getProducto().getCostoUnitario()*item.getCantidad())
				.sum();
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public List<ItemPedido> obtenerItems() {
		return itemsPedidos;
	}
	
	public void setItemsPedidos(List<ItemPedido> itemsPedidos) {
		this.itemsPedidos = itemsPedidos;
	}
	
	
}
