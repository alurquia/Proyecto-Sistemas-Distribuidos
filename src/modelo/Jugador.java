package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Jugador {
	
	private String nombre;
	private int numBarcos;
	private Barco[] barcos;
	private Tablero tableroPropio, tableroRival;
	private BufferedWriter writer;
	private BufferedReader reader;
	
	public Jugador (BufferedWriter bw,BufferedReader br,  String nombre) {
		this.writer = bw;
		this.reader = br;
		this.nombre= nombre;
		this.tableroPropio = new Tablero(bw,br);
		this.tableroRival = new Tablero(bw,br);
		this.numBarcos = 10;
		barcos = new Barco[this.numBarcos];
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumBarcos() {
		return numBarcos;
	}

	public void setNumBarcos(int barcos) {
		this.numBarcos = barcos;
	}
	
	public void eliminarCoordenada(int coordenada) {
		boolean encontrado = false;
		for(int i=0;i<this.numBarcos;i++) {
			int tam=barcos[i].getTamaño();
			for(int j=0;j<tam;j++) {
				int b[] = barcos[i].getCoordenadas();
				if(!encontrado && coordenada == b[j] ) {
					barcos[i].setCoordenadas(eliminaUno(coordenada,b));
					barcos[i].setTamaño(barcos[i].getTamaño()-1);
					encontrado = true;
					if(barcos[i].getTamaño()==0) {
						barcos[i]=barcos[this.numBarcos-1];
						this.numBarcos--;
					}
				}
			}
		}
	}
	
	public int[] eliminaUno(int coordenada, int[] colec) {
		int [] colec2 = new int[colec.length-1];
		for(int i = 0;i<colec.length;i++) {
			if(colec[i]==coordenada) {
				colec[i] = colec[colec.length-1];
			}
		}
		for(int i = 0;i<colec.length-1;i++) {
			colec2[i] = colec[i];
		}
		return colec2;
	}
	
	public void addBarco(Barco b,int posicion) {
		this.barcos[posicion] = b;
	}
	
	public Tablero getTableroPropio() {
		return this.tableroPropio;
	}

	public void setTableroPropio(Tablero t) {
		this.tableroPropio = t;
	}
	
	public Tablero getTableroRival() {
		return this.tableroRival;
	}

	public void setTableroRival(Tablero t) {
		this.tableroPropio = t;
	}
	
	public void colocarBarco(Barco b) {
		int tam = b.getTamaño();
		escribir("Seleccione donde poner el barco de "+tam+"\n");
		escribir("Selecciona las casillas para el barco (deben ser numeros entre 0 y 9)\n");
		int x=-1,y=-1;
		
		for(int i=0;i<tam;i++) {
			
			while(x<0||x>9||y<0||y>9) {
				escribir("Coordenada Y:\n");
				y = Integer.parseInt(leer());
				escribir("Coordenada X\n");
				x = Integer.parseInt(leer());
			}
			this.tableroPropio.setCasillaBarco(y,x);
			b.addCoordenada(y*10+x, i);
			x= -1;
			y= -1;
		}
		escribir("                                       TU TABLERO\n");
		this.tableroPropio.mostrar();
	}
	
	public int atacarCasilla() {
		int x=-1,y=-1;
		
		escribir("Selecciona la casilla a atacar (deben ser numeros entre 0 y 9)\n");
		
		while(x<0||x>9||y<0||y>9) {
			escribir("Coordenada Y:\n");
			y = Integer.parseInt(leer());
			escribir("Coordenada X\n");
			x = Integer.parseInt(leer());
		}
		
		return y*10+x;
	}
	
	public void escribir (String s) {
		try {
			this.writer.write(s);
			this.writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String leer() {
		try {
			return this.reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
	public void mostrarTablero(Tablero t) {
		t.mostrar();
	}
}
