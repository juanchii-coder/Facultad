package ar.edu.unlp.info.oo1.ejercicio9;

public class CajaDeAhorro extends Cuenta {
	//extraer y depositar se le agregan un 2% de costo adicional
	
	public CajaDeAhorro() {
		super();
	}
	
	public CajaDeAhorro(double ok) {
		super(ok);
	}
	
	@Override
	public boolean puedeExtraer(double monto) {
		if(this.getSaldo()>=monto) {
			return true;
		}
		return false;
	}

	@Override
	public void depositar(double monto) {
		// TODO Auto-generated method stub
		super.depositar(monto-monto*0.02);
	}

	@Override
	public boolean extraer(double monto) {
		return super.extraer(monto+monto*0.02);
	}
	
	

}
