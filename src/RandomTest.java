import java.util.Calendar;
import java.util.Date;


public class RandomTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		
		
		System.out.println(today.getTime().toString().substring(11, 20));
	}

}
