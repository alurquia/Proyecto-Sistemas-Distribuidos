
public class Barco {

	private int tama�o;
	private boolean hundido;
	
	public Barco(int tama�o) {
		this.hundido = false;
		this.tama�o = tama�o;
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
	
}
