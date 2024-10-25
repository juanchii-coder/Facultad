package ar.edu.unlp.info.oo1.ejercicio11;

import java.util.List;

public class Inversor implements IInversor{
	private String nombre;
	private List<IInversor> inversiones;
	
	public void agregarInversinon(IInversor inversion) {
		this.inversiones.add(inversion);
	}
	
	@Override
	public double valorActual() {
		double total=0;
		for(IInversor i:inversiones) {
			total+=i.valorActual();
		}
		return total;
	}

}
