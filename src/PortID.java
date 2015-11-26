import gnu.io.CommPortIdentifier;  
import gnu.io.SerialPort;  
   
public class PortID {  
     
    public String connect(String portName) throws Exception {  
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);  
   
        if (portIdentifier.isCurrentlyOwned()) {  
            System.out.println("Port in use!"); 
            return null;
        } else {  
            // points who owns the port and connection timeout  
            SerialPort serialPort = (SerialPort) portIdentifier.open("Port", 2000);  
              
            // setup connection parameters  
            serialPort.setSerialPortParams(  
                //38400, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);  
            115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);  

              
            // setup serial port reader  
            String info = new ComPortReceiverID(serialPort.getInputStream()).read();
            serialPort.close();
            return info;
        }  
    }  
}  