package ar.edu.unlp.info.oo1.ejercicio6;

import java.util.*;

public class Mamifero {
	private String especie; 
	private String identificador;
	private Mamifero padre;
	private Mamifero madre;
	private List<Mamifero> ancestros;
	
	public Mamifero() {
		this.identificador= "";
		ancestros=new ArrayList<Mamifero>();
	}
	
	public Mamifero(String nombre) {
		this.identificador= nombre;
		ancestros=new ArrayList<Mamifero>();
	}
	
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public List<Mamifero> getAncestros() {
		return ancestros;
	}

	public void setAncestros(List<Mamifero> ancestros) {
		this.ancestros = ancestros;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Mamifero getPadre() {
		return padre;
	}

	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}

	public Mamifero getMadre() {
		return madre;
	}

	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}

	public Mamifero getAbueloMaterno() {
		if (this.getMadre()!=null) {
			return this.madre.getPadre();
		}
		return null;
	}
	
	public Mamifero getAbuelaMaterna() {
		if (this.getMadre()!=null) {
			return this.madre.getMadre();
		}
		return null;
	}
	
	public Mamifero getAbueloPaterno() {
		if (this.getPadre()!= null) {
			return this.padre.getPadre();
		}
		return null;
	}
	public Mamifero getAbuelaPaterna() {
		if (this.getPadre()!= null) {
			return this.padre.getMadre();
		}
		return null;
	}

	public boolean tieneComoAncestroA(Mamifero x) {
		boolean ancestro=false;
		if(this.getMadre()!=null) {
			if(this.getMadre().equals(x)) {
				ancestro=true;
			}else {
				this.getMadre().tieneComoAncestroA(x);
			}
		}else if((!ancestro) &&(this.getPadre()!=null)) {
			if(this.getPadre().equals(x)) {
				ancestro=true;
			}else {
				this.getPadre().tieneComoAncestroA(x);
			}
		}
		
		
		return ancestro;
	}
	
}
