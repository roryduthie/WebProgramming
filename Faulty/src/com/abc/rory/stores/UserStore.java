package com.abc.rory.stores;

public class UserStore {
	private String ReportUsername;
	private String userId;
	
	public UserStore(){

	}

	public void setUsername(String username){
			ReportUsername=username;
	}

	public void setUserId(String id){
		userId=id;
	}
	

	public String getUsername(){
		return ReportUsername;
	}

	public String getId(){
		return userId;
	}
	

}
