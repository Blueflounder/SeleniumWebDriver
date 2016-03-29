package com.bitwise.test;

import com.abstraction.test.Child;
import com.inheritance.test.SecondClass;
import com.polymorphism.test.ChildClass;

public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*SecondClass second1 = new SecondClass();
		SecondClass second2 = new SecondClass();
		SecondClass second3 = new SecondClass();
		SecondClass second4 = new SecondClass();
		
		ChildClass child = new ChildClass();
		child.disp();
		child.sum(10, 11);*/
		
		Child newchild = new Child();
		newchild.display();
		newchild.anotherMethod();
		
		
		

	}

}
