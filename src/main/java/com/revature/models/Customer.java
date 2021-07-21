package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Serializable{

	private String name;
	private float money;
	private ArrayList<Ship> ships = new ArrayList<Ship>();
	private static final long serialVersionUID = 2622951313170302024L;

	public Customer(String name, float money) {
		super();
		this.name = name;
		this.money = money;
	}

	public void checkShipIn(Ship ship, Spaceport port) {
		if (port.getShips().contains(ship)) {
			System.out.println("That ship is already checked in.");
			return;
		} else if (this.money < port.getCheckInFee()) {
			System.out.println("You don't have enough money.");
			return;
		} else {
			System.out.println("You paid "+port.getCheckInFee()+" and checked the "+ship.getName()+" into "+port.getName()+".");
			port.getShips().add(ship);
			this.setMoney(this.getMoney() - port.getCheckInFee());
		}
	}

	public void checkShipOut(Ship ship, Spaceport port) {
		if (!port.getShips().contains(ship)) {
			System.out.println("That ship is not in this port.");
			return;
		} else if (this.money < port.getCheckOutFee()) {
			System.out.println("You don't have enough money.");
			return;
		} else {
			port.getShips().remove(ship);
			this.setMoney(this.getMoney() - port.getCheckOutFee());
			System.out.println("You paid "+port.getCheckOutFee()+" and checked the "+ship.getName()+" out of "+port.getName()+".");
		}
	}

	public void inquire(Spaceport port) {
		System.out.println("Here are the ships you have in this port:");
		for (Ship ship : port.getShips()) {
			if (ship.getOwner().equals(this)) {
				System.out.println("   " + ship.getName());
			}
		}
	}
	
	public void examine(Ship ship) {
		System.out.println(ship);
		if (ship.isStolen()) {
			System.out.println("Records indicate this ship was stolen.");
		}
		if (ship.HasContraband()) {
			System.out.println("This ship has illegal materials in its storage.");
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
