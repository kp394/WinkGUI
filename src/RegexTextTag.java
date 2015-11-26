//import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.IOException;

public class RegexTextTag  {


	public static void main(String argv[]) throws IOException{

		String filePath = "C:\\Users\\apple\\Desktop\\courses\\bir tag\\captureVenusGPS.txt";

		String fileContent = readFileContent(filePath);



	}

	private static String readFileContent(String filename) throws IOException {


		File file = new File(filename);

		BufferedReader bf = new BufferedReader(new FileReader(file));

		String content = "";
		StringBuilder sb = new StringBuilder();

		while(content != null){
			content = bf.readLine();

			if(content == null){
				break;
			}


			content.trim();
			String[] contentStr = content.split("$");
			for(int i=0;i<contentStr.length;i++){

				getGPGGA(contentStr[i]);

			}
		}

		bf.close();
		return sb.toString();

	}

	public static String[] getGPGGA(String str){
		String regEx="((\\$GPGGA),+[0-2]+[0-3]+[0-5]+\\d{1}+[0-5]+\\d{1}.+\\d{3},"
				+ "+\\d{4}.+\\d{4},+(N|S),+\\d{5}.+\\d{4},+(E|W),+[0-8],+(0|1)+[0-2],"
				+ "+\\d{1,2}.+\\d{1},+(M),+(0.0),+(M),,(0000)+\\*+\\d{1}+(\\d{1}|[A-F]))";
		
		//String regEx="$GPGGA,115946.000,2400.0000,N,12100.0000,E,0,00,0.0,0.0,M,0.0,M,,0000*67";

		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(str);
		String[] GPGGA= new String[5];

		if(!matcher.find()){
		
			GPGGA[0] = ""; // UTC time
			GPGGA[1] = ""; // latitude
			GPGGA[2] = ""; // N/S
			GPGGA[3] = ""; // longitude
			GPGGA[4] = ""; // E/W
			System.out.println("wrong");
			return null;
		}
		GPGGA[0] = str.substring(7, 17); // UTC time
		GPGGA[1] = str.substring(18, 27); // latitude
		GPGGA[2] = str.substring(28, 29); // N/S
		GPGGA[3] = str.substring(30, 40); // longitude
		GPGGA[4] = str.substring(41, 42); // E/W

		System.out.println("cool"+GPGGA[0]+","+GPGGA[1]+","+GPGGA[2]+","+GPGGA[3]+","+GPGGA[4]);	//分组的索引值是从1开始的，所以取第一个分组的方法是m.group(1)而不是m.group(0)。
		return GPGGA;
	}
	/* regEx for tagID*/
	public static String getTagID(String str){
		String tag = str.substring(0, 8);
		String regEx = "(\\d{1}|[A-F])+(\\d{1}|[A-F])+(\\d{1}|[A-F])+(\\d{1}|[A-F])+(\\d{1}|[A-F])+(\\d{1}|[A-F])+(\\d{1}|[A-F])+(\\d{1}|[A-F])";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(tag);
		

		if(!matcher.find()){
			
			return "";
		}
	
		return tag;
	}


}
