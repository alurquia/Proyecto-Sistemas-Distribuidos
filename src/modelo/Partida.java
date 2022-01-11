package modelo;

public class Partida {

	private Jugador jugador1;
	private Jugador jugador2;
	private String ganador;
	
	public Partida (Jugador jugador1, Jugador jugador2) {
		System.out.println("Creada partida");
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.ganador = null;
		asignarBarcos(jugador1);
		System.out.println("Asignados barcos j1");
		asignarBarcos(jugador2);
		System.out.println("Asignados barcos j2");
		iniciarPartida();
	}
	
	public void asignarBarcos (Jugador j) {
		j.mostrarTablero(j.getTableroPropio());
		normas(j);
		
		Barco b1 = new Barco(1);
		j.addBarco(b1, 0);
		j.colocarBarco(b1);
		
		Barco b2 = new Barco(1);
		j.addBarco(b2, 1);
		j.colocarBarco(b2);
		
		Barco b3 = new Barco(1);
		j.addBarco(b3, 2);
		j.colocarBarco(b3);
		
		Barco b4 = new Barco(1);
		j.addBarco(b4, 3);
		j.colocarBarco(b4);
		
		Barco b5 = new Barco(2);
		j.addBarco(b5, 4);
		j.colocarBarco(b5);
		
		Barco b6 = new Barco(2);
		j.addBarco(b6, 5);
		j.colocarBarco(b6);
		
		Barco b7 = new Barco(2);
		j.colocarBarco(b7);
		j.addBarco(b7, 6);
		
		Barco b8 = new Barco(3);
		j.colocarBarco(b8);
		j.addBarco(b8, 7);
		
		Barco b9 = new Barco(3);
		j.colocarBarco(b9);
		j.addBarco(b9, 8);
		
		Barco b10 = new Barco(4);
		j.colocarBarco(b10);
		j.addBarco(b10, 9);
	}
	
	public void iniciarPartida() {
		while(this.ganador == null) {
			this.jugador1.escribir("No hay ganador\n");
			turno(jugador1, jugador2);
			if(this.ganador == null) {
				this.jugador2.escribir("No hay ganador\n");
				turno(jugador2, jugador1);
			}
		}
		this.jugador1.escribir("Hay ganador\n");
		this.jugador2.escribir("Hay ganador\n");
		this.jugador1.escribir("El ganador es "+ganador+"\n");
		this.jugador2.escribir("El ganador es "+ganador+"\n");
	}
	
	public void turno(Jugador j, Jugador j2) {
		j.escribir("                                       TU TURNO     \n");
		j.escribir("                                      TU TABLERO     \n");
		j.mostrarTablero(j.getTableroPropio());
		j.escribir("                                     TABLERO RIVAL     \n");
		j.mostrarTablero(j.getTableroRival());
		int coordenada = j.atacarCasilla();
		if(j2.getTableroPropio().getCasilla(coordenada/10, coordenada%10) == 1) {
			j.getTableroRival().setCasillaBarcoGolpeado(coordenada/10, coordenada%10);
			j2.getTableroPropio().setCasillaBarcoGolpeado(coordenada/10, coordenada%10);
			j2.eliminarCoordenada(coordenada);
			if(j2.getNumBarcos()== 0) {
				this.ganador = j.getNombre();
			}
		}else {
			j.getTableroRival().setCasillaAgua(coordenada/10, coordenada%10);
			j2.getTableroPropio().setCasillaAgua(coordenada/10, coordenada%10);
		}	
		
	}
	
	public void normas(Jugador j) {
		j.escribir("1.Los barcos no se pueden tocar entre ellos\n");
		j.escribir("2.Los barcos deben seguir una linea horizontal o vertical\n");
	}
	
}
