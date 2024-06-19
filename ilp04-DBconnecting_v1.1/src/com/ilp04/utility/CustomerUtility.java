package com.ilp04.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp04.entity.Customer;
import com.ilp04.service.CustomerService;
import com.ilp04.service.CustomerServiceImpl;

public class CustomerUtility {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		char goToMain;
		do {
			System.out.println("what to perform? 1.insert 2.getall 3. update");
			int mainChoice=sc.nextInt();
			switch(mainChoice) {
				case 1:
					insertIntoCustomers();
					break;
				case 2:
					getAllCustomers();
					break;
				case 3:
					System.out.println("customer code:");
					int customerCode=sc.nextInt();
					System.out.println("what to update: 1.firstname 2.lastname 3.address 4.phone no 5. aadhar no");
					int updateChoice=sc.nextInt();
					sc.nextLine();
					switch(updateChoice) {
						
						case 1:
							System.out.println("enter firstname:");
							String firstName=sc.nextLine();
							updateFirstName(firstName,customerCode);
							break;
						case 2:
							System.out.println("enter lastname:");
							String LastName=sc.nextLine();
							updateLastName(LastName,customerCode);
							break;
						case 3:
							System.out.println("enter address:");
							String address=sc.nextLine();
							updateAddress(address,customerCode);
							break;
						case 4:
							System.out.println("enter phone number:");
							long phNumber=sc.nextLong();
							updatePhone(phNumber,customerCode);
							break;
						case 5:
							System.out.println("enter aadhar:");
							long aadharNo=sc.nextLong();
							updateAadhar(aadharNo,customerCode);
							break;
						default :System.out.println("not valid");
						
					}
					break;
					default: System.out.println("not valid option");
					
					
					
					
			}
			
			System.out.println("go to main menu Yes/No");
			goToMain=sc.next().charAt(0);
		}while(goToMain=='y');
	
		

	}
	
	private static void updateAadhar(long aadharNo, int customerCode) {
		CustomerService customerService=new CustomerServiceImpl();
		customerService.updateAadhar(aadharNo, customerCode);
		
	}

	private static void updatePhone(long phNumber, int customerCode) {
		CustomerService customerService=new CustomerServiceImpl();
		customerService.updatePhone(phNumber, customerCode);
		
	}

	private static void updateAddress(String address, int customerCode) {
		CustomerService customerService=new CustomerServiceImpl();
		customerService.updateAddress(address, customerCode);
	}

	private static void updateLastName(String lastName, int customerCode) {
		
		CustomerService customerService=new CustomerServiceImpl();
		customerService.updateLastName(lastName, customerCode);
	}

	private static void updateFirstName(String firstName, int customerCode) {
		CustomerService customerService=new CustomerServiceImpl();
		customerService.updateFirstName(firstName, customerCode);
	}



	private static void getAllCustomers() {
		CustomerService customerService=new CustomerServiceImpl();
		ArrayList<Customer> customerList=customerService.getAllCustomers();
		System.out.println("customer code"+"	"+"First name"+"	"+"last name"+"		"+"Address"+"		"+"phone no"+"		"+"aadharno");
		
		for(Customer customerItem:customerList) {
			System.out.println(customerItem.getCustomerCode()+"		"+customerItem.getCustomerFirstname()+"		"+customerItem.getCustomerLastname()+"		"+customerItem.getAddress()+"		"+customerItem.getPhNumber()+"		"+customerItem.getAadharNo());
		}
		
	}
	private static void insertIntoCustomers() {
		CustomerService customerService=new CustomerServiceImpl();
		System.out.println("put values into customer");
		Scanner sc=new Scanner(System.in);
		System.out.println("customer name first:");
		String customerFirstname=sc.nextLine();
		System.out.println("customer name last:");
		String customerLastname=sc.nextLine();
		System.out.println("customer address:");
		String address=sc.nextLine();
		System.out.println("customer phone number:");
		long phNumber=sc.nextLong();
		System.out.println("customer aadhar:");
		long aadharNo=sc.nextLong();
		Customer customerItem=new Customer(customerFirstname, customerLastname, address, phNumber, aadharNo);
		customerService.insertIntoCustomer(customerItem);
		
		
	}

}
