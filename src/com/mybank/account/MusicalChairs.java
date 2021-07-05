package com.mybank.account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MusicalChairs {

	public static class AcountBalanceComparator implements Comparator<AbstractAccount> {

		@Override
		public int compare(AbstractAccount account1, AbstractAccount account2) {
			// TODO Auto-generated method stub
			// compare returns a negative number if account 1 should be listed before
			// account 2
			// A positive number, .....

			if (account1.getBalance() > account2.getBalance()) {
				return -1;
			} else if (account1.getBalance() < account2.getBalance()) {
				return 1;
			} else {
				return 0;
			}
		}

	}

	public static void play() throws InsufficientFundsException {

		CheckingAccount one = new CheckingAccount("customer one", "customer one account", 100.0, "c1");

		SavingsAccount two = new SavingsAccount("saver two", "saver two's savings account", 100.0, "s2");

		CheckingAccount three = new CheckingAccount("customer three", "customer three's account", 100.0, "c3");

		SavingsAccount four = new SavingsAccount("saver four", "saver four's savings account", 100.0, "s4");

		CheckingAccount five = new CheckingAccount("customer five", "customer five's account", 100.0, "c5");

		List<AbstractAccount> allAccounts = Arrays.asList(one, two, three, four, five);

		for (int amount = 1; amount < 1000; amount++) {
			int i = amount % 5; // modulo (%) nifty little trick to keep a number between 0 and 4 in this case
			int j = (i + 1) % 5;
			AbstractAccount fromAccount = allAccounts.get(i);
			AbstractAccount toAccount = allAccounts.get(j);

			// transfer moniez!!!
			Double amountTransferred = fromAccount.transfer(toAccount, amount);

			// check if transfer worked, if not, break out of loop
			if (amountTransferred == null) {
				break;
			}
		}

		// print all balances at the end of the game
		// hint: System.out.println("Account one balance: " + one.getBalance());
		for (AbstractAccount account : allAccounts) {
			System.out.println(account.getAccountName() + " - balance : " + account.getBalance());
		}
	}

	public static void playWithCollections() {

		System.out.println("Inside new play method");

		// Generate 5 bank accounts, mix of checking and saving accounts
		// different balances to start with
		List<AbstractAccount> accountsList = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			// create new account with a balance
			String customer = "customer " + i;
			String accountName = "Account " + i;
			String accountNumber = String.valueOf(i);
			int balance = (i + 1) * 100;
			AbstractAccount thisAccount;
			if (i % 2 == 0) {
				// checking
				thisAccount = new CheckingAccount(customer, accountName, balance, accountNumber);
			} else {
				// savings
				thisAccount = new SavingsAccount(customer, accountName, balance, accountNumber);
			}
			// add that account to a collection (list)
			accountsList.add(thisAccount);
		}
		System.out.println(accountsList);

		// Keep transfering money until a transfer fails (aka runs out of money)

		for (int amount = 1; amount < 2000; amount++) {
			int i = amount % 5; // modulo (%) nifty little trick to keep a number between 0 and 4 in this case
			int j = (i + 1) % 5;
			AbstractAccount fromAccount = accountsList.get(i);
			AbstractAccount toAccount = accountsList.get(j);

			// transfer moniez!!!
			try {
				fromAccount.transfer(toAccount, amount);

			} catch (InsufficientFundsException e) {
				break;
			}
		}
		// print all balances at the end of the game
		// hint: System.out.println("Account one balance: " + one.getBalance());
		for (AbstractAccount account : accountsList) {
			System.out.println(account.getAccountName() + " - balance : " + account.getBalance());
		}

	}

	public static void playWithSet() {
		System.out.println("inside pws");
		// Generate 5 bank accounts, mix of checking and saving accounts
		// different balances to start with
		List<AbstractAccount> accountsList = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			// create new account with a balance
			String customer = "customer " + i;
			String accountName = "Account " + i;
			String accountNumber = String.valueOf(i);
			int balance = (i + 1) * 100;
			AbstractAccount thisAccount;
			if (i % 2 == 0) {
				// checking
				thisAccount = new CheckingAccount(customer, accountName, balance, accountNumber);
			} else {
				// savings
				thisAccount = new SavingsAccount(customer, accountName, balance, accountNumber);
			}
			// add that account to a collection (list)
			accountsList.add(thisAccount);
			// add again so we have doubles
			accountsList.add(thisAccount);
		}
		System.out.println(accountsList);

		// find the unique set inside
		Set<AbstractAccount> uniqueAccounts = new HashSet<>(accountsList);

		System.out.println("Unique accounts: " + uniqueAccounts);
	}

	public static void playWithMap() {
		System.out.println("inside pwm");
		// different balances to start with
		// this time chuck em in a map with their key as account number
		Map<String, AbstractAccount> accountsMap = new HashMap<>();

		for (int i = 0; i < 5; i++) {
			// create new account with a balance
			String customer = "customer " + i;
			String accountName = "Account " + i;
			String accountNumber = "#" + i;
			int balance = (i + 1) * 100;
			AbstractAccount thisAccount;
			if (i % 2 == 0) {
				// checking
				thisAccount = new CheckingAccount(customer, accountName, balance, accountNumber);
			} else {
				// savings
				thisAccount = new SavingsAccount(customer, accountName, balance, accountNumber);
			}
			// add that account to a collection (list)
			accountsMap.put(accountNumber, thisAccount);

		}
		System.out.println(accountsMap);

	}

	public static void playWithSorting() {
		System.out.println("vdnsvs");

		// Generate 5 bank accounts, mix of checking and saving accounts
		// different balances to start with
		List<AbstractAccount> accountsList = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			// create new account with a balance
			String customer = "customer " + i;
			String accountName = "Account " + i;
			String accountNumber = String.valueOf(i);
			int balance = (i + 1) * 100;
			AbstractAccount thisAccount;
			if (i % 2 == 0) {
				// checking
				thisAccount = new CheckingAccount(customer, accountName, balance, accountNumber);
			} else {
				// savings
				thisAccount = new SavingsAccount(customer, accountName, balance, accountNumber);
			}
			// add that account to a collection (list)
			accountsList.add(thisAccount);
		}
		System.out.println(accountsList);

		// sort list by balance

		accountsList.sort(new AcountBalanceComparator());
		System.out.println("Sorted by highest balance first" + accountsList);
		
		Set<AbstractAccount>sortedSet = new TreeSet<>(new AcountBalanceComparator());
		sortedSet.addAll(accountsList);
		System.out.println("Sorted with a tree set" + sortedSet);
	}
}
