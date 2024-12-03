package ar.edu.unlp.info.oo1.parcial;

public class ProductoImportado extends Producto{
	private String paisDeOrigen;
	
	public ProductoImportado(String nombre, double costoUnitario, String descripcion,String paisDeOrigen) {
		super(nombre, costoUnitario, descripcion);
		this.paisDeOrigen=paisDeOrigen;
	}

	@Override
	public double calcularImpuesto(int cantidad) {
		if (this.paisDeOrigen.equals("Brasil")||this.paisDeOrigen.equals("Paraguay")||this.paisDeOrigen.equals("Uruguay")&& cantidad>50) {
			return this.getCostoUnitario()*cantidad*0.08;//un 8%
		}
		return this.getCostoUnitario()*cantidad*0.21; //un 21%
	}
	
	
}
