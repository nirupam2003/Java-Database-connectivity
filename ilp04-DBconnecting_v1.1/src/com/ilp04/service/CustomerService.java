package com.ilp04.service;

import java.util.ArrayList;

import com.ilp04.entity.Customer;

public interface CustomerService {

	public ArrayList<Customer> getAllCustomers();
	public void insertIntoCustomer(Customer customer);
	public void updateAadhar(long aadharNo, int customerCode);
	public void updatePhone(long phNumber, int customerCode);
	public void updateAddress(String address, int customerCode);
	public void updateLastName(String lastName, int customerCode);
	public void updateFirstName(String firstName, int customerCode);
}
