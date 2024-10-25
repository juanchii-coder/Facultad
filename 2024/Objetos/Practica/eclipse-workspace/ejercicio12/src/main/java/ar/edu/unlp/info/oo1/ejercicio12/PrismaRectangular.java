package ar.edu.unlp.info.oo1.ejercicio12;

public class PrismaRectangular extends Pieza{
	private double ladoMayor;
	private double ladoMenor;
	private double altura;
	
	public PrismaRectangular(String material, String color, int ladoMayor, int ladoMenor, int altura) {
        super(material, color);
        this.ladoMayor = ladoMayor;
        this.ladoMenor = ladoMenor;
        this.altura = altura;
    }

    @Override
    public double getVolumen() {
        return ladoMayor * ladoMenor * altura;
    }

    @Override
    public double getArea() {
        return 2 * (ladoMayor * ladoMenor + ladoMayor * altura + ladoMenor * altura);
    }
}
