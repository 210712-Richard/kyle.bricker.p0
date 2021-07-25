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
		if (ship.isDocked()) {
			System.out.println("That ship is already checked in.");
			return;
		} else if (c.getMoney() < 800) {
			System.out.println("You don't have enough money.");
			return;
		} else {
			System.out.println("You paid 800 and checked the "+ship.getName()+" into the spaceport.");
			c.setMoney(c.getMoney() - 800);
		}
	}

	public void checkShipOut(Customer c, Ship ship) {
		if (!ship.isDocked()) {
			System.out.println("That ship is not docked.");
			return;
		} else if (c.getMoney() < 200) {
			System.out.println("You don't have enough money.");
			return;
		} else {
			c.setMoney(c.getMoney() - 200);
			System.out.println("You paid 200 and checked the "+ship.getName()+" out of the spaceport.");
		}
	}

	public void inquire(Customer c) {
		System.out.println("Here are the ships you have in this port:");
		for (Ship ship : c.getShips()) {
			if (ship.isDocked()) {
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
	


}
