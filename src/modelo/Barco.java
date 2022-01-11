package modelo;

public class Barco {

	private int tamaño;
	private int [] coordenadas;
	private boolean hundido;
	
	public Barco(int tamaño) {
		this.hundido = false;
		this.tamaño = tamaño;
		this.coordenadas = new int[tamaño];
	}

	public int getTamaño() {
		return tamaño;
	}

	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}

	public boolean isHundido() {
		return hundido;
	}

	public void setHundido(boolean hundido) {
		this.hundido = hundido;
	}
	
	public int[] getCoordenadas() {
		return this.coordenadas;
	}
	
	public void setCoordenadas(int [] coordenadas) {
		this.coordenadas = coordenadas;
	}

	public void addCoordenada(int coordenada, int posicion) {
		this.coordenadas[posicion] = coordenada;
	}
	
}