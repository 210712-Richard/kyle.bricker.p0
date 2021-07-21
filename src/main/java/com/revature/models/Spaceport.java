package com.revature.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Spaceport {
	
	private String name;
	private ArrayList<Ship> ships =  new ArrayList<Ship>(0);
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
		if (ships.size()==0) {
			s+=" No ships docked here.";
		} else if(ships.size()>1) {
			for (int i=0;i<ships.size()-1;i++){
				s += ships.get(i).getName()+", ";
			}
			s+="and "+ships.get(ships.size()-1).getName()+" are docked here.";
		} else {
			s+=" "+ships.get(0).getName()+" is docked here.";
		}
		return s;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Ship> getShips() {
		return ships;
	}
	public void setShips(ArrayList<Ship> ships) {
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
