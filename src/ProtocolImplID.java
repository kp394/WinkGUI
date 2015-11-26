public class ProtocolImplID{  
	   
    byte[] buffer = new byte[1024];  
    int tail = 0;  
      
    public String onReceive(byte b) {  
        // simple protocol: each message ends with new line  
        if (b=='\n') {  
            return onMessage();  
        } else {  
            buffer[tail] = b;  
            tail++;  
            return null;
        }  
    }  
   

      
    /* 
     * When message is recognized onMessage is invoked  
     */  
    private String onMessage() {  
        if (tail!=0) {  
            // constructing message  
            String message = getMessage(buffer, tail);  
            System.out.println("RECEIVED MESSAGE: " + message);  
            tail = 0;  
            String ID = RegexTextTag.getTagID(message);
            return ID;
        }  
        return null;
    }  
      
    // helper methods   
    public byte[] getMessage(String message) {  
        return (message+"\n").getBytes();  
    }  
      
    public String getMessage(byte[] buffer, int len) {  
        return new String(buffer, 0, tail);  
    }  
}  