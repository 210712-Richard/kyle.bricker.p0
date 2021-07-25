package com.revature.controllers;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Ship;
import com.revature.services.CustomerService;

import io.javalin.http.Context;

public class CustomerController {
	
	private CustomerService cs = new CustomerService();
	
	public void login(Context ctx) {
		Customer c = ctx.bodyAsClass(Customer.class);
		c = cs.login(c.getName());
		if(c != null) {
			ctx.sessionAttribute("loggedCustomer", c);
			ctx.json(c);
			return;
		}
		ctx.status(401);
	}
	
	public void loginEmployee(Context ctx) {
		Employee e = ctx.bodyAsClass(Employee.class);
		e = cs.loginEmployee(e.getName());
		if(e != null) {
			ctx.sessionAttribute("loggedCustomer", e);
			ctx.json(e);
			return;
		}
		ctx.status(401);
	}
	
	public void register(Context ctx) {
		Customer c = ctx.bodyAsClass(Customer.class);

		if(cs.checkAvailability(c.getName())) {
			Customer newCustomer = cs.register(c.getName(), c.getMoney());
			ctx.status(201);
			ctx.json(newCustomer);
		} else {
			ctx.status(409);
			ctx.html("Username already taken.");
		}
		
	}
	
	public void registerEmployee(Context ctx) {
		Employee e = ctx.bodyAsClass(Employee.class);

		if(cs.checkAvailability(e.getName())) {
			Employee newEmployee = cs.registerEmployee(e.getName(), e.getMoney());
			ctx.status(201);
			ctx.json(newEmployee);
		} else {
			ctx.status(409);
			ctx.html("Username already taken.");
		}
		
	}
	
	public void logout(Context ctx) {
		ctx.req.getSession().invalidate();
		ctx.status(204);
	}
	
	public void viewStatus(Context ctx) {
		String name = ctx.pathParam("name");
		Customer loggedCustomer = (Customer) ctx.sessionAttribute("loggedCustomer");
		if(loggedCustomer == null || !loggedCustomer.getName().equals(name)) {
			ctx.status(403);
			return;
		}
		ctx.json(loggedCustomer.toString());
	}
	
	public void registerShip(Context ctx) {
		String name = ctx.pathParam("name");
		Customer loggedCustomer = (Customer) ctx.sessionAttribute("loggedCustomer");
		if(loggedCustomer == null || !loggedCustomer.getName().equals(name)) {
			ctx.status(403);
			return;
		}
		Ship newShip = ctx.bodyAsClass(Ship.class);
		cs.addShip(loggedCustomer, newShip);
		ctx.json(loggedCustomer);
	}
	
	public void destroyShip(Context ctx) {
		String customerName = ctx.pathParam("customer-name");
		String shipName = ctx.pathParam("ship-name");
		Customer loggedCustomer = (Customer) ctx.sessionAttribute("loggedCustomer");
		Customer victim = cs.login(customerName);
		if (loggedCustomer.getClass().getSimpleName().equals("Employee") && cs.getShip(victim, shipName).isDocked()){
			cs.destroyShip(victim, cs.getShip(victim, shipName));
			ctx.json(victim);
			return;
		}
		else {			
			ctx.status(403);
			return;
		}
	}
	
	public void checkShipIn(Context ctx) {
		String shipName = ctx.pathParam("name");
		Customer loggedCustomer = (Customer) ctx.sessionAttribute("loggedCustomer");
		
		Ship ship = cs.getShip(loggedCustomer, shipName);
		if (ship.isDocked()) {
			ctx.html("That ship is already docked.");
			ctx.status(401);
			return;
		} else if (loggedCustomer.getMoney() < 800) {
			ctx.html("You don't have enough money.");
			ctx.status(401);
			return;
		} else {
			cs.checkShipIn(loggedCustomer, ship);
			ctx.json(ship);
		}
	}
	
	public void checkShipOut(Context ctx) {
		String shipName = ctx.pathParam("name");
		Customer loggedCustomer = (Customer) ctx.sessionAttribute("loggedCustomer");
		
		Ship ship = cs.getShip(loggedCustomer, shipName);
		if (!ship.isDocked()) {
			ctx.html("That ship is not currently docked.");
			ctx.status(401);
			return;
		} else if (loggedCustomer.getMoney() < 200) {
			ctx.html("You don't have enough money.");
			ctx.status(401);
			return;
		} else {
			cs.checkShipOut(loggedCustomer, ship);
			ctx.json(ship);
		}
	}
	
	public void inquire(Context ctx) {
		Customer loggedCustomer = (Customer) ctx.sessionAttribute("loggedCustomer");
		ctx.html(cs.inquire(loggedCustomer));
	}
	
	public void examine(Context ctx) {
		Customer loggedCustomer = (Customer) ctx.sessionAttribute("loggedCustomer");
		String shipName = ctx.pathParam("ship-name");
		String customerName = ctx.pathParam("customer-name");
		Customer victim = cs.login(customerName);
		if (!loggedCustomer.getClass().getSimpleName().equals("Employee")) {
			ctx.status(403);
			ctx.html("You are not authorized to examine docked ships.");
		} else if (!cs.getShip(victim, shipName).isDocked()) {
			ctx.status(403);
			ctx.html("That ship is not docked, you may not examine it.");
		} else {
			ctx.html(cs.examine(cs.getShip(victim, shipName)));
		}
	}
}
