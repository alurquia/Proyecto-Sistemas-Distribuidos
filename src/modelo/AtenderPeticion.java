package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class AtenderPeticion implements Runnable{

	private Socket s1;
	private Socket s2;
	
	public AtenderPeticion(Socket conexion1, Socket conexion2) {
		this.s1 = conexion1;
		this.s2 = conexion2;
	}
	
	@Override
	public void run() {
		try (BufferedWriter out1 = new BufferedWriter(new OutputStreamWriter( s1.getOutputStream())); BufferedWriter out2 = new BufferedWriter(new OutputStreamWriter(s2.getOutputStream()));
				BufferedReader in1 = new BufferedReader(new InputStreamReader(s1.getInputStream())); BufferedReader in2 = new BufferedReader(new InputStreamReader(s2.getInputStream()))){
			
			out1.write("Escribe tu nombre\r\n");
			out1.flush();
			out2.write("Escribe tu nombre\r\n");
			out2.flush();
			String nombre1 = in1.readLine();
			System.out.println("Hola "+nombre1);
			String nombre2 = in2.readLine();
			System.out.println("Hola "+nombre2);
			
			Jugador jugador1 = new Jugador(out1,in1,nombre1);
			System.out.println("Creado jugador1");
			Jugador jugador2 = new Jugador(out2,in2,nombre2);
			System.out.println("Creado jugador2");
			Partida p = new Partida(jugador1,jugador2);	
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
