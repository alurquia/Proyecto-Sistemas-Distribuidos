package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		try(Socket s = new Socket("localhost",8080);
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
				BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()))){
			
			Scanner teclado = new Scanner(System.in);
			System.out.println("Hola bienvenido al hundir la flota");
			System.out.println(reader.readLine());
			writer.write(teclado.nextLine()+"\n");
			writer.flush();
			
			for(int j =0;j<32;j++) {
				System.out.println(reader.readLine());
			}	
			for(int i = 0; i<10;i++) {
				System.out.println(reader.readLine());
				System.out.println(reader.readLine());
				if(i<4) {
					System.out.println(reader.readLine());
					writer.write(teclado.nextLine());
					
					System.out.println(reader.readLine());
					writer.write(teclado.nextLine());
					
				}else if(i<7) {
					for(int j = 0; j<2;j++) {
						System.out.println(reader.readLine());
						writer.write(teclado.nextLine());
						writer.flush();
						System.out.println(reader.readLine());
						writer.write(teclado.nextLine());
						writer.flush();
					}
				}else if(i<9) {
					for(int k = 0; k<3;k++) {
						System.out.println(reader.readLine());
						writer.write(teclado.nextLine());
						writer.flush();
						System.out.println(reader.readLine());
						writer.write(teclado.nextLine());
						writer.flush();
					}
				}else {
					for(int l = 0; l<4;l++) {
						System.out.println(reader.readLine());
						writer.write(teclado.nextLine());
						writer.flush();
						System.out.println(reader.readLine());
						writer.write(teclado.nextLine());
						writer.flush();
					}
				}
				
				System.out.println(reader.readLine());
				
				for(int j =0;j<32;j++) {
					System.out.println(reader.readLine());
				}
				
			}
			
			while(reader.readLine()=="No hay ganador") {
				for(int i = 0; i < 68;i++){
					System.out.println(reader.readLine());
				}
			}
			System.out.println(reader.readLine());
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
