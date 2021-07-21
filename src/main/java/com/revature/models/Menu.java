package com.revature.models;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

import com.revature.data.CustomerDAO;

public class Menu {
	
	private Customer user;
	private Scanner sc = new Scanner(System.in);
	private CustomerDAO ud = new CustomerDAO();

	
	public void loginMenu() {
		System.out.println("SPACEPORT REGISTRATION CONSOLE: \nEnter your name: (enter a blank space to quit)");
		String input = sc.nextLine();
		if (input == "") {
			System.out.println("Goodbye");
			return;
			}
		if(ud.getCustomer(input)==null) {
			System.out.println("Creating new user...");			
			user = new Customer(input, 0);
			ud.addCustomer(user);
		} else {
			System.out.println("Logging in...");			
			user = ud.getCustomer(input);
		}
		mainMenu();
		ud.writeToFile();
		sc.close();
	}
	
	private void mainMenu() {
		mainloop: while (true) {
			System.out.println("Welcome, "+user.getName()+". What would you like to do?");			
			System.out.println("1: View your status\n2: Register a ship\n3: Check in a ship\n4: Check out a ship"
					+ "/n5: ");			
			switch(sc.nextLine().trim()) {
			case "1": 
				break mainloop;
			case "2":
				break mainloop;
			case "3":
				break mainloop;
			default:
				break mainloop;
			}
		}
	}
	
	
}
