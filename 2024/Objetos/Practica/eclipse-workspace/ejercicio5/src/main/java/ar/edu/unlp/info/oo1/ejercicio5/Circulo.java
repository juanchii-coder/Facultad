package ar.edu.unlp.info.oo1.ejercicio5;

public class Circulo extends Figura{
	private int radio;
	
	public Circulo() {
		this.radio=0;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	public int getDiametro() {
		return this.radio*2;
	}

	public double getArea() {
		return Math.PI*Math.pow(radio, 2);
	}

	public double getPerimetro() {
		return Math.PI*2*this.radio;
	}

	
	
}
