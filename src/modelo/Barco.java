package modelo;

public class Barco {

	private int tama�o;
	private int [] coordenadas;
	private boolean hundido;
	
	public Barco(int tama�o) {
		this.hundido = false;
		this.tama�o = tama�o;
		this.coordenadas = new int[tama�o];
	}

	public int getTama�o() {
		return tama�o;
	}

	public void setTama�o(int tama�o) {
		this.tama�o = tama�o;
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