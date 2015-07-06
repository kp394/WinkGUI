import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class MySQLTest {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pst = null;

		String url = "jdbc:mysql://localhost:3306/cutaber";
		String user = "taber";
		String password = "taberpw";

		try {

			String BCH = "BCHCodeTest";
			String BaseID = "-1";
			String dateProg = "DateProgTest";
			String dateTested = "DateTestedTest";
			String dateToCustomer = "DateToCustomerTest";
			String customer = "customerTest";
			String species = "speciesTest";
			String location = "locationTest";
			con = DriverManager.getConnection(url, user, password);

			pst = con.prepareStatement("INSERT INTO tags(BCHCode, BaseID, DateProgrammed, DateTested, DateToCustomer, Customer, Species, Location)"
					+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
			pst.setString(1, BCH);
			pst.setString(2, BaseID);
			pst.setString(3, dateProg);
			pst.setString(4, dateTested);
			pst.setString(5, dateToCustomer);
			pst.setString(6, customer);
			pst.setString(7, species);
			pst.setString(8, location);
			pst.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();

		} finally {

			try {
				if (pst != null) {
					pst.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException ex) {
				//
			}
		}
	}
}