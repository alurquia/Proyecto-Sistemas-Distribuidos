
public class Barco {

	private int tamaño;
	private boolean hundido;
	
	public Barco(int tamaño) {
		this.hundido = false;
		this.tamaño = tamaño;
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
	
}
