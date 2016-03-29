package com.arrays.practice;

public class PolicyAllocation extends MediclaimPolicies {

	static int age;
	static String profession;
	
	public static void main(String args[]){
		
		MediclaimPolicies policy = new MediclaimPolicies();
		policy.displayAllMedPolicies();
		policy.loadNewPolicies();
		
		age = 25;
		profession = "Business";
				
		if(age<=25 && profession.equals("Service")){
			System.out.println("Applicable Mediclaim Policy is: "+policy.NewPolicies[0]);
		}else
			System.out.println("Applicable Mediclaim Policy is: "+policy.NewPolicies[1]);
					
	}
}
