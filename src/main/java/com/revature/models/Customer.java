package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Serializable{

	private String name;
	private float money;
	private ArrayList<Ship> ships = new ArrayList<Ship>();
	private static final long serialVersionUID = 2622951313170302024L;
	
	public Customer() {};

	public Customer(String name, float money) {
		super();
		this.name = name;
		this.money = money;
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

	public ArrayList<Ship> getShips() {
		return ships;
	}

	public void setShips(ArrayList<Ship> ships) {
		this.ships = ships;
	}

}
