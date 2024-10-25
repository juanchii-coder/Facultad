package ar.edu.unlp.info.oo1.ejercicio12;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {
	private List<Pieza> piezas;

    public ReporteDeConstruccion() {
        this.piezas = new ArrayList<>();
    }

    public void agregarPieza(Pieza pieza) {
        piezas.add(pieza);
    }

    public double volumenDeMaterial(String material) {
        double volumenTotal = 0;
        for (Pieza pieza : piezas) {
            if (pieza.getMaterial().equals(material)) {
                volumenTotal += pieza.getVolumen();
            }
        }
        return volumenTotal;
    }

    public double superficieDeColor(String color) {
        double areaTotal = 0;
        for (Pieza pieza : piezas) {
            if (pieza.getColor().equals(color)) {
                areaTotal += pieza.getArea();
            }
        }
        return areaTotal;
    }
}
