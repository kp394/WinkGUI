import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

// An abstraction of the Java Socket for use by the client side
public class ClientCommunication {
	private Socket socket;
	private ObjectInputStream rx;
	private ObjectOutputStream tx;

	private String hostname = ""; // IP will go here, or hostname if I get
									// Cornell IT hosting
	private int port = 0; // Same thing, will be set.

	public ClientCommunication() {
		try {
			this.socket = new Socket(InetAddress.getByName(this.hostname), this.port);
			this.tx = new ObjectOutputStream(this.socket.getOutputStream());
			this.rx = new ObjectInputStream(this.socket.getInputStream());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void send(Object sent) {
		try {
			this.tx.writeObject(sent);
			this.tx.flush();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Object recieve() {
		Object recieved = null;
		while (true) {

			try {
				recieved = this.rx.readObject();
				return recieved;
			} catch (EOFException eof) {
				continue;
				// FIXME: this is a hack fix with Object streams, I'll look into
				// it, but it works for now.
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void close() {
		try{
			if(this.tx != null) this.tx.close();
			if(this.rx != null) this.rx.close();
			if(this.socket != null) this.socket.close();
		}
		catch(Exception e){
			// Do nothing, if we're closing a socket we don't care.
		}
	}
}
