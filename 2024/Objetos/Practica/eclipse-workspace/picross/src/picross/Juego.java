package picross;

import java.time.*;

public class Juego {
    private Tablero tablero;
    private Jugador jugador;
    private boolean juegoTerminado;
    private Instant inicioJuego;
    private Instant finJuego;
	private Duration tiempo;

    public Juego(String nombre, int num) {
        this.jugador = new Jugador(nombre, num);
        this.tablero = new Tablero(num);  // Genera el tablero aleatorio
        this.juegoTerminado = false;
        this.inicioJuego = Instant.now();
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public boolean isJuegoTerminado() {
        return esSolucionCorrecta();
    }

    // Método para comparar el progreso del jugador con la solución
    private boolean esSolucionCorrecta() {
        Celda[][] solucion = tablero.getSolucion();
        Celda[][] progreso = tablero.getTablero();

        for (int i = 0; i < solucion.length; i++) {
            for (int j = 0; j < solucion[i].length; j++) {
                if (solucion[i][j].getSolucion() != progreso[i][j].getSolucion()) {
                    return false;  // Si hay alguna diferencia, no es correcto
                }
            }
        }
        return true;  // Si todas las celdas coinciden, es correcto
    }

    public void setJuegoTerminado(boolean juegoTerminado) {
        if (juegoTerminado) {
            if (esSolucionCorrecta()) {
                this.finJuego = Instant.now();
            }
        }
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

    // Método para obtener el progreso actual del jugador
    public Celda[][] getProgreso() {
        return tablero.getTablero();
    }
    
    public void calcularTiempo() {
        if (finJuego != null && inicioJuego != null) {
            this.tiempo = Duration.between(inicioJuego, finJuego);
        }
    }

}

