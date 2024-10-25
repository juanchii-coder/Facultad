package ar.edu.unlp.info.oo1.ejercicio12;

public class Cilindro extends Pieza{
	private double altura;
	private double radio;
	
	public Cilindro(String material, String color, int radio, int altura) {
        super(material, color);
        this.radio = radio;
        this.altura = altura;
    }

    @Override
    public double getVolumen() {
        return Math.PI * Math.pow(radio, 2) * altura;
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * radio * (radio + altura);
    }
}
