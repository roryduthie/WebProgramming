package com.abc.rory.stores;

public class FaultsStore {

	private String Faultid;
	private String FaultSummary;
	private String FaultDetails;
	public FaultsStore(){

	}

	public void setFaultid(String id){
		Faultid=id;
	}

	public void setFaultSummary(String Summary){
		FaultSummary=Summary;
	}
	
	public void setFaultDetails(String Details){
		FaultDetails=Details;
	}

	public String getFaultid(){
		return Faultid;
	}

	public String getFaultSummary(){
		return FaultSummary;
	}
	
	public String getFaultDetails(){
		return FaultDetails;
	}
}
