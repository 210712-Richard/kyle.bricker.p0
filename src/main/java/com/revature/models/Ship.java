package com.revature.models;

public class Ship {

	private String name;
	private Customer owner;
	private Spaceport garage;
	private boolean stolen;
	private boolean hasContraband;
	
	public Ship(Customer owner, String name) {
		this.owner = owner;
		this.owner.getShips().add(this);
		this.name=name;
	}
	public Ship(Customer owner, String name, boolean stolen, boolean hasContraband) {
		this(owner,name);
		this.stolen=stolen;
		this.hasContraband=hasContraband;
	}
	
	public Ship(String name, Customer owner, boolean stolen, boolean hasContraband) {
		this(owner,name);
		this.stolen = stolen;
		this.hasContraband = hasContraband;
	}
	public void destroy() {
		owner.getShips().remove(this);
		this.getGarage().getShips().remove(this);
	}

	public String toString() {
		String s = "";
		s+= "The "+this.name+", property of "+this.owner.getName();
		if (this.garage == null) {
			s+=". Not docked.";
		} else {
			s+=". Currently docked at "+this.garage.getName();
		}
		return s;
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

	public boolean HasContraband() {
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
