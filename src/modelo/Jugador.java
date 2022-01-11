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
			int tam=barcos[i].getTama�o();
			for(int j=0;j<tam;j++) {
				int b[] = barcos[i].getCoordenadas();
				if(!encontrado && coordenada == b[j] ) {
					barcos[i].setCoordenadas(eliminaUno(coordenada,b));
					barcos[i].setTama�o(barcos[i].getTama�o()-1);
					encontrado = true;
					if(barcos[i].getTama�o()==0) {
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
		int tam = b.getTama�o();
		escribir("Seleccione donde poner el barco de "+tam+"\n");
		escribir("Selecciona las casillas para el barco (deben ser numeros entre 0 y 9)\n");
		int x=-1,y=-1;
		boolean valid1=false,valid2=false;
		
		for(int i=0;i<tam;i++) {
			
			while(!valid1 || !valid2 || (x<0||x>9||y<0||y>9)) {
				escribir("Coordenada Y:\n");
				String read =leer();
				escribir("Coordenada X\n");
				String read2 = leer();
				
				valid1=validar(read);
				valid2=validar(read2);
				
				if(valid1 && valid2) {
					y = Integer.parseInt(read);
					x = Integer.parseInt(read2);
				}
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
		boolean valid1=false,valid2=false;
		
		escribir("Selecciona la casilla a atacar (deben ser numeros entre 0 y 9)\n");
		
		while(!valid1 || !valid2 || (x<0||x>9||y<0||y>9)) {
			escribir("Coordenada Y:\n");
			String read =leer();
			escribir("Coordenada X\n");
			String read2 = leer();
			
			valid1=validar(read);
			valid2=validar(read2);
			
			if(valid1 && valid2) {
				y = Integer.parseInt(read);
				x = Integer.parseInt(read2);
			}
		}
		
		return y*10+x;
	}
	
	public boolean validar(String s) {
		int num;
		try {
			num = Integer.parseInt(s);
			return true;
		}catch(Exception e){
			return false;
		}
		
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
