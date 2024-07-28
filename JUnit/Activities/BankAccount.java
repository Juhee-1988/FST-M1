package com.example.fst_m1_junit;

public class BankAccount {
	
	private Integer balance;
	
	public BankAccount(Integer initialbalance) {
		this.balance=initialbalance;
		}
	
	public Integer withdraw(Integer amount) {
		if(balance<amount) {
			throw new NotEnoughFundsException(amount, balance);
		}
		balance-=amount;
		return balance;
	}

}
