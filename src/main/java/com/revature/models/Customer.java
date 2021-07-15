package com.revature.models;

import java.util.List;

public class Customer {
	
	private String name;
	private float money;
	private List<Ship> ships;
	
	public void checkShipIn(Ship ship, Spaceport port) {
		if(port.getShips().contains(ship)) {
			System.out.println("That ship is already checked in\n");
			return;
		} else if(this.money < port.getCheckInFee()){
			System.out.println("You don't have enough money\n");
			return;
		} else {
			port.getShips().add(ship);
			this.setMoney(this.getMoney()-port.getCheckInFee());
		}
	}
	
	public void checkShipOut(Ship ship, Spaceport port ) {
		if(!port.getShips().contains(ship)) {
			System.out.println("That ship is not in this port\n");
			return;
		} else if(this.money < port.getCheckOutFee()){
			System.out.println("You don't have enough money\n");
			return;
		} else {
			port.getShips().remove(ship);
			this.setMoney(this.getMoney()-port.getCheckOutFee());
		}
	}
	
	public void inquire(Spaceport port) {
		System.out.println("Here are the ships you have in this port:\n");
		for(Ship ship : port.getShips()) {
			if (ship.getOwner().equals(this)) {
				System.out.println("   "+ship.getName());
			}
		}
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public List<Ship> getShips() {
		return ships;
	}

	public void setShips(List<Ship> ships) {
		this.ships = ships;
	}
	
}
