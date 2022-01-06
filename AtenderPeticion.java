import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URLConnection;
import java.util.Date;


public class AtenderPeticion implements Runnable{

	private Socket s;
	
	public AtenderPeticion(Socket server) {
		this.s=server;
	}
	
	@Override
	public void run() {
		try (BufferedReader in = new BufferedReader(new InputStreamReader( s.getInputStream()));
				OutputStream out = s.getOutputStream()){
		
		} catch (Exception e) {
		e.printStackTrace();
		}
}
