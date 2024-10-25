package ar.edu.unlp.info.oo1.ejercicio11;

import java.time.LocalDate;

public class PlazoFijo implements IInversor{
	private LocalDate fechaDeContruccion;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;
	
	@Override
	public double valorActual() {
		int diferencia=LocalDate.now().getDayOfYear()-this.fechaDeContruccion.getDayOfYear();
		return this.montoDepositado+this.montoDepositado*(this.porcentajeDeInteresDiario*diferencia)/100;
	}

}
