package com.revature.data;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;
import com.revature.models.Ship;

public class CustomerDAO {
	private static String filename = "customers.dat";
	private static List<Customer> customers;
	
	static {
		DataSerializer<Customer> ds = new DataSerializer<Customer>();
		customers = ds.readObjectsFromFile(filename);
		if(customers == null) {
			customers = new ArrayList<Customer>();
			customers.add(new Customer("Kyle", 1000));
			ds.writeObjectsToFile(customers, filename);
			System.out.println("added");
		}
	}
	public void addCustomer(Customer u) {
		customers.add(u);
	}
	
	public List<Customer> getCustomers(){
		return customers;
	}
	
	public Customer getCustomer(String name) {
		return customers.stream()
			.filter((u) -> u.getName().equals(name))
			.findFirst()
			.orElse(null);
	}
	
	public void addShip(Customer c, Ship s) {
		ArrayList<Ship> ships = c.getShips();
		ships.add(s);
		c.setShips(ships);
		customers.set(customers.indexOf(c), c);
	}
	
	public void removeShip(Customer c, Ship ship) {
		ArrayList<Ship> ships = c.getShips();
		ships.remove(ship);
		c.setShips(ships);
		customers.set(customers.indexOf(c), c);
	}
	
	public void writeToFile() {
		new DataSerializer<Customer>().writeObjectsToFile(customers, filename);
	}

	public Ship getShip(Customer c, String shipName) {
		return c.getShips().stream().filter(ship -> ship.getName().equals(shipName)).findFirst().orElse(null);
				
	}


}
