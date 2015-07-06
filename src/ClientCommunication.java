import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

// An abstraction of the Java Socket for use by the client side
// Sends formatted JSON strings
public class ClientCommunication {
	private Socket socket;
	private BufferedReader inReader;
	private BufferedWriter outWriter;

	private String hostname = "104.236.255.240";//"localhost"; // TODO: Cornell IT Hosting
	private int port = 60010;

	public ClientCommunication() {
		try {
			this.socket = new Socket(InetAddress.getByName(this.hostname), this.port);
			this.outWriter = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
			this.inReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream())); 
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void send(GUIPacket packet) {
		try {
			// Check validity?
			char[] write = packet.getStreamable();
			assert(write != null);
			this.outWriter.write(write);
			this.outWriter.newLine();
			this.outWriter.flush();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// To be implemented when needed
	public Object recieve() {
		return null;
	}

	public void close() {
		try{
			if(this.outWriter != null) this.outWriter.close();
			if(this.inReader != null) this.inReader.close();
			if(this.socket != null) this.socket.close();
		}
		catch(Exception e){
			// Do nothing, if we're closing a socket we don't care.
		}
	}
}
