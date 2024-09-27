package ar.edu.unlp.info.oo1.ejercicio2;

public class Balanza {
	private Integer cantidadDeProductos;
	private Double precioTotal;
	private Double pesoTotal;
	
	
	
	public Balanza() {
		this.cantidadDeProductos = 0;
		this.precioTotal = 0.0;
		this.pesoTotal = 0.0;
	}
	public Integer getCantidadDeProductos() {
		return cantidadDeProductos;
	}
	public void setCantidadDeProductos(Integer cantidadDeProductos) {
		this.cantidadDeProductos = cantidadDeProductos;
	}
	
	public Double getPrecioTotal() {
		return precioTotal;
	}
	
	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public Double getPesoTotal() {
		return pesoTotal;
	}
	
	public void setPesoTotal(Double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
	
	public void agregarProducto(Producto p) {
		this.cantidadDeProductos++;
		this.pesoTotal+= p.getPeso();
		this.precioTotal+= p.getPrecio();
	}
	
	public Ticket emitirTicket() {
		Ticket ticket=new Ticket();
		ticket.setCantidadDeProductos(this.cantidadDeProductos);
		ticket.setPesoTotal(this.pesoTotal);
		ticket.setPrecioTotal(this.precioTotal);
		return ticket;
	}
	
	public void ponerEnCero() {
		this.cantidadDeProductos=0;
		this.pesoTotal=0.0;
		this.precioTotal=0.0;
	}

}
