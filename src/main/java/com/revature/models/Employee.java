package com.revature.models;

import java.util.ArrayList;

public class Employee extends Customer{
	
	public Employee(String name, float money, Spaceport s) {
		super(name, money);
		this.employer=s;
		ArrayList<Employee> e = s.getEmployees();
		e.add(this);
		s.setEmployees(e);
	}

	private Spaceport employer;
	
	
	
	public void destroyShip(Ship ship) {
		if (ship.getGarage().equals(this.employer)) {
			ship.destroy();
			System.out.println("The "+ship.getName()+" was destroyed\n");
		}
	}

	public Spaceport getEmployer() {
		return employer;
	}

	public void setEmployer(Spaceport employer) {
		this.employer = employer;
	}
}
