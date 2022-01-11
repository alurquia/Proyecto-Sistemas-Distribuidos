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
			
			for(int j =0;j<34;j++) {
				System.out.println(reader.readLine());
			}	
			for(int i = 0; i<10;i++) {
				System.out.println(reader.readLine());
				System.out.println(reader.readLine());
				if(i<4) {
					int x=-1,y=-1;
					boolean valid1=false,valid2=false;
					while(!valid1 || !valid2 || (x<0||x>9||y<0||y>9)) {
						System.out.println(reader.readLine());
						String str1=teclado.nextLine();
						String str2=str1+"\n";
						writer.write(str2);
						writer.flush();
						
						System.out.println(reader.readLine());
						String str3=teclado.nextLine();
						str2=str3+"\n";
						writer.write(str2);
						writer.flush();
						
						valid1=validar(str1);
						valid2=validar(str3);
						
						if(valid1 && valid2) {
							y = Integer.parseInt(str3);
							x = Integer.parseInt(str1);
						}
					}
					
				}else if(i<7) {
					for(int j = 0; j<2;j++) {
						int x=-1,y=-1;
						boolean valid1=false,valid2=false;
						while(!valid1 || !valid2 || (x<0||x>9||y<0||y>9)) {
							System.out.println(reader.readLine());
							String str1=teclado.nextLine();
							String str2=str1+"\n";
							writer.write(str2);
							writer.flush();
							
							System.out.println(reader.readLine());
							String str3=teclado.nextLine();
							str2=str3+"\n";
							writer.write(str2);
							writer.flush();
							
							valid1=validar(str1);
							valid2=validar(str3);
							
							if(valid1 && valid2) {
								y = Integer.parseInt(str3);
								x = Integer.parseInt(str1);
							}
						}
					}
				}else if(i<9) {
					for(int k = 0; k<3;k++) {
						int x=-1,y=-1;
						boolean valid1=false,valid2=false;
						while(!valid1 || !valid2 || (x<0||x>9||y<0||y>9)) {
							System.out.println(reader.readLine());
							String str1=teclado.nextLine();
							String str2=str1+"\n";
							writer.write(str2);
							writer.flush();
							
							System.out.println(reader.readLine());
							String str3=teclado.nextLine();
							str2=str3+"\n";
							writer.write(str2);
							writer.flush();
							
							valid1=validar(str1);
							valid2=validar(str3);
							
							if(valid1 && valid2) {
								y = Integer.parseInt(str3);
								x = Integer.parseInt(str1);
							}
						}
					}
				}else {
					for(int l = 0; l<4;l++) {
						int x=-1,y=-1;
						boolean valid1=false,valid2=false;
						while(!valid1 || !valid2 || (x<0||x>9||y<0||y>9)) {
							System.out.println(reader.readLine());
							String str1=teclado.nextLine();
							String str2=str1+"\n";
							writer.write(str2);
							writer.flush();
							
							System.out.println(reader.readLine());
							String str3=teclado.nextLine();
							str2=str3+"\n";
							writer.write(str2);
							writer.flush();
							
							valid1=validar(str1);
							valid2=validar(str3);
							
							if(valid1 && valid2) {
								y = Integer.parseInt(str3);
								x = Integer.parseInt(str1);
							}
						}
					}
				}
				
				System.out.println(reader.readLine());
				
				for(int j =0;j<32;j++) {
					System.out.println(reader.readLine());
				}
				
			}
			
			String bucle =reader.readLine();
			while(bucle.equals("No hay ganador")) {
				for(int i = 0; i < 68;i++){
					System.out.println(reader.readLine());
				}
				int x=-1,y=-1;
				boolean valid1=false,valid2=false;
				while(!valid1 || !valid2 || (x<0||x>9||y<0||y>9)) {
					System.out.println(reader.readLine());
					String str1=teclado.nextLine();
					String str2=str1+"\n";
					writer.write(str2);
					writer.flush();
					
					System.out.println(reader.readLine());
					String str3=teclado.nextLine();
					str2=str3+"\n";
					writer.write(str2);
					writer.flush();
					
					valid1=validar(str1);
					valid2=validar(str3);
					
					if(valid1 && valid2) {
						y = Integer.parseInt(str3);
						x = Integer.parseInt(str1);
					}
				}
				
				bucle = reader.readLine();
			}
			System.out.println(reader.readLine());
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static boolean validar(String s) {
		int num;
		try {
			num = Integer.parseInt(s);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}

}
