package com.revature;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Ship;
import com.revature.models.Spaceport;

public class Driver {

	public static void main(String[] args) {
		Spaceport sp = new Spaceport("Mos Eisley", 1000000, 200, 50);
		Customer cust = new Customer("Kyle",2000);
		Employee emp = new Employee("John",10000, sp);
		Employee emp2 = new Employee("Jon",20000, sp);
		Ship falcon = new Ship(cust, "Falcon");
		
		System.out.println(sp);
	}

}
