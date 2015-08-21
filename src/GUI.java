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
	private Label Band_Number_label;
	private Label Species_Label;
	private Label Deploy_Date_Label;
	private Label Deploy_Time_Label;
	private Label Deploy_Location_Label;
	private Label Recover_Date_Label;
	private Label Recover_Time_Label;
	private Label Recover_Location_Label;
	private Label Comment_Label;
	
	//Declare Textfield Components
	private TextField Band_Number;
	private TextField Species;
	private TextField Deploy_Date;
	private TextField Deploy_Time;
	private TextField Deploy_Location;
	private TextField Recover_Date;
	private TextField Recover_Time;
	private TextField Recover_Location;
	private TextField Comment;
	
	//Declare String Resources
	private String Band_Number_Text = "Band Number";
	private String Species_Text = "Species";
	private String Deploy_Date_Text = "Deploy Date";
	private String Deploy_Time_Text = "Deploy Time";
	private String Deploy_Location_Text = "Deploy Location";
	private String Recover_Date_Text = "Recover Date";
	private String Recover_Time_Text = "Recover Time";
	private String Recover_Location_Text = "Recover Location";
	private String Comment_Text = "Comments";
	
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
		Info.setLayout(new GridLayout(9, 2));
		
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
	    
	    //Band Number
	    Band_Number_label = new Label(Band_Number_Text);  // construct Label
		Info.add(Band_Number_label);                    // "super" Frame adds Label
 
      	Band_Number = new TextField("", 10); // construct TextField
      	Band_Number.setEditable(true);       // set to fillable field
      	Info.add(Band_Number);                     // "super" Frame adds field
      
      	//Species
	    Species_Label = new Label(Species_Text);  // construct Label
	    Info.add(Species_Label);                    // "super" Frame adds Label
	 
	    Species = new TextField("", 10); // construct TextField
	    Species.setEditable(true);       // set to fillable field
	    Info.add(Species);                     // "super" Frame adds field
	      
	    //Date Programmed
	    Deploy_Date_Label = new Label(Deploy_Date_Text);  // construct Label
	    Info.add(Deploy_Date_Label);                    // "super" Frame adds Label
	 
	    Deploy_Date = new TextField("", 10); // construct TextField
	    Deploy_Date.setEditable(true);       // set to fillable field
	    Info.add(Deploy_Date);                     // "super" Frame adds field
	      
	    //Date Tested
	    Deploy_Time_Label = new Label(Deploy_Time_Text);  // construct Label
	    Info.add(Deploy_Time_Label);                    // "super" Frame adds Label
	 
	    Deploy_Time = new TextField("", 10); // construct TextField
	    Deploy_Time.setEditable(true);       // set to fillable field
	    Info.add(Deploy_Time);                     // "super" Frame adds field
	      
	    //Date given to customer
	    Deploy_Location_Label = new Label(Deploy_Location_Text);  // construct Label
	    Info.add(Deploy_Location_Label);                    // "super" Frame adds Label
	 
	    Deploy_Location = new TextField("", 10); // construct TextField
	    Deploy_Location.setEditable(true);       // set to fillable field
	    Info.add(Deploy_Location);                     // "super" Frame adds field
	      
	    //Recover_Date
	    Recover_Date_Label = new Label(Recover_Date_Text);  // construct Label
	    Info.add(Recover_Date_Label);                    // "super" Frame adds Label
	 
	    Recover_Date = new TextField("", 10); // construct TextField
	    Recover_Date.setEditable(true);       // set to fillable field
	    Info.add(Recover_Date);                     // "super" Frame adds field
	      
	    //Recover_Time
	    Recover_Time_Label = new Label(Recover_Time_Text);  // construct Label
	    Info.add(Recover_Time_Label);                    // "super" Frame adds Label
	 
	    Recover_Time = new TextField("", 10); // construct TextField
	    Recover_Time.setEditable(true);       // set to fillable field
	    Info.add(Recover_Time);                     // "super" Frame adds field
	      
	    //Recover_Location
	    Recover_Location_Label = new Label(Recover_Location_Text);  // construct Label
	    Info.add(Recover_Location_Label);                    // "super" Frame adds Label
	 
	    Recover_Location = new TextField("", 10); // construct TextField
	    Recover_Location.setEditable(true);       // set to fillable field
	    Info.add(Recover_Location);                     // "super" Frame adds tfCount
	    
	    //Comment
	    Comment_Label = new Label(Comment_Text);
	    Info.add(Comment_Label);
	    Comment = new TextField("", 20);
	    Comment.setEditable(true);
	    Info.add(Comment);
	    
	      
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
				Band_Number.getText(),
				Species.getText(),
				Deploy_Date.getText(),
				Deploy_Time.getText(),
				Deploy_Location.getText(),
				Recover_Date.getText(),
				Recover_Time.getText(),
				Recover_Location.getText(),
				Comment.getText()
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