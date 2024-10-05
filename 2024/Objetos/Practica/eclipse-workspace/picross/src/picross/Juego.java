package picross;

import java.time.*;


public class Juego {
	private Tablero tablero;
	private Jugador jugador;
	private boolean juegoTerminado;
	private Instant inicioJuego;
	private Instant finJuego;
	
	public Juego(String nombre,int num) {
		this.jugador = new Jugador(nombre, num);
        this.tablero = new Tablero(num);  // Genera el tablero aleatorio
        this.juegoTerminado = false;
        this.inicioJuego = Instant.now();
	}
	
	public Tablero getTablero() {
		// TODO Auto-generated method stub
		return tablero;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public boolean isJuegoTerminado() {
		return juegoTerminado;
	}

	public void setJuegoTerminado(boolean juegoTerminado) {
		this.juegoTerminado = juegoTerminado;
	}

	public Instant getInicioJuego() {
		return inicioJuego;
	}

	public void setInicioJuego(Instant inicioJuego) {
		this.inicioJuego = inicioJuego;
	}

	public Instant getFinJuego() {
		return finJuego;
	}

	public void setFinJuego(Instant finJuego) {
		this.finJuego = finJuego;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
	
	public Celda[][] getProgreso() {
		return tablero.getTablero();
	}
	
	
}
