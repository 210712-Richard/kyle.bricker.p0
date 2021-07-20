package com.revature.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Spaceport {
	
	private String name;
	private Set<Ship> ships;
	private ArrayList<Employee> employees = new ArrayList<Employee>(0);
	private float money;
	private float checkInFee;
	private float checkOutFee;
	
	
	
	public Spaceport(String name, float money, float checkInFee, float checkOutFee) {
		super();
		this.name = name;
		this.money = money;
		this.checkInFee = checkInFee;
		this.checkOutFee = checkOutFee;
	}

	public String toString() {
		String s = "";
		s+= this.name+", run by ";
		if (employees == null) {
			s+="nobody.";
		} else if(employees.size()>1) {
			for (int i=0;i<employees.size()-1;i++){
				s += employees.get(i).getName()+", ";
			}
			s+="and "+employees.get(employees.size()-1).getName()+".";
		} else {
			s+=employees.get(0).getName()+".";
		}
		return s;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
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

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

}
