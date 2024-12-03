package ar.edu.unlp.info.oo1.parcial;

public class ProductoNacional extends Producto {
	
	public ProductoNacional(String nombre, double costoUnitario, String descripcion) {
		super(nombre, costoUnitario, descripcion);
	}

	@Override
	public double calcularImpuesto(int cantidad) {
		if (cantidad<10) {
			return this.getCostoUnitario()*cantidad*0.05;
		}
		return 0;
	}
}
