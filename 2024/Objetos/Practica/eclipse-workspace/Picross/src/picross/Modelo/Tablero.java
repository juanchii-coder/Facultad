package picross.Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tablero {
    private Celda[][] tablero;
    private Celda[][] solucion;
    private Pista[] pColumnas;
    private Pista[] pFilas;

    public Tablero(int num) {
        if (num >= 1) {
            this.tablero = new Celda[num][num];
            this.solucion = new Celda[num][num];
            this.pColumnas = new Pista[num];
            this.pFilas = new Pista[num];
            inicializarCeldas(tablero);
            randomizarSolucion();
            generarPistaFila();
            generarPistaColumna();
        }
    }

    // Inicializa todas las celdas en estado DESCONOCIDO
    private void inicializarCeldas(Celda[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = new Celda(j, i);
            }
        }
    }

    public Celda[][] getTablero() {
        return tablero;
    }

    public void setTablero(Celda[][] tablero) {
        this.tablero = tablero;
    }

    public Celda[][] getSolucion() {
        return solucion;
    }

    public void setSolucion(Celda[][] solucion) {
        this.solucion = solucion;
    }



    private void randomizarSolucion() {
        Random random = new Random();

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                boolean valor = random.nextBoolean();
                solucion[i][j] = new Celda(j, i, valor);
            }
        }
    }

    private void generarPistaFila() {
    	for (int filaIndex = 0; filaIndex < solucion.length; filaIndex++) {
            List<Integer> bloques = new ArrayList<>();
            int contador = 0;  // Contador para las celdas llenas consecutivas

            // Recorre cada celda de la fila actual
            for (int j = 0; j < solucion[filaIndex].length; j++) {
                if (solucion[filaIndex][j].getSolucion()) {
                    contador++;
                } else {
                    if (contador > 0) {
                        bloques.add(contador);  // Añade el tamaño del grupo de celdas llenas
                        contador = 0;  // Resetea el contador
                    }
                }
            }

            // Si la fila termina con un grupo de celdas llenas
            if (contador > 0) {
                bloques.add(contador);
            }

            // Si no se ha encontrado ningún grupo, agregar un 0
            if (bloques.isEmpty()) {
                bloques.add(0);
            }

            // Crear y almacenar la pista para la fila
            Pista pistaFila = new Pista(true, filaIndex);
            pistaFila.setValor(bloques);
            pFilas[filaIndex] = pistaFila;
        }
    }

    private void generarPistaColumna() {
    	for (int columnaIndex = 0; columnaIndex < solucion[0].length; columnaIndex++) {
            List<Integer> bloques = new ArrayList<>();
            int contador = 0;  // Contador para las celdas llenas consecutivas

            // Recorre cada celda de la columna actual
            for (Celda[] element : solucion) {
                if (element[columnaIndex].getSolucion()) {
                    contador++;
                } else {
                    if (contador > 0) {
                        bloques.add(contador);  // Añade el tamaño del grupo de celdas llenas
                        contador = 0;  // Resetea el contador
                    }
                }
            }

            // Si la columna termina con un grupo de celdas llenas
            if (contador > 0) {
                bloques.add(contador);
            }

            // Si no se ha encontrado ningún grupo, agregar un 0
            if (bloques.isEmpty()) {
                bloques.add(0);
            }

            // Crear y almacenar la pista para la columna
            Pista pistaColumna = new Pista(false, columnaIndex);
            pistaColumna.setValor(bloques);
            pColumnas[columnaIndex] = pistaColumna;
        }
    }



    public Pista[] getpColumnas() {
		return pColumnas;
	}

	public void setpColumnas(Pista[] pColumnas) {
		this.pColumnas = pColumnas;
	}

	public Pista[] getpFilas() {
		return pFilas;
	}

	public void setpFilas(Pista[] pFilas) {
		this.pFilas = pFilas;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Imprimir solución (tablero)
        sb.append("Tablero de solución:\n");
        for (Celda[] element : solucion) {
            for (int j = 0; j < element.length; j++) {
                sb.append(element[j].getSolucion() ? "[■]" : "[X]");
            }
            sb.append("\n");
        }

        // Imprimir pistas de filas
        sb.append("\nPistas de Filas:\n");
        for (Pista p : pFilas) {
            sb.append(p.toString()).append("\n");
        }

        // Imprimir pistas de columnas
        sb.append("\nPistas de Columnas:\n");
        for (Pista p : pColumnas) {
            sb.append(p.toString()).append("\n");
        }

        return sb.toString();
    }

	public int getTamanio() {
		return this.tablero.length;
	}

}

