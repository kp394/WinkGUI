import java.io.Serializable;

/**
 * @author Daniel Etter (dje67)
 * @version 0.0.1
 * 
 * A GUIPacket represents 
 * 
 */
public class GUIPacket implements Serializable{
	private static final long serialVersionUID = 7526472295622776147L;

	private String BCHCode;
	private String baseID;
	private String dateProgrammed;
	private String dateTested;
	private String dateToCustomer;
	private String customer;
	private String species;
	private String location;

	public GUIPacket(String BCHCode, String baseID, String dateProgrammed,
			String dateTested, String dateToCustomer, String customer,
			String species, String location) {
		this.BCHCode = BCHCode;
		this.baseID = baseID;
		this.dateProgrammed = dateProgrammed;
		this.dateTested = dateTested;
		this.dateToCustomer = dateToCustomer;
		this.customer = customer;
		this.species = species;
		this.location = location;
	}

	/**
	 * Initialize an empty GUIPacket object
	 **/
	public GUIPacket() {
		this.BCHCode = this.baseID = this.dateToCustomer = this.customer = this.species = this.location = null;
	}
	
	// Check if any fields are NULL or empty
	public boolean check(){
		boolean valid = true;
		
		if(this.BCHCode == null) valid = false;
		else if(this.BCHCode != null && this.BCHCode.isEmpty()) valid = false;
		
		if(this.baseID == null) valid = false;
		else if(this.baseID != null && this.baseID.isEmpty()) valid = false;
		
		if(this.dateProgrammed == null) valid = false;
		else if(this.dateProgrammed != null && this.dateProgrammed.isEmpty()) valid = false;
		
		if(this.dateTested == null) valid = false;
		else if(this.dateTested != null && this.dateTested.isEmpty()) valid = false;
		
		if(this.dateToCustomer == null) valid = false;
		else if(this.dateToCustomer != null && this.dateToCustomer.isEmpty()) valid = false;
		
		if(this.customer == null) valid = false;
		else if(this.customer != null && this.customer.isEmpty()) valid = false;
		
		if(this.species == null) valid = false;
		else if(this.species != null && this.species.isEmpty()) valid = false;
		
		if(this.location == null) valid = false;
		else if(this.location != null && this.location.isEmpty()) valid = false;

		return valid;
	}
	
	// Setters and getters
	public void setBCHCode(String BCHCode){
		this.BCHCode = BCHCode;
	}
	public String getBCHCode(){
		return this.BCHCode;
	}

	public String getBaseID() {
		return baseID;
	}

	public void setBaseID(String baseID) {
		this.baseID = baseID;
	}

	public String getDateProgrammed() {
		return dateProgrammed;
	}

	public void setDateProgrammed(String dateProgrammed) {
		this.dateProgrammed = dateProgrammed;
	}

	public String getDateTested() {
		return dateTested;
	}

	public void setDateTested(String dateTested) {
		this.dateTested = dateTested;
	}

	public String getDateToCustomer() {
		return dateToCustomer;
	}

	public void setDateToCustomer(String dateToCustomer) {
		this.dateToCustomer = dateToCustomer;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
