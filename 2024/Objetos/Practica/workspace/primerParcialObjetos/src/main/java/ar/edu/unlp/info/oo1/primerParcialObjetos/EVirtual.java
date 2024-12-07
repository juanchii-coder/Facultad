package ar.edu.unlp.info.oo1.primerParcialObjetos;

import java.time.LocalDate;

public class EVirtual extends Evento {
	private double envio;

	protected double getCostoAdicional() {
		return this.envio;
	}

	public double getEnvio() {
		return envio;
	}

	public void setEnvio(double envio) {
		this.envio = envio;
	}
	
	
}
