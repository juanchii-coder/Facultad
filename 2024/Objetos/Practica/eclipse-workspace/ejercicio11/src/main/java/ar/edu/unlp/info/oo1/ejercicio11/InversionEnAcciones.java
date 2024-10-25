package ar.edu.unlp.info.oo1.ejercicio11;

public class InversionEnAcciones implements IInversor{
	private String nombre;
	private int cantidad;
	private double valorUnitario;
	
	
	@Override
	public double valorActual() {
		// TODO Auto-generated method stub
		return this.valorUnitario*this.cantidad;
	}

}
