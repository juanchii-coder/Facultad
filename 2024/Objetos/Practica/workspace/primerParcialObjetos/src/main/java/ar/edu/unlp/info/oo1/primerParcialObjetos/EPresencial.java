package ar.edu.unlp.info.oo1.primerParcialObjetos;

import java.time.LocalDate;
import java.util.List;

public class EPresencial extends Evento {
	
	private List<Sede> sedes;

	protected double getCostoAdicional() {
		return sedes.stream()
					.mapToDouble(s -> s.calcularPrecioTotal())
					.sum();
	}
	
	public void agregarSede(Sede sede) {
		sedes.add(sede);
	}

	public List<Sede> getSedes() {
		return sedes;
	}

	public void setSedes(List<Sede> sedes) {
		this.sedes = sedes;
	}
	
	
}
