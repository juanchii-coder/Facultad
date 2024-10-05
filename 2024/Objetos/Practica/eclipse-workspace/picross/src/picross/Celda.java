package picross;

public class Celda {
	private EstadoCelda estado;
	private int posFila;
	private int posColumna;
	private boolean solucion;
	
	public Celda(int columna, int fila, boolean valor) {
		this.posColumna=columna;
		this.posFila=fila;
		this.solucion=valor;
		this.estado=EstadoCelda.DESCONOCIDO;
	}
	public Celda(int columna, int fila) {
		this.posColumna=columna;
		this.posFila=fila;
		this.estado=EstadoCelda.DESCONOCIDO;
	}
	
	public EstadoCelda getEstado() {
		return estado;
	}

	public void setEstado(EstadoCelda estado) {
		this.estado = estado;
	}

	public int getPosFila() {
		return posFila;
	}
	
	public void setPosFila(int posicionFila) {
		this.posFila = posicionFila;
	}
	public int getPosColumna() {
		return posColumna;
	}
	public void setPosColumna(int posicionColumna) {
		this.posColumna = posicionColumna;
	}
	public boolean getSolucion() {
		return solucion;
	}
	public void setSolucion(boolean solucion) {
		this.solucion = solucion;
	}
	
	public void marcarRelleno() {
		this.estado=EstadoCelda.RELLENO;
	}
	
	public void marcarMarcado() {
		this.estado=EstadoCelda.MARCADO;
	}
	
}
