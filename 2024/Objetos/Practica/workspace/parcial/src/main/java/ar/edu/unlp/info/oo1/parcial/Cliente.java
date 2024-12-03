package ar.edu.unlp.info.oo1.parcial;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Cliente {
	private String nombre;
	private String email;
	private LocalDate fechaDeAlta;
	private List<Pedido> pedidos;
	
	
	
	public Cliente(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
		this.fechaDeAlta=LocalDate.now();
	}
	
	public void agregarPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	public double costoTotalPedidosEnUnPeriodo(LocalDate fechaInicial, LocalDate fechaFinal) {
	    return pedidos.stream()
	            .filter(pedido -> pedido.getFecha().isAfter(fechaInicial) && pedido.getFecha().isBefore(fechaFinal))
	            .mapToDouble(Pedido::calcularCostoTotal)
	            .sum();
	}
	
	public List<Pedido> obtenerPedidosEnUnPeriodo(LocalDate fechaInicial, LocalDate fechaFinal){
		return pedidos.stream()
				.filter(pedido -> pedido.getFecha().isAfter(fechaInicial) && pedido.getFecha().isBefore(fechaFinal))
				.collect(Collectors.toList());
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getFechaDeAlta() {
		return fechaDeAlta;
	}
	public void setFechaDeAlta(LocalDate fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}
	public List<Pedido> ObtenerPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
}
