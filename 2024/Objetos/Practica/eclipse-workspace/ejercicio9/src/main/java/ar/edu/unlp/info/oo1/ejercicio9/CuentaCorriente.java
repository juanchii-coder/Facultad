package ar.edu.unlp.info.oo1.ejercicio9;

public class CuentaCorriente extends Cuenta{
	private double descubierto;
	
	public CuentaCorriente() {
		super();
		this.descubierto = 0;
	}
	public CuentaCorriente(double ok) {
		super(ok);
		this.descubierto = 0;
	}

	public double getDescubierto() {
		return descubierto;
	}

	public void setDescubierto(double descubierto) {
		this.descubierto = descubierto;
	}

	@Override
	public boolean puedeExtraer(double monto) {
		if(monto<=this.getSaldo()+this.descubierto){
			return true;
		}
		return false;
	}
	
	
}