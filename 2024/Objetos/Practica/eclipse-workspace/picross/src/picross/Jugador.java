package picross;

import java.time.Duration;

public class Jugador {
	private String nombre;
	private Duration tiempo;
	
	
	
	public Jugador(String nombre, int num) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Duration getTiempo() {
		return tiempo;
	}
	
	public void setTiempo(Duration tiempo) {
		this.tiempo = tiempo;
	}

}
