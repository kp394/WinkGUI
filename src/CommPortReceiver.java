import java.io.IOException;  
import java.io.InputStream;  
   
public class CommPortReceiver extends Thread {  
   
    InputStream in;  
    ProtocolImpl protocol = new ProtocolImpl();  
   
    public CommPortReceiver(InputStream in) {  
        this.in = in;  
    }  
      
    public String[] read() {  
        try {  
            int b;
            String[] info = null;
            String ID = null;
            String[] data = new String[6];
            String[] GPS_Info = null;
            
            for (int i = 0; i < 100; i++) {  
                  System.out.print("i:"+i);
                // if stream is not bound in.read() method returns -1  
                while((b = in.read()) != -1) {  
                	GPS_Info = protocol.onReceive((byte) b);
                    if (GPS_Info != null) break;
                }  

               
                //String TAG_ID = RegexTextTag.getTagID(message);
                //if Message is of the correct type, return data
                if (GPS_Info != null)
                	System.out.print("gpsinfo[0]:"+GPS_Info[0]+"i:"+i);
                	info = GPS_Info;
               /* if (TAG_ID != null)
                	ID = TAG_ID;*/
                
                //if (info != null && ID != null){
                	 if (info != null ){
                	data = info;
                	//data[5] = ID;
                	System.out.print("info[0]:"+info[0]+"i:"+i);
                	return info;
                }
                // wait 10ms when stream is broken and check again  
                sleep(10);  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }
		return null;   
    }  
}  

