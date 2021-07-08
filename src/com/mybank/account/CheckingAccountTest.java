package com.mybank.account;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckingAccountTest {
	//class under test
	CheckingAccount account;
	
	@BeforeEach
	void setup() {
		this.account = new CheckingAccount (
			"Customer 1",
			"Test account",
			0,
			"Test account number");
			
		
	}
	
	@Test
	void deposit__amount_greater_than_zero__works() {

		
		//Try with good amount (greater than zero)
		double amount = 42.0;
		
		//Do the actual test
		account.deposit(amount);
		
		//get the actual balance
		double balance = account.getBalance();
		
		//check it did work
		assertEquals(amount, balance);
				
	}
	
	@Test 
	void deposit__amount_less_than_zero__throws() {
		//bad amount
		double amount = -1;
		
		//do it
	
		assertThrows(IllegalArgumentException.class, ( )->{
			account.deposit(amount);
		} );

	}
	@Test 
	void deposit__amount_equal_to_zero__throws() {
		//another bad amount
		double amount = 0.0;
		
		//do it
		assertThrows(IllegalArgumentException.class, ( )->{
			account.deposit(amount);
		} );

	}
		//bad amount

}
