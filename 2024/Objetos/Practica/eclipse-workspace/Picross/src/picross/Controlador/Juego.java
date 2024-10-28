package picross.Controlador;

import picross.Modelo.*;

import java.time.Duration;
import java.time.Instant;

public class Juego {
    private Tablero tablero;
    private Jugador jugador;
    private Instant inicioJuego;
    private Instant finJuego;
	private Duration tiempo;

    public Juego(String nombre, int num) {
        this.jugador = new Jugador(nombre, num);
        this.tablero = new Tablero(num);
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

    public void setCelda(int x, int y, EstadoCelda valor) {
        switch (valor) {
            case RELLENO:
                this.tablero.getTablero()[x][y].marcarRelleno();
                break;
            case MARCADO:
                this.tablero.getTablero()[x][y].marcarMarcado();
                break;
            case DESCONOCIDO:
                this.tablero.getTablero()[x][y].marcarDesconocido();
                break;
        }
    }

    public boolean isJuegoTerminado() {
        return esSolucionCorrecta();
    }


    public boolean esSolucionCorrecta() {
        Celda[][] solucion = tablero.getSolucion();
        Celda[][] progreso = tablero.getTablero();

        for (int i = 0; i < solucion.length; i++) {
            for (int j = 0; j < solucion[i].length; j++) {
                boolean estadoCeldaProgreso = progreso[i][j].getEstado() == EstadoCelda.RELLENO;
                boolean estadoCeldaSolucion = solucion[i][j].getSolucion();

                if (estadoCeldaProgreso != estadoCeldaSolucion) {
                    return false;
                }
            }
        }
        return true; // Si todas las celdas coinciden, la solución es correcta
    }



    public void setJuegoTerminado(boolean juegoTerminado) {
        if (juegoTerminado) {
            if (esSolucionCorrecta()) {
                this.finJuego = Instant.now();
                this.calcularTiempo();
            }
        }
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

    public String getTiempoTotal() {
        if (finJuego == null || inicioJuego == null) {
            return "El juego no ha finalizado o no se ha iniciado.";
        }

        // Asegúrate de que tiempo no sea null
        if (tiempo == null) {
            return "No se ha calculado el tiempo.";
        }

        long segundos = this.tiempo.getSeconds();
        long minutos = segundos / 60;
        segundos = segundos % 60;

        return String.format("%d minutos y %d segundos", minutos, segundos);
    }


	public String mostrarTableroActual() {
		StringBuilder sb = new StringBuilder();

        // Imprimir solución (tablero)
        sb.append("Tablero actual:\n");
        for (Celda[] element : tablero.getTablero()) {
            for (int j = 0; j < element.length; j++) {
            	if(element[j].getEstado()==EstadoCelda.RELLENO) {
            		sb.append("[■]");
            	}else {
            		sb.append("[X]");
            	}
            }
            sb.append("\n");
        }
		return sb.toString();
	}

}

