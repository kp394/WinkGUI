import java.io.IOException;  
import java.io.InputStream;  
   
public class ComPortReceiverID extends Thread {  
   
    InputStream in;  
    ProtocolImplID protocol = new ProtocolImplID();  
   
    public ComPortReceiverID(InputStream in) {  
        this.in = in;  
    }  
      
    public String read() {  
        try {  
            int b;
            String info = null;
            String ID = null;
            String[] data = new String[6];
            
            while (true) {  
                // if stream is not bound in.read() method returns -1  
                while((b = in.read()) != -1) {  
                	ID = protocol.onReceive((byte) b);
                    if (ID != null) break;
                }  

               
                //String TAG_ID = RegexTextTag.getTagID(message);
                //if Message is of the correct type, return data
                if (ID != null)
                	System.out.print("Found ID: " + ID);
                	info = ID;
               /* if (TAG_ID != null)
                	ID = TAG_ID;*/
                
                //if (info != null && ID != null){
                	 if (info != null ){
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
