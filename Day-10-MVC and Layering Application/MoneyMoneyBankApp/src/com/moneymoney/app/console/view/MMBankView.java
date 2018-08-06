package com.moneymoney.app.console.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.moneymoney.app.console.controller.MMBankAccountController;
import com.moneymoney.framework.account.pojo.BankAccount;
import com.moneymoney.framework.controller.BankController;

public class MMBankView {
	
	BufferedReader bufferedReader = new BufferedReader(
			new InputStreamReader(System.in));
	
	Map<String, Object> accountDetails = new HashMap<>();
	
	BankController bac;
	
	public MMBankView() {
		super();
	ApplicationContext context=new ClassPathXmlApplicationContext("context.xml");
		this.bac=(MMBankAccountController)context.getBean("controller");	
	}

	
	public void start() throws IOException {
		do {
			showMenu();
		}while(true);
		
	}

	private void showMenu() throws IOException {
		System.out.println("Make Choice : ");
		System.out.println("1. Add New Savings Account");
		System.out.println("2. Add New Current Account");
		System.out.println("3. Show All Accounts");
		System.out.println("4. Get Next Account Number");
		System.out.println("5. Search Account By Account Number");
		System.out.println("6. Exit");
		
		acceptChoice();
	}

	private void acceptChoice() throws IOException {
		
		int choice = Integer.parseInt(bufferedReader.readLine());
		switch (choice) {
		
		case 1:
			addNewSavingsAccount();
			bac.createNewSavingsAccount(accountDetails);
			break;
		case 2:addNewCurrentAccount();
			bac.createNewCurrentAccount(accountDetails);
			break;
		case 3:showAllAccounts(bac.getAllAccounts());
			break;
		case 4:	System.out.println(bac.getNextAccountNumber());
			break;
		case 5:System.out.println("Enter the Account Number");
				BankAccount account=bac.getAccountById(Integer.parseInt(bufferedReader.readLine()));
				System.out.println(account);
			break;
		default:System.exit(1);
			break;
		}
	}

	private void showAllAccounts(Collection<BankAccount> collection) {
		collection.stream().forEach(System.out::println);
		
	}

	private void addNewCurrentAccount() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Enter Account Balance: ");
		double accountBalance = Double.parseDouble(bufferedReader.readLine());
		accountDetails.put("accountBalance", accountBalance);
		
		System.out.println("Enter overdraft limit");
		accountDetails.put("overdraft", Double.parseDouble(bufferedReader.readLine()));
		
		acceptCustomerDetails();
		
	}

	private void addNewSavingsAccount() throws IOException {
		
//		System.out.println("Enter Account Holder Name: ");
//		String accountHolderName = bufferedReader.readLine();
//		accountDetails.put("accountHolderName", accountHolderName);
		System.out.println("Enter Account Balance: ");
		double accountBalance = Double.parseDouble(bufferedReader.readLine());
		accountDetails.put("accountBalance", accountBalance);
		System.out.println("Enter Salary?(n/y): ");
		String salary = bufferedReader.readLine();
		accountDetails.put("salary", salary.equalsIgnoreCase("n")?false:true);
		
		acceptCustomerDetails();
	
	}

	private void acceptCustomerDetails() throws NumberFormatException, IOException {
		
		System.out.println("Enter Contact Number: ");
		Long contact = Long.parseLong(bufferedReader.readLine());
		accountDetails.put("contact", contact);
		
		System.out.println("Enter Date of Birth(dd/mm/yyyy): ");
		String dobStr = bufferedReader.readLine();
		LocalDate dateOfBirth = getDate(dobStr);
		accountDetails.put("dateOfBirth", dateOfBirth);
		
		System.out.println("Enter Account Holder Name: ");
		String accountHolderName = bufferedReader.readLine();
		accountDetails.put("accountHolderName", accountHolderName);
		
		System.out.println("Enter Contact Number: ");
		accountDetails.put("contactNo", Long.parseLong(bufferedReader.readLine()));
		
		System.out.println("Enter Nationality: ");
		accountDetails.put("nationality", bufferedReader.readLine());
		
		System.out.println("Enter gender: ");
		accountDetails.put("gender", bufferedReader.readLine());


		
		acceptAddress();		
	}

	private void acceptAddress() throws IOException {
		//String houseNo, String street, String city, String state, int pinCode
		
		System.out.println("Enter houseno ");
		accountDetails.put("houseNo", bufferedReader.readLine());
		
		System.out.println("Enter street ");
		accountDetails.put("street", bufferedReader.readLine());
		
		System.out.println("Enter city ");
		accountDetails.put("city", bufferedReader.readLine());
		
		System.out.println("Enter state ");
		accountDetails.put("state", bufferedReader.readLine());
		
		System.out.println("Enter pin code ");
		accountDetails.put("pinCode", Integer.parseInt(bufferedReader.readLine()));
		}

	private LocalDate getDate(String dobStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dobStr, formatter);
		return date;
	}
	
}
