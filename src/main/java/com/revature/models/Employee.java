package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee extends Customer implements Serializable{
	
	public Employee() {}
	
	public Employee(String name, float money) {
		super(name, money);
	}
}
