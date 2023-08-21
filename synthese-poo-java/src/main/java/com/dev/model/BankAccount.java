package com.dev.model;

import java.util.UUID;

public class BankAccount {

	private String accountId;
	private double balance;
	private String currency;
	private AccountStatus status;
	
	public BankAccount() {
		super();
		this.accountId= UUID.randomUUID().toString();
		this.status= AccountStatus.CREATE;
	}
	
	public BankAccount(double initialBalance, String currency) {
		this();
		this.balance = initialBalance;
		this.currency = currency;
	
	}
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public AccountStatus getStatus() {
		return status;
	}
	public void setStatus(AccountStatus status) {
		this.status = status;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BankAccount [accountId=" + accountId + ", balance=" + balance + ", currency=" + currency + ", status="
				+ status + "]";
	}
}
