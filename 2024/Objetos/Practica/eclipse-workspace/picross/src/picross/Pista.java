package picross;

import java.util.List;

/*lo que esta por arriba y al costado del tablero(0=relleno, x=vacio)
 *    |  |  |1 |  |2 |
 *    |5 |3 |2 |5 |2 |
 * 1_3[0][x][0][0][0]
 * 2_2[0][0][x][0][0]
 * 2_1[0][0][x][0][x]
 *  _5[0][0][0][0][0]
 * 1_3[0][x][0][0][0]
 */

public class Pista {
    private boolean esFila;
    private int posicion;
    private List<Integer> valor;

    public Pista(boolean esFila, int posicion) {
        this.esFila = esFila;
        this.posicion = posicion;
    }

    public boolean getEsFila() {
        return esFila;
    }

    public void setEsFila(boolean esFila) {
        this.esFila = esFila;
    }

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public List<Integer> getValor() {
		return valor;
	}

	public void setValor(List<Integer> valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
	    String tipo = esFila ? "Fila" : "Columna";
	    return tipo + " " + (posicion+1) + ": " + valor.toString();
	}

}

