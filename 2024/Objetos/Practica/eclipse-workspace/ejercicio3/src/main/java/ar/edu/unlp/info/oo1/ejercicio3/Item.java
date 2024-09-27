package ar.edu.unlp.info.oo1.ejercicio3;

public class Item {
	private String detalle;
	private Integer cantidad;
	private Integer costoUnitario;
	
	public Item(String detalle, Integer cantidad, Integer costoUnitario) {
		this.detalle = detalle;
		this.cantidad = cantidad;
		this.costoUnitario = costoUnitario;
	}

	public String getDetalle() {
		return detalle;
	}
	
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Integer getCostoUnitario() {
		return costoUnitario;
	}
	
	public void setCostoUnitario(Integer costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	public Integer costo() {
		return this.cantidad*this.costoUnitario;
	}
	
	
	
}
