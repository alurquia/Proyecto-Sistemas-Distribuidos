package modelo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tablero {

	private String[][] casillas;
	private BufferedWriter writer;
	private BufferedReader reader;
	
	public Tablero(BufferedWriter bw,BufferedReader br) {
		this.casillas = new String[10][10];
		this.writer = bw;
		this.reader = br;
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				this.casillas[i][j] = " ";
			}
		}
	}
	
	public void setCasillaBarco(int i, int j) {
		this.casillas[i][j]= "B";
	}
	
	public void setCasillaBarcoGolpeado(int i, int j) {
		this.casillas[i][j]= "X";
	}
	
	public void setCasillaAgua(int i, int j) {
		this.casillas[i][j]= "O";
	}
	
	public int getCasilla(int i, int j) {
		if(this.casillas[i][j] == "B") {
			return 1;
		}else {
			return 0;
		}
	}
	
	public void mostrar() {
		escribir("       0       1       2       3       4       5       6       7       8       9\n");
		escribir("   ________________________________________________________________________________\n");
		for(int i=0;i<10;i++) {
			escribir(  "   |       |       |       |       |       |       |       |       |       |       |\n");
			if(i!=9) {
				escribir(i+"  ");
			}else {
				escribir(i+"  ");
			}
			for(int j=0;j<10;j++) {
				escribir("|   "+this.casillas[i][j]+"   ");
			}
			escribir("|\n");
			escribir("   |_______|_______|_______|_______|_______|_______|_______|_______|_______|_______|\n");
			
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
}
