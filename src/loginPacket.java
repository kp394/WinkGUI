
public class loginPacket{
	private String username;
	private String psw;
	
	

	public loginPacket(String username, String psw) {
		this.username = username;
		this.psw = psw;
		
	}

	/**
	 * Initialize an empty loginPacket object
	 **/
	public loginPacket() {
		this.username = this.psw = null;
	}
	
	// Check if any fields are NULL and then checks if empty
	public boolean check(){
		boolean valid = true;
		
		if(this.username == null) valid = false;
		else if(this.username  != null && this.username .isEmpty()) valid = false;
		
		if(this.psw == null) valid = false;
		else if(this.psw != null && this.psw.isEmpty()) valid = false;
		
		return valid;
	}
	
	// Setters and getters
	public void setAll(String username, String psw){
		this.username = username;
		this.psw = psw;
		
	}
	public void setusername(String username){
		this.username = username;
	}
	public String getusername(){
		return this.username;
	}

	public String psw() {
		return psw;
	}

	public void setpsw(String psw) {
		this.psw = psw;
	}

	


	/* Creates single string to be used with network communication
	 * returns NULL on error
	 */
	public char[] getStreamable() {
		char[] ret;
		if(check()){
			String all = this.username+":"+this.psw;
			ret = all.toCharArray();
		}
		else{
			return null;
		}
		return ret;
	}
}
