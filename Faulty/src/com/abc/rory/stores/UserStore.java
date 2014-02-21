package com.abc.rory.stores;

public class UserStore {
	private String ReportUsername;
	private String userId;
	private String section;
	
	public UserStore(){

	}

	public void setUsername(String username){
			ReportUsername=username;
	}

	public void setUserId(String id){
		userId=id;
	}
	
	public void setSection(String sect){
		section = sect;
	}
	

	public String getUsername(){
		return ReportUsername;
	}

	public String getId(){
		return userId;
	}
	
	public String getSection(){
		return section;
	}
	

}
