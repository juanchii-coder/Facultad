package ar.edu.unlp.info.oo1.primerParcialObjetos;

public abstract class Personaje {
	private int nivel;
	private String nombre;
	private int fuerza;
	private int inteligencia;
	private Rol rol;
	
	public Personaje(String nombre, Rol rol) {
		this.nivel=1;
		this.nombre = nombre;
		this.rol = rol;
	}
	
	public abstract double getIncrRaza(int hora);
	
	public double getPoderDeAtaque(int hora) {
		return this.rol.getPoderBase(hora)+this.getIncrRaza(hora);
	}
	
	public void setRol(Rol rol) {
		this.rol=rol;
	}
	
	
}
