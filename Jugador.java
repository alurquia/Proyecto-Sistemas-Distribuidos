
public class Jugador {
	
	private String nombre;
	private int barcos;
	private Tablero tablero;
	
	public Jugador (String nombre) {
		this.nombre= nombre;
		this.tablero = new Tablero();
		this.barcos = 10;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getBarcos() {
		return barcos;
	}

	public void setBarcos(int barcos) {
		this.barcos = barcos;
	}
}
