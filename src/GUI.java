import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces

import javax.swing.JPanel;

/**
 * @author Kevin Pu (kp394@cornell.edu)
 * 
 * GUI Class for a UI to log RF Tag info
 * 
 */
// An AWT program inherits from the top-level container java.awt.Frame
public class GUI extends Frame implements ActionListener {
	// Declare Label Components
	private Label GUI_Label;
	private Label BCH_label;
	private Label Base_ID_Label;
	private Label Date_Programmed_Label;
	private Label Date_Tested_Label;
	private Label Date_Given_Label;
	private Label Customer_Label;
	private Label Species_Label;
	private Label Location_Label;
	
	//Declare Textfield Components
	private TextField BCH_Code;
	private TextField Base_ID;
	private TextField Date_Programmed;
	private TextField Date_Tested;
	private TextField Date_Given;
	private TextField Customer;
	private TextField Species;
	private TextField Location;
	
	private Label Error;
	private Button eButton;
	
	private JPanel Info;
	private JPanel GUI;
	private JPanel error;
	private JPanel cards;
	
	private Button button;   // Declare component Button
 
   /** Constructor to setup GUI components and event handling */
	public GUI () {
		
		setLayout(new CardLayout());
		
		GUI = new JPanel();
		GUI.setLayout(new FlowLayout());
		GUI.setBackground(Color.decode("#D6D6C2"));
		
		Info = new JPanel();
		Info.setLayout(new GridLayout(8, 1));
		
		//Handles exit button on the window
	    addWindowListener(new WindowAdapter(){
	    	public void windowClosing(WindowEvent e){
	           dispose();
	           System.exit(0); //calling the method is a must
	        }
	     });
	    //GUI Label
	    GUI_Label = new Label("Bird Tagging Log");
	    GUI.add(GUI_Label);
	    
	    //BCH Code
		BCH_label = new Label("BCH Code");  // construct Label
		Info.add(BCH_label);                    // "super" Frame adds Label
 
      	BCH_Code = new TextField("", 10); // construct TextField
      	BCH_Code.setEditable(true);       // set to fillable field
      	Info.add(BCH_Code);                     // "super" Frame adds field
      
      	//Base ID
	    Base_ID_Label = new Label("Base ID");  // construct Label
	    Info.add(Base_ID_Label);                    // "super" Frame adds Label
	 
	    Base_ID = new TextField("", 10); // construct TextField
	    Base_ID.setEditable(true);       // set to fillable field
	    Info.add(Base_ID);                     // "super" Frame adds field
	      
	    //Date Programmed
	    Date_Programmed_Label = new Label("Date Programmed");  // construct Label
	    Info.add(Date_Programmed_Label);                    // "super" Frame adds Label
	 
	    Date_Programmed = new TextField("", 10); // construct TextField
	    Date_Programmed.setEditable(true);       // set to fillable field
	    Info.add(Date_Programmed);                     // "super" Frame adds field
	      
	    //Date Tested
	    Date_Tested_Label = new Label("Date Tested");  // construct Label
	    Info.add(Date_Tested_Label);                    // "super" Frame adds Label
	 
	    Date_Tested = new TextField("", 10); // construct TextField
	    Date_Tested.setEditable(true);       // set to fillable field
	    Info.add(Date_Tested);                     // "super" Frame adds field
	      
	    //Date given to customer
	    Date_Given_Label = new Label("Date Given");  // construct Label
	    Info.add(Date_Given_Label);                    // "super" Frame adds Label
	 
	    Date_Given = new TextField("", 10); // construct TextField
	    Date_Given.setEditable(true);       // set to fillable field
	    Info.add(Date_Given);                     // "super" Frame adds field
	      
	    //Customer
	    Customer_Label = new Label("Customer");  // construct Label
	    Info.add(Customer_Label);                    // "super" Frame adds Label
	 
	    Customer = new TextField("", 10); // construct TextField
	    Customer.setEditable(true);       // set to fillable field
	    Info.add(Customer);                     // "super" Frame adds field
	      
	    //Species
	    Species_Label = new Label("Species");  // construct Label
	    Info.add(Species_Label);                    // "super" Frame adds Label
	 
	    Species = new TextField("", 10); // construct TextField
	    Species.setEditable(true);       // set to fillable field
	    Info.add(Species);                     // "super" Frame adds field
	      
	    //Location
	    Location_Label = new Label("Location");  // construct Label
	    Info.add(Location_Label);                    // "super" Frame adds Label
	 
	    Location = new TextField("", 10); // construct TextField
	    Location.setEditable(true);       // set to fillable field
	    Info.add(Location);                     // "super" Frame adds tfCount
	      
	    //Submit Button
	    button = new Button("Submit");   // construct Button
	    
	    GUI.add(Info);
	    GUI.add(button);                    // "super" Frame adds Button
	 
	    button.addActionListener(this);
	    // Clicking Button source fires ActionEvent
	    // btnCount registers this instance as ActionEvent listener
	    
		
		error = new JPanel();
		error.setLayout(new FlowLayout());
		Error = new Label("Invalid input");
		error.add(Error);
		eButton = new Button("Back");
		error.add(eButton);
		eButton.addActionListener(this);
	 
	    setTitle("Bird Tagging");  // "super" Frame sets title
	    setSize(250, 300);        // "super" Frame sets initial window size
	    
	    cards = new JPanel(new CardLayout());
	    cards.add(GUI, "GUI");
	    cards.add(error, "error");

	    add(cards);
	    setVisible(true);         // "super" Frame shows
	 
	   }
	 
	   /** The entry main() method */
	   public static void main(String[] args) {
	      // Invoke the constructor to setup the GUI, by allocating an instance
	      GUI app = new GUI();
	   }
	 
	   /** ActionEvent handler - Called upon button-click. */
	   @Override
	   public void actionPerformed(ActionEvent evt) {
		   
		    Button buttonPressed = (Button)evt.getSource();
		    if (buttonPressed == button){

				GUIPacket packet;
				ClientCommunication socket = new ClientCommunication();
				
				packet = new GUIPacket(
				BCH_Code.getText(),
				Base_ID.getText(),
				Date_Programmed.getText(),
				Date_Tested.getText(),
				Date_Given.getText(),
				Customer.getText(),
				Species.getText(),
				Location.getText()
				);
				
				if (!packet.check()){
					CardLayout cl = (CardLayout)(cards.getLayout());
					cl.show(cards, "error");
				}
				
				//handle exceptions on GUI side to display errors?
				socket.send(packet);
		    }
		    if (buttonPressed == eButton){
			    CardLayout cl = (CardLayout)(cards.getLayout());
			    cl.show(cards, "GUI");
		    }
			
	   }
}