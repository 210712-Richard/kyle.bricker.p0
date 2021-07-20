package com.revature.models;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String name;
	private float money;
	private ArrayList<Ship> ships = new ArrayList<Ship>();

	public Customer(String name, float money) {
		super();
		this.name = name;
		this.money = money;
	}

	public void checkShipIn(Ship ship, Spaceport port) {
		if (port.getShips().contains(ship)) {
			System.out.println("That ship is already checked in\n");
			return;
		} else if (this.money < port.getCheckInFee()) {
			System.out.println("You don't have enough money\n");
			return;
		} else {
			port.getShips().add(ship);
			this.setMoney(this.getMoney() - port.getCheckInFee());
		}
	}

	public void checkShipOut(Ship ship, Spaceport port) {
		if (!port.getShips().contains(ship)) {
			System.out.println("That ship is not in this port\n");
			return;
		} else if (this.money < port.getCheckOutFee()) {
			System.out.println("You don't have enough money\n");
			return;
		} else {
			port.getShips().remove(ship);
			this.setMoney(this.getMoney() - port.getCheckOutFee());
		}
	}

	public void inquire(Spaceport port) {
		System.out.println("Here are the ships you have in this port:\n");
		for (Ship ship : port.getShips()) {
			if (ship.getOwner().equals(this)) {
				System.out.println("   " + ship.getName());
			}
		}
	}
	
	public String toString() {
		String s = "";
		s+= this.name+" - "+this.money+" dollars";
		return s;
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

	public void setShips(ArrayList<Ship> ships) {
		this.ships = ships;
	}

}
