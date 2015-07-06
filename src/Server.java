import java.net.ServerSocket;
import java.net.Socket;

// Server Prototype
public class Server {
	public static void main(String[] args){
		ServerSocket serverSocket;
		try {
            serverSocket = new ServerSocket(60010);
            while(true)
            {
            	Socket clientSocket = serverSocket.accept();
                ServerThread client = new ServerThread(clientSocket);
                new Thread(client).start();
            }
        }
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
