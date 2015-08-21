/**
 * @author Daniel Etter (dje67)
 * @version 0.0.2
 * 
 * 
 */
public class GUIPacket{
	private String Band_Number;
	private String Species;
	private String Deploy_Date;
	private String Deploy_Time;
	private String Deploy_Location;
	private String Recover_Date;
	private String Recover_Time;
	private String Recover_Location;
	private String Comment;
	

	public GUIPacket(String Band_Number, String Species, String Deploy_Date,
			String Deploy_Time, String Deploy_Location, String Recover_Date,
			String Recover_Time, String Recover_Location, String Comment) {
		this.Band_Number = Band_Number;
		this.Species = Species;
		this.Deploy_Date = Deploy_Date;
		this.Deploy_Time = Deploy_Time;
		this.Deploy_Location = Deploy_Location;
		this.Recover_Date = Recover_Date;
		this.Recover_Time = Recover_Time;
		this.Recover_Location = Recover_Location;
		this.Comment = Comment;
	}

	/**
	 * Initialize an empty GUIPacket object
	 **/
	public GUIPacket() {
		this.Band_Number = this.Species = this.Deploy_Date = this.Deploy_Time = this.Deploy_Location = this.Recover_Date = this.Recover_Time = this.Recover_Location = this.Comment = null;
	}
	
	// Check if any fields are NULL and then checks if empty
	public boolean check(){
		boolean valid = true;
		
		if(this.Band_Number == null) valid = false;
		else if(this.Band_Number != null && this.Band_Number.isEmpty()) valid = false;
		
		if(this.Species == null) valid = false;
		else if(this.Species != null && this.Species.isEmpty()) valid = false;
		
		if(this.Deploy_Date == null) valid = false;
		else if(this.Deploy_Date != null && this.Deploy_Date.isEmpty()) valid = false;
		
		if(this.Deploy_Time == null) valid = false;
		else if(this.Deploy_Time != null && this.Deploy_Time.isEmpty()) valid = false;
		
		if(this.Deploy_Location == null) valid = false;
		else if(this.Deploy_Location != null && this.Deploy_Location.isEmpty()) valid = false;
		
		if(this.Recover_Date == null) valid = false;
		else if(this.Recover_Date != null && this.Recover_Date.isEmpty()) valid = false;
		
		if(this.Recover_Time == null) valid = false;
		else if(this.Recover_Time != null && this.Recover_Time.isEmpty()) valid = false;
		
		if(this.Recover_Location == null) valid = false;
		else if(this.Recover_Location != null && this.Recover_Location.isEmpty()) valid = false;
		

		return valid;
	}
	
	// Setters and getters
	public void setAll(String Band_Number, String Species, String Deploy_Date,
			String Deploy_Time, String Deploy_Location, String Recover_Date,
			String Recover_Time, String Recover_Location, String Comment){
		this.Band_Number = Band_Number;
		this.Species = Species;
		this.Deploy_Date = Deploy_Date;
		this.Deploy_Time = Deploy_Time;
		this.Deploy_Location = Deploy_Location;
		this.Recover_Date = Recover_Date;
		this.Recover_Time = Recover_Time;
		this.Recover_Location = Recover_Location;
		this.Comment = Comment;
	}
	public void setBand_Number(String Band_Number){
		this.Band_Number = Band_Number;
	}
	public String getBand_Number(){
		return this.Band_Number;
	}

	public String getSpecies() {
		return Species;
	}

	public void setSpecies(String Species) {
		this.Species = Species;
	}

	public String getDeploy_Date() {
		return Deploy_Date;
	}

	public void setDeploy_Date(String Deploy_Date) {
		this.Deploy_Date = Deploy_Date;
	}

	public String getDeploy_Time() {
		return Deploy_Time;
	}

	public void setDeploy_Time(String Deploy_Time) {
		this.Deploy_Time = Deploy_Time;
	}

	public String getDeploy_Location() {
		return Deploy_Location;
	}

	public void setDeploy_Location(String Deploy_Location) {
		this.Deploy_Location = Deploy_Location;
	}

	public String getRecover_Date() {
		return Recover_Date;
	}

	public void setRecover_Date(String Recover_Date) {
		this.Recover_Date = Recover_Date;
	}

	public String getRecover_Time() {
		return Recover_Time;
	}

	public void setRecover_Time(String Recover_Time) {
		this.Recover_Time = Recover_Time;
	}

	public String getLocation() {
		return Recover_Location;
	}

	public void setLocation(String Recover_Location) {
		this.Recover_Location = Recover_Location;
	}
	
	public String getComment() {
		return Comment;
	}

	public void setComment(String Comment){
		this.Comment = Comment;
	}

	/* Creates single string to be used with network communication
	 * returns NULL on error
	 */
	public char[] getStreamable() {
		char[] ret;
		if(check()){
			String all = this.Band_Number+":"+this.Recover_Time+":"+this.Deploy_Date+":"+this.Deploy_Time+":"+this.Deploy_Location
					+":"+this.Recover_Date+":"+this.Recover_Time+":"+this.Recover_Location;
			ret = all.toCharArray();
		}
		else{
			return null;
		}
		return ret;
	}
}
