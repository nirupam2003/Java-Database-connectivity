package com.ilp04.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ilp04.entity.Customer;

public class CustomerDAO {
	
	public Connection getConnection()
	{
		String connectionURL="jdbc:mysql://localhost:3306/bankdb?";//bankdb is my database name
		String userName="root";
		String password="rootroot";
		Connection connection=null;
		
		try {
			connection=DriverManager.getConnection(connectionURL, userName, password);
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return connection;
	}
	public Connection closeConnection(Connection connection)
	{
		try {
			connection.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return connection;
		
	}
	
	//get all customer details
	
	public ArrayList<Customer> getAllCustomers(Connection connection){
		ArrayList<Customer> customerList=new ArrayList<Customer>();
		Statement statement;
		ResultSet resultSet;
		
		try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery("select * from customer");
			while(resultSet.next()) {
				int customerCode=resultSet.getInt(1);
				String customerFirstname=resultSet.getNString(2);
				String customerLastname=resultSet.getString(3);
				String address=resultSet.getString(4);
				long phNumber=resultSet.getLong(5);
				long aadharNo=resultSet.getLong(6);
				
				Customer customer=new Customer(customerCode,customerFirstname,customerLastname,address,phNumber,aadharNo);
				customerList.add(customer);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return customerList;
	}
	public void insertIntoCustomer(Connection connection, Customer customer) {
		Customer customerItem=customer;
		try {
//			String sqlQuery="insert into customer(customer_firstname,customer_lastname,address,phonenumber,aadhar_no) values(\""+customerItem.getCustomerFirstname()+","+customerItem.getCustomerLastname()+","+customerItem.getAddress()+","+customerItem.getPhNumber()+","+customerItem.getAadharNo()+");";
			PreparedStatement statement=connection.prepareStatement("insert into customer(customer_firstname,customer_lastname,address,phonenumber,aadhar_no) values(?,?,?,?,?)");
			statement.setString(1,customerItem.getCustomerFirstname());
			statement.setString(2,customerItem.getCustomerLastname());
			statement.setString(3,customerItem.getAddress());
			statement.setLong(4,customerItem.getPhNumber());
			statement.setLong(5,customerItem.getAadharNo());
			statement.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void updateAadhar(Connection connection,long aadharNo, int customerCode)
	{
		try {
			PreparedStatement sqlQuery=connection.prepareStatement("update customer set aadhar_no=? where customercode=?");
			sqlQuery.setLong(1,aadharNo);
			sqlQuery.setLong(2,customerCode);
			sqlQuery.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	public void updatePhone(Connection connection, long phNumber, int customerCode) {
		try {
			PreparedStatement sqlQuery=connection.prepareStatement("update customer set phonenumber=? where customercode=?");
			sqlQuery.setLong(1,phNumber);
			sqlQuery.setLong(2,customerCode);
			sqlQuery.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	public void updateFirstName(Connection connection, String firstName, int customerCode) {
		try {
			PreparedStatement sqlQuery=connection.prepareStatement("update customer set customer_firstname=? where customercode=?");
			sqlQuery.setString(1,firstName);
			sqlQuery.setLong(2,customerCode);
			sqlQuery.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	public void updateLastName(Connection connection, String lastName, int customerCode) {
		try {
			PreparedStatement sqlQuery=connection.prepareStatement("update customer set customer_lastname=? where customercode=?");
			sqlQuery.setString(1,lastName);
			sqlQuery.setLong(2,customerCode);
			sqlQuery.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	public void updateAddress(Connection connection, String address, int customerCode) {
		try {
			PreparedStatement sqlQuery=connection.prepareStatement("update customer set address=? where customercode=?");
			sqlQuery.setNString(1,address);
			sqlQuery.setLong(2,customerCode);
			sqlQuery.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
}
