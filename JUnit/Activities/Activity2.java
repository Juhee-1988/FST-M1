package com.example.fst_m1_junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Activity2 {
	
	@Test
	void notEnoughFunds() {
		
		BankAccount account=new BankAccount(9);		
		assertThrows(NotEnoughFundsException.class,()->account.withdraw(10),"Balance amount must be greater than amount of withdrawal");
	}
	
	@Test
	void enoughFunds() {
	  
	    BankAccount account = new BankAccount(100);
	    assertDoesNotThrow(() -> account.withdraw(100));
	}

}
