import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.JPanel;


// An AWT program inherits from the top-level container java.awt.Frame
public class welcome extends Frame implements ActionListener {
	// Declare Label Components
	private Label welcome_label;	
	private Label username_label;
	private Label psw_Label;
	private Label Error;
	
	
	//Declare Textfield Components
	private TextField username;
	private TextField psw;
	
	
	//Declare String Resources
	private String username_Text = "username";
	private String psw_Text = "password";
	
	
	
	private Button login;
	
	private JPanel Info;
	private JPanel GUI;
	
	private JPanel error;
	private JPanel cards;
	
	private Button eButton;
 
   /** Constructor to setup GUI components and event handling */
	public welcome () {
		
		setLayout(new CardLayout());
		
		GUI = new JPanel();
		GUI.setLayout(new FlowLayout(FlowLayout.CENTER,200,50));
		GUI.setBackground(Color.decode("#D6D6C2"));
		
		Info = new JPanel();
		Info.setLayout(new GridLayout(2, 2));
		
	
	    addWindowListener(new WindowAdapter(){
	    	public void windowClosing(WindowEvent e){
	           dispose();
	           System.exit(0); 
	        }
	     });
	    //welcome Label
	    welcome_label = new Label("Welcome to the BirdTag Management System");
	    welcome_label.setFont(new java.awt.Font("Dialog", 1, 15));
	    GUI.add(welcome_label);
	    
	    //username
	    username_label = new Label(username_Text);  // construct Label
		Info.add(username_label);                    // "super" Frame adds Label
 
      	username = new TextField("", 10); // construct TextField
      	username.setEditable(true);       // set to fillable field
      	Info.add(username);                     // "super" Frame adds field
      
      	//psw
	    psw_Label = new Label(psw_Text);  // construct Label
	    Info.add(psw_Label);                    // "super" Frame adds Label
	 
	    psw = new TextField("", 10); // construct TextField
	    psw.setEditable(true);       // set to fillable field
	    Info.add(psw);                     // "super" Frame adds field
	      
	   
	    //login Button
	    login = new Button("login");   // construct Button
	    
	    
	    GUI.add(Info);
	    GUI.add(login);                    // "super" Frame adds Button

	   
	    login.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		new GUI();
	    	}
	    });
	    
	    error = new JPanel();
		error.setLayout(new FlowLayout());
		Error = new Label("Invalid input");
		error.add(Error);
		eButton = new Button("Back");
		error.add(eButton);
		eButton.addActionListener(this);


	 
	    setTitle("Welcome");  // "super" Frame sets title
	    setSize(400, 400);        // "super" Frame sets initial window size
	   
	    cards = new JPanel(new CardLayout());
	    cards.add(GUI, "GUI");
	    cards.add(error, "error");

	    add(cards);
	    setVisible(true);         // "super" Frame shows

	 
	   }
	 
	   /** The entry main() method */
	   public static void main(String[] args) {
	      // Invoke the constructor to setup the GUI, by allocating an instance
	      welcome app = new welcome();
	   }
	 
	   /** ActionEvent handler - Called upon button-click. */
	   @Override
	   public void actionPerformed(ActionEvent evt) {
		   
		    Button buttonPressed = (Button)evt.getSource();
		    if (buttonPressed == login){

				loginPacket packet;
				ClientCommunication socket = new ClientCommunication();
				
				packet = new loginPacket(
				username.getText(),
				psw.getText()
				);
				
				if (!packet.check()){
					CardLayout cl = (CardLayout)(cards.getLayout());
					cl.show(cards, "error");
				}
				
				
				//socket.send(packet);
		    }
		    if (buttonPressed == eButton){
			    CardLayout cl = (CardLayout)(cards.getLayout());
			    cl.show(cards, "GUI");
		    }
			
	   }
}