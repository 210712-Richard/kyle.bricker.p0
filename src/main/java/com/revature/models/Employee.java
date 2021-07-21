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
	
	public void inquire(Spaceport port) {
		if (port.equals(this.employer)) {
			System.out.println("Here are the ships in this port:");
			for (Ship ship : port.getShips()) {
				System.out.println("   " + ship.getName());
			}
		} else {
			System.out.println("You don't have authorization to see this port.");
		}
	}
	
	public void destroyShip(Ship ship) {
		if (ship.getGarage().equals(this.employer)) {
			ship.destroy();
			System.out.println("The "+ship.getName()+" was destroyed\n");
		} else {
			System.out.println("You don't have authorization to destroy this ship.");
		}
	}

	public Spaceport getEmployer() {
		return employer;
	}

	public void setEmployer(Spaceport employer) {
		this.employer = employer;
	}
}
