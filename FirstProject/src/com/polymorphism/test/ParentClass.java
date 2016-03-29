package com.polymorphism.test;

import org.apache.commons.collections.bag.SynchronizedSortedBag;

public class ParentClass {

	public void disp() {

		System.out.println("This is 1st parent class method");
	}
	
	public void sum(int i, int j){
		
		i = 10;
		j = 11;
		int total = i + j;
		System.out.println("Parernt Class: Addition is:"+" "+total);
		
	}

}		
