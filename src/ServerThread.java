import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// ~
public class ServerThread implements Runnable{
	private Socket socket;
	
	public ServerThread(Socket clientSocket){
		this.socket = clientSocket;
	}

	@Override
	public void run() {
		
		Connection con = null;
		PreparedStatement pst = null;

		String url = "jdbc:mysql://localhost:3306/cutaber";
		String user = "taber";
		String password = "taberpw";
		
		String[] parts = null;
		
		try{
			BufferedReader in = new BufferedReader(
                    new InputStreamReader(this.socket.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                parts = line.split(":");
            }
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            con = DriverManager.getConnection(url, user, password);
            pst = con.prepareStatement(
            		"INSERT INTO tags(ID, BCHCode, BaseID, DateProgrammed, DateTested, DateToCustomer, Customer, Species, Location)"
					+ " VALUES(? ,?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, null); // Auto-incremented ID
            pst.setString(2, parts[0]);
			pst.setString(3, parts[1]);
			pst.setString(4, parts[2]);
			pst.setString(5, parts[3]);
			pst.setString(6, parts[4]);
			pst.setString(7, parts[5]);
			pst.setString(8, parts[6]);
			pst.setString(9, parts[7]);
			pst.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();	
		}
		finally{
			try{
				if (pst != null) pst.close();
				if (con != null) con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}

}
