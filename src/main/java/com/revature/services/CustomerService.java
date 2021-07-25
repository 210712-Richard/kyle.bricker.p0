package com.revature.services;

import com.revature.data.CustomerDAO;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Ship;

public class CustomerService {
	public CustomerDAO cd = new CustomerDAO();
	
	public Customer login(String name) {
		Customer c = cd.getCustomer(name);
		return c;
	}
	
	public Employee loginEmployee (String name) {
		Employee e = (Employee) cd.getCustomer(name);
		return e;
	}
	
	public Customer register(String name, float money) {
		Customer c = new Customer(name,money);
		cd.addCustomer(c);
		cd.writeToFile();
		return c;
	}
	
	public Employee registerEmployee(String name, float money) {
		Employee e = new Employee(name,money);
		cd.addCustomer(e);
		cd.writeToFile();
		return e;
	}
	
	public boolean checkAvailability(String newName) {
		return cd.getCustomers()
				.stream()
				.noneMatch((c)->c.getName().equals(newName));
	}
	
	public void addShip(Customer c, Ship ship) {
		cd.addShip(c, ship);
		cd.writeToFile();
	}
	
	
	public void destroyShip(Customer c, Ship ship) {
		cd.removeShip(c,ship);
		cd.writeToFile();
	}
	
	public Ship getShip(Customer c, String name) {
		return cd.getShip(c,name);
	}
	
	public void checkShipIn(Customer c, Ship ship) {
		c.setMoney(c.getMoney() - 800);
		ship.setDocked(true);
		cd.writeToFile();
	}

	public void checkShipOut(Customer c, Ship ship) {
		c.setMoney(c.getMoney() - 200);
		ship.setDocked(false);
		cd.writeToFile();
	}

	public String inquire(Customer c) {
		String s = "";
		s+="Here are the ships you have in this port:\n";
		for (Ship ship : c.getShips()) {
			if (ship.isDocked()) {
				s+="   " + ship.getName()+"\n";
			}
		}
		return s;
	}
	
	public String examine(Ship ship) {
		String s = ship.toString()+"\n";
		if (ship.isStolen()) {
			s+="Records indicate this ship was stolen.\n";
		}
		if (ship.HasContraband()) {
			s+="This ship has illegal materials in its storage.\n";
		}
		return s;
	}
	


}
