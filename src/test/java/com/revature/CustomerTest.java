package com.revature;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.revature.models.Customer;
import com.revature.models.Ship;

class CustomerTest {

	@Test
	void testGetShips() {
		Customer c = new Customer();
		ArrayList<Ship> a = new ArrayList<Ship>();
		Assert.assertEquals(a,c.getShips());
	}

}
