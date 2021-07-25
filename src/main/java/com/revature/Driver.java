package com.revature;

import com.revature.controllers.CustomerController;

import io.javalin.Javalin;

public class Driver {

	public static void main(String[] args) {
		
		CustomerController cc = new CustomerController();
		Javalin app = Javalin.create().start(8080);
		
		app.get("/", (ctx) -> ctx.html("Hello World"));
		app.post("/customers", cc::login);
		app.post("/employees", cc::loginEmployee);
		
		app.put("/customers/:name", cc::register);
		app.put("/employees/:name", cc::registerEmployee);

		app.delete("/customers", cc::logout);
		app.get("/customers/:name/status", cc::viewStatus);
		
		app.put("/customers/:name/ship", cc::registerShip);
		app.delete("/customers/:customer-name/:ship-name", cc::destroyShip);

		app.post("/ships/dock/:name", cc::checkShipIn);
		app.post("/ships/undock/:name", cc::checkShipOut);
		
		app.get("/ships", cc::inquire);
		app.get("/ships/examine/:customer-name/:ship-name", cc::examine);
	}

}
