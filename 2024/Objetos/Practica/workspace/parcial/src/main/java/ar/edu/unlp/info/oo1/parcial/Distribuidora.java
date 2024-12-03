package ar.edu.unlp.info.oo1.parcial;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Distribuidora {
	private Set<Cliente> clientes;
	private Set<Producto> productos;
	
	public Cliente registarCliente(String nombre,String email) {
		return new Cliente(nombre,email);
	}
	
	public ProductoNacional registarProductoNacional(String nombre, double costoUnitario, String descripcion ) {
		return new ProductoNacional(nombre, costoUnitario, descripcion);
	}
	
	public ProductoImportado registarProductoImportado(String nombre, double costoUnitario, String descripcion,String paisOrigen) {
		return new ProductoImportado(nombre, costoUnitario, descripcion,paisOrigen);
	}
	
	public void agregarItemAPedido(Pedido pedido,Producto producto,int cantidad) {
		ItemPedido item=new ItemPedido(producto,cantidad);
		pedido.agregarItem(item);
	}
	
	public void registrarPedidoACliente(Pedido pedido,Cliente cliente) {
		Cliente encontrado = clientes.stream()
	        .filter(c -> c.equals(cliente))
	        .findFirst()
	        .orElse(null);
		if (encontrado != null) {
	        encontrado.agregarPedido(pedido);
	    }
	}
	
	public List<Cliente> obtenerTop5ClientesUlt30Dias() {
	    return this.clientes.stream()
	            .sorted((cliente1, cliente2) -> 
	                Double.compare(
	                    cliente2.costoTotalPedidosEnUnPeriodo(LocalDate.now().minusDays(30), LocalDate.now()),
	                    cliente1.costoTotalPedidosEnUnPeriodo(LocalDate.now().minusDays(30), LocalDate.now())
	                )
	            )
	            .limit(5)
	            .collect(Collectors.toList());
	}

	
	public int calcularTotalSolicitadaDeUnProducto(Producto producto) {
		return clientes.stream()
				.mapToInt(cliente -> cliente.ObtenerPedidos().stream()
						.mapToInt(pedido -> pedido.obtenerItems().stream()
								.filter(item ->item.getProducto().equals(producto))
								.mapToInt(item ->item.getCantidad())
								.sum()
							)
						.sum())
				.sum();
	}
}
