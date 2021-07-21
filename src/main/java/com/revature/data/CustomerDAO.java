package com.revature.data;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Customer;

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
	
	
	public void writeToFile() {
		new DataSerializer<Customer>().writeObjectsToFile(customers, filename);
	}
}
