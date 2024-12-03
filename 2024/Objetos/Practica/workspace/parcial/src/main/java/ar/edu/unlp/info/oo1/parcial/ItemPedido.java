package ar.edu.unlp.info.oo1.parcial;

public class ItemPedido {
	private Producto producto;
	private int cantidad;
	
	
	public ItemPedido(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	public double calcularCosto() {
		return this.producto.getCostoUnitario()*this.cantidad+this.producto.calcularImpuesto(this.cantidad);
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
