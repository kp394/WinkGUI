import java.io.BufferedWriter;
import java.io.Console;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

// MySQL Port 3306
public class Test {

	public static void main(String[] args) {
		try{
			ClientCommunication comm = new ClientCommunication();
			GUIPacket packet = new GUIPacket();
			// Populate with test data
			packet.setBaseID("-1");
			packet.setBCHCode("This is a BCH Code");
			packet.setCustomer("I'm a customer");
			packet.setDateProgrammed("Today");
			packet.setDateTested("Tomorrow");
			packet.setDateToCustomer("Friday");
			packet.setLocation("Ithaca");
			packet.setSpecies("Human");
			comm.send(packet);
			comm.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
