package com.arrays.practice;

public class MediclaimPolicies {
	
	public String[] MedPolicies = {"Silver", "Gold","Platinum", "Diamond" };
	
	public String[] NewPolicies = new String[3];
			
	public void loadNewPolicies(){
		
		NewPolicies [0]= "Basic";
		NewPolicies [1]= "Advanced";
		
	}
	
	public  void displayAllMedPolicies(){
		
		for(String policy:MedPolicies){
			System.out.println(policy);
		}
			
	}
	
}
