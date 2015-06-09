import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces

import javax.swing.JPanel;
 
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
	
	private JPanel Info;
	
	private Button btnCount;   // Declare component Button
 
   /** Constructor to setup GUI components and event handling */
	public GUI () {
		setLayout(new FlowLayout());
		setBackground(Color.decode("#D6D6C2"));
		Info = new JPanel();
		Info.setLayout(new GridLayout(8, 1));
         // "super" Frame sets its layout to FlowLayout, which arranges the components
         //  from left-to-right, and flow to next row from top-to-bottom.
		
	    addWindowListener(new WindowAdapter(){
	    	public void windowClosing(WindowEvent e){
	           dispose();
	           System.exit(0); //calling the method is a must
	        }
	     });
	    //GUI Label
	    GUI_Label = new Label("Bird Tagging Log");
	    add(GUI_Label);
	    
	    //BCH Code
		BCH_label = new Label("BCH Code");  // construct Label
		Info.add(BCH_label);                    // "super" Frame adds Label
 
      	BCH_Code = new TextField("", 10); // construct TextField
      	BCH_Code.setEditable(true);       // set to fillable field
      	Info.add(BCH_Code);                     // "super" Frame adds tfCount
      
      	//Base ID
	    Base_ID_Label = new Label("Base ID");  // construct Label
	    Info.add(Base_ID_Label);                    // "super" Frame adds Label
	 
	    Base_ID = new TextField("", 10); // construct TextField
	    Base_ID.setEditable(true);       // set to fillable field
	    Info.add(Base_ID);                     // "super" Frame adds tfCount
	      
	    //Date Programmed
	    Date_Programmed_Label = new Label("Date Programmed");  // construct Label
	    Info.add(Date_Programmed_Label);                    // "super" Frame adds Label
	 
	    Date_Programmed = new TextField("", 10); // construct TextField
	    Date_Programmed.setEditable(true);       // set to fillable field
	    Info.add(Date_Programmed);                     // "super" Frame adds tfCount
	      
	    //Date Tested
	    Date_Tested_Label = new Label("Date Tested");  // construct Label
	    Info.add(Date_Tested_Label);                    // "super" Frame adds Label
	 
	    Date_Tested = new TextField("", 10); // construct TextField
	    Date_Tested.setEditable(true);       // set to fillable field
	    Info.add(Date_Tested);                     // "super" Frame adds tfCount
	      
	    //Date given to customer
	    Date_Given_Label = new Label("Date Given");  // construct Label
	    Info.add(Date_Given_Label);                    // "super" Frame adds Label
	 
	    Date_Given = new TextField("", 10); // construct TextField
	    Date_Given.setEditable(true);       // set to fillable field
	    Info.add(Date_Given);                     // "super" Frame adds tfCount
	      
	    //Customer
	    Customer_Label = new Label("Customer");  // construct Label
	    Info.add(Customer_Label);                    // "super" Frame adds Label
	 
	    Customer = new TextField("", 10); // construct TextField
	    Customer.setEditable(true);       // set to fillable field
	    Info.add(Customer);                     // "super" Frame adds tfCount
	      
	    //Species
	    Species_Label = new Label("Species");  // construct Label
	    Info.add(Species_Label);                    // "super" Frame adds Label
	 
	    Species = new TextField("", 10); // construct TextField
	    Species.setEditable(true);       // set to fillable field
	    Info.add(Species);                     // "super" Frame adds tfCount
	      
	    //Location
	    Location_Label = new Label("Location");  // construct Label
	    Info.add(Location_Label);                    // "super" Frame adds Label
	 
	    Location = new TextField("", 10); // construct TextField
	    Location.setEditable(true);       // set to fillable field
	    Info.add(Location);                     // "super" Frame adds tfCount
	      
	    //Submit Button
	    btnCount = new Button("Submit");   // construct Button
	    
	    add(Info);
	    add(btnCount);                    // "super" Frame adds Button
	 
	    btnCount.addActionListener(this);
	    // Clicking Button source fires ActionEvent
	    // btnCount registers this instance as ActionEvent listener
	 
	    setTitle("Bird Tagging");  // "super" Frame sets title
	    setSize(250, 300);        // "super" Frame sets initial window size
	 
	 
	    setVisible(true);         // "super" Frame shows
	 
	   }
	 
	   /** The entry main() method */
	   public static void main(String[] args) {
	      // Invoke the constructor to setup the GUI, by allocating an instance
	      GUI app = new GUI();
	   }
	 
	   /** ActionEvent handler - Called back upon button-click. */
	   @Override
	   public void actionPerformed(ActionEvent evt) {
	      System.out.println("Works?");
	   }
}