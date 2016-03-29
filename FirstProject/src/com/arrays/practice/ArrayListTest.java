package com.arrays.practice;

import java.util.*;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("C");
		al.add("C++");
		al.add("Python");
		al.add("Java");
		al.add("Ruby");
		
		int len = al.size();
		
		System.out.println("#1 normal for loop");
			for (int i = 0; i < al.size(); i++)
			{
				System.out.println(al.get(i));
			}
		
		System.out.println("#2 advance for loop");
			for(String language:al)
			{
				System.out.println(language);
			}
		
		System.out.println("#3 while loop");
			int j = 0;
			while(len > j)
			{
				System.out.println(al.get(j));
				j++;
			}
		
		System.out.println("#4 do-while loop");
			int k = 0;
			do{
				System.out.println(al.get(k));
				k++;
			}while(len > k);
			
		System.out.println("#4 iterator");
			Iterator itr = al.iterator();//getting Iterator from arraylist to traverse elements
			while(itr.hasNext())
			{
			   System.out.println(itr.next());
			}   
									
	}

}
