package ar.edu.unlp.info.oo1.ejercicio12;

public class Esfera extends Pieza{
	private double radio;

	public Esfera(String material, String color, int radio) {
        super(material, color);
        this.radio = radio;
    }

    @Override
    public double getVolumen() {
        return (4.0 / 3) * Math.PI * Math.pow(radio, 3);
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * Math.pow(radio, 2);
    }
}
