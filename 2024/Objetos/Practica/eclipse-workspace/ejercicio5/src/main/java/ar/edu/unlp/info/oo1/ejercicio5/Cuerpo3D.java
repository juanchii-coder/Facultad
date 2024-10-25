package ar.edu.unlp.info.oo1.ejercicio5;

public class Cuerpo3D {
	private Figura caraBasal;
	private int altura;
	
	public Object getCaraBasal() {
		return caraBasal;
	}
	
	public void setCaraBasal(Figura caraBasal) {
		this.caraBasal = caraBasal;
	}
	
	public int getAltura() {
		return altura;
	}
	
	public void setAltura(int altura) {
		this.altura = altura;
	}

	public double getSuperficieExterior() {
		return this.caraBasal.getPerimetro()*this.altura+2*this.caraBasal.getArea();
		//area=pi*r^2, perimetro=2*pi*r
	}

	public double getVolumen() {
		return this.caraBasal.getArea()*this.altura;
	}
	
}
