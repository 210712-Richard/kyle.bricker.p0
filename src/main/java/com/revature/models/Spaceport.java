package com.revature.models;

import java.util.List;
import java.util.Set;

public class Spaceport {
	
	private Set<Ship> ships;
	private float money;
	private float checkInFee;
	private float checkOutFee;
	public Set<Ship> getShips() {
		return ships;
	}
	public void setShips(Set<Ship> ships) {
		this.ships = ships;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public float getCheckInFee() {
		return checkInFee;
	}
	public void setCheckInFee(float checkInFee) {
		this.checkInFee = checkInFee;
	}
	public float getCheckOutFee() {
		return checkOutFee;
	}
	public void setCheckOutFee(float checkOutFee) {
		this.checkOutFee = checkOutFee;
	}

}
