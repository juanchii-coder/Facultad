package ar.edu.unlp.info.oo1.primerParcialObjetos;

import java.time.LocalDate;
import java.time.Period;

public class Entrada {
	private boolean seguro;
	private Evento evento;
	private LocalDate fecha;//fecha en el que se compro la entrada
	
	public Entrada(Evento evento2, boolean seguro2) {
		this.seguro=seguro2;
		this.evento=evento2;
		this.fecha=LocalDate.now();
	}

	//get precio
	public double getPrecio() {
		if (seguro) {
			return evento.consultarAsistencia(fecha)+500;
		}
		return evento.consultarAsistencia(fecha);
	}

	//calcular monto a recuperar
	public double montoARecuperar() {
		int diferencia= Period.between(this.fecha, this.evento.getFecha()).getDays();
		if(diferencia>30) {
			if(seguro) {
				return this.evento.consultarAsistencia(this.fecha)*0.65;
			}
			return this.evento.consultarAsistencia(this.fecha)*0.5;
		}else {
			if(seguro) {
				return this.evento.consultarAsistencia(this.fecha)*0.15;
			}
			return 0;
		}
	}
	
	public boolean isSeguro() {
		return seguro;
	}

	public void setSeguro(boolean seguro) {
		this.seguro = seguro;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public boolean isBetween(LocalDate fechaInicio, LocalDate fechaFin) {
		return this.fecha.isAfter(fechaInicio)&&this.fecha.isBefore(fechaFin);
	}
	
}
