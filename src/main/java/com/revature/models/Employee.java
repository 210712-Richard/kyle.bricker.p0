package com.revature.models;

public class Employee extends Customer{
	
	private Spaceport employer;
	
	public void destroyShip(Ship ship) {
		if (ship.getGarage().equals(this.employer)) {
			ship.destroy();
			System.out.println("The "+ship.getName()+" was destroyed\n");
		}
	}
}
