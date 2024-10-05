package ar.edu.unlp.info.oo1.ejercicio5;

public class Cuadrado extends Figura{
 private int lado;
 
 public Cuadrado() {
	 lado=0;
 }

public int getLado() {
	return lado;
}

public void setLado(int lado) {
	this.lado = lado;
}

public double getArea() {
	return this.lado*this.lado;
}

public double getPerimetro() {
	// TODO Auto-generated method stub
	return this.lado*4;
}
 
}