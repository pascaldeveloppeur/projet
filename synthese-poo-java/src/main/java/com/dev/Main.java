package com.dev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.dev.model.BankAccount;

public class Main {

	public static void main(String[] args) {
		
//		BankAccount[] accounts = new BankAccount[4];
//		accounts[0] = new BankAccount(3200,"hap");
//		accounts[1] = new BankAccount(4100,"gthd");
//		accounts[2] = new BankAccount(1000,"nkjh");
//		accounts[3] = new BankAccount(5820,"opojc");
		
		List<BankAccount> accountList= new ArrayList<BankAccount>();
		accountList.add(new BankAccount(5800, "TES"));
		accountList.add(new BankAccount(1000, "CALL"));
		accountList.add(new BankAccount(2100, "PRO"));
		accountList.add(new BankAccount(8700, "MENT"));
		accountList.add(new BankAccount(5000, "RESS"));
		
		Map<String, BankAccount> listAccount= new HashMap<String, BankAccount>();
		listAccount.put("c1", new BankAccount(10200, "tyu"));
		listAccount.put("c2", new BankAccount(8500, "mon"));
		listAccount.put("c3", new BankAccount(0, "tesb"));
		
//		BankAccount cout = listAccount.get("c2");
//		System.out.println(cout);
		
//		for (String key : listAccount.keySet()) {
//			System.out.println(listAccount.get(key));
//		}
		
		for (BankAccount bankAccount : listAccount.values()) {
			System.out.println(bankAccount);
		}
		
//		for (BankAccount bankAccount : accountList) {
//			System.out.println(bankAccount);
//		}

	}

}
