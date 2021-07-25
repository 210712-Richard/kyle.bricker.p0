package com.revature.models;

import java.io.Serializable;

public class Ship implements Serializable{

	private String name;
	private String owner;
	private boolean docked;
	private boolean stolen;
	private boolean hasContraband;
	private static final long serialVersionUID = 2622951313170302025L;
	
	public Ship() {};
	
	public Ship(String owner, String name) {
		this.owner = owner;
		this.name=name;
	}
	public Ship(String owner, String name, boolean stolen, boolean hasContraband) {
		this(owner,name);
		this.stolen=stolen;
		this.hasContraband=hasContraband;
	}

	public String toString() {
		String s = "";
		s+= "The "+this.name+".";
		if (!this.docked) {
			s+=" Not docked.";
		} else {
			s+=" Currently docked.";
		}
		return s;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
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
	
	public boolean isDocked() {
		return docked;
	}

	public void setDocked(boolean docked) {
		this.docked = docked;
	}

}
