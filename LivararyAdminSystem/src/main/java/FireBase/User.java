package FireBase;

 public class User {

	 
	public final String PASSWORD ="Password";
	public final String ID ="ID";
	 
	 
	public String getRENTALLIST(String id) {
			 
			 
			 return "USER/"+id+"/대여목록";
		 }	
	public String Userinfo(String id) {
		 
		 
		 return "USER/"+id;
	 }
	
	public String getIDPath(String id) {
		 
		 
		 return "USER/"+id+"/ID";
	 }
	public String getPassWordPath(String id) {
		 
		 
		 return "USER/"+id+"/Password";
	 }
	  

	public String toString() {
		
		
		
		return "USER/";
		
		
	}
}
