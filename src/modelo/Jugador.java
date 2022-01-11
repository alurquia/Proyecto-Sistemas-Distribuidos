package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Jugador {
	
	private String nombre;
	private int numBarcos;
	private Barco[] barcos;
	private Tablero tableroPropio, tableroRival;
	private Socket s;
	
	public Jugador (Socket s, String nombre) {
		this.s = s;
		this.nombre= nombre;
		this.tableroPropio = new Tablero(s);
		this.tableroRival = new Tablero(s);
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
		for(int i=0;i<10;i++) {
			int tam=barcos[i].getTamaño();
			for(int j=0;j<tam;j++) {
				int b[] = barcos[i].getCoordenadas();
				if(coordenada == b[j]) {
					barcos[i].setCoordenadas(eliminaUno(coordenada,b));
					if(barcos[i].getTamaño()==0) {
						this.numBarcos--;
					}
				}
			}
		}
	}
	
	public int[] eliminaUno(int coordenada, int[] colec) {
		int [] colec2 = new int[colec.length];
		for(int i = 0;i<colec.length;i++) {
			if(colec[i]!=coordenada) {
				colec2[i] = colec[i];
			}
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
		escribir("Selecciona las casillas para el barco\n");
		int x,y;
		
		for(int i=0;i<tam;i++) {
			escribir("Coordenada X:\n");
			x = Integer.parseInt(leer());
			escribir("Coordenada Y\n");
			y = Integer.parseInt(leer());
			
			this.tableroPropio.setCasillaBarco(x,y);
			b.addCoordenada(x*10+y, i);
		}
		escribir("                                       TU TABLERO\n");
		this.tableroPropio.mostrar();
	}
	
	public int atacarCasilla() {
		int x,y;
		Scanner teclado = new Scanner(System.in);
		
		escribir("Selecciona la casilla a atacar\n");
		escribir("Coordenada X:\n");
		x = Integer.parseInt(leer());
		escribir("Coordenada Y\n");
		y = Integer.parseInt(leer());
		
		return x*10+y;
	}
	
	public void escribir (String s) {
		try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(this.s.getOutputStream()))){
			writer.write(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String leer() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.s.getInputStream()))){
			return reader.readLine();
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
