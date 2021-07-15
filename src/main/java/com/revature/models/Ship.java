package com.revature.models;

public class Ship {

	private String name;
	private Customer owner;
	private Spaceport garage;
	private boolean stolen;
	private boolean hasContraband;
	
	public void destroy() {
		owner.getShips().remove(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public boolean isStolen() {
		return stolen;
	}

	public void setStolen(boolean stolen) {
		this.stolen = stolen;
	}

	public boolean isHasContraband() {
		return hasContraband;
	}

	public void setHasContraband(boolean hasContraband) {
		this.hasContraband = hasContraband;
	}

	public Spaceport getGarage() {
		return garage;
	}

	public void setDocked(Spaceport garage) {
		this.garage = garage;
	}

}
