
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Principal {

	public static void main(String[] args) {
		
		ExecutorService pool = Executors.newCachedThreadPool();
		try(ServerSocket socket = new ServerSocket (8080)) {
			while (true ) {
				try {
					Socket conexion = socket.accept();
					pool.execute(new AtenderPeticion(conexion));
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			pool.shutdown();
		}

	}	

}
