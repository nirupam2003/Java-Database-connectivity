package com.ilp04.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.ilp04.dao.CustomerDAO;
import com.ilp04.entity.Customer;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public ArrayList<Customer> getAllCustomers() {
		ArrayList<Customer> customerList =new ArrayList<Customer>();
		CustomerDAO customerDAO=new CustomerDAO();
		Connection connection=customerDAO.getConnection();
		customerList=customerDAO.getAllCustomers(connection);
		
		return customerList;
	}

	@Override
	public void insertIntoCustomer(Customer customer) {
		CustomerDAO customerDAO=new CustomerDAO();
		Connection connection=customerDAO.getConnection();
		customerDAO.insertIntoCustomer(connection,customer);
	}

	@Override
	public void updateAadhar(long aadharNo, int customerCode) {
		CustomerDAO customerDAO=new CustomerDAO();
		Connection connection=customerDAO.getConnection();
		customerDAO.updateAadhar(connection, aadharNo, customerCode);
	}

	@Override
	public void updatePhone(long phNumber, int customerCode) {
		CustomerDAO customerDAO=new CustomerDAO();
		Connection connection=customerDAO.getConnection();
		customerDAO.updatePhone(connection,phNumber,customerCode);
		
	}

	@Override
	public void updateAddress(String address, int customerCode) {
		CustomerDAO customerDAO=new CustomerDAO();
		Connection connection=customerDAO.getConnection();
		customerDAO.updateAddress(connection,address,customerCode);
		
	}

	@Override
	public void updateLastName(String lastName, int customerCode) {
		CustomerDAO customerDAO=new CustomerDAO();
		Connection connection=customerDAO.getConnection();
		customerDAO.updateLastName(connection,lastName,customerCode);
		
	}

	@Override
	public void updateFirstName(String firstName, int customerCode) {
		CustomerDAO customerDAO=new CustomerDAO();
		Connection connection=customerDAO.getConnection();
		customerDAO.updateFirstName(connection,firstName,customerCode);
		
	}

}
