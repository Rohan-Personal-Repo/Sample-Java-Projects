package com.easysystems.jpa_hibernate_eg;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.easysystems.pojos.Customer;

public class TestSystem {
	
	// Create an EntityManagerFactory when you start the application
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "JPA-Hibernate-Eg" );

	public static void main(String[] args) {
		
		// Add and get all customers 
		addCustomers( 1, "Rohan", "Deshpande" );
		addCustomers( 2, "Aniket", "Atram" );
		addCustomers( 3, "Shrikant", "Dharmadhikari" );
		addCustomers( 4, "Akhilesh", "Dhage" );
		addCustomers( 5, "Rishikesh", "Deshmukh" );
		addCustomers( 6, "Nilesh", "Ghadshi" );
		
		System.out.println( "List of All Added Customers : " );
		getAllCustomers();
		
		// update firstName
		System.out.println( "Updated FirstName : " );
		updateFirstName( 5, "Rishi" );
		getCustomer( 5 );
		
		// update lastName
		System.out.println( "Updated LastName : " );
		updateLastName( 4, "Dhages" );
		getCustomer( 4 );
		
		// delete Customer
		System.out.println( "Delete Customer: " );
		deleteCustomer( 6 );
		getAllCustomers();
		
		// delete Customer
		System.out.println( "Delete Customer: " );
		deleteCustomer( 16 );
		getAllCustomers();
				
				
		entityManagerFactory.close();
		
	}
	
	// The EntityManager class allows operations such as create, read, update, delete
	
	public static void addCustomers( int id, String fName, String lName ) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
        // Used to issue transactions on the EntityManager
		EntityTransaction entityTransaction = null;
		
		try {
            // Get transaction and start
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			
            // Create and set values for new customer
			Customer customer = new Customer();
			customer.setId( id );
			customer.setFirstName( fName );
			customer.setLastName( lName );
			
            // Save the customer object
			entityManager.persist( customer );
			entityTransaction.commit();

		}catch (Exception e) {
            // If there is an exception rollback changes
			if( entityTransaction!= null )
				entityTransaction.rollback();
			
			e.printStackTrace();
		} finally {
            // Close EntityManager
			entityManager.close();
		}
		
	}
	
	public static void getCustomer( int id ) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// the lowercase c refers to the object
    	// :custID is a parameterized query thats value is set below
		String query = "SELECT c FROM Customer c WHERE c.id = :custID";
		
    	// Issue the query and get a matching Customer
		TypedQuery<Customer> typedQuery = entityManager.createQuery( query, Customer.class );
		typedQuery.setParameter( "custID", id );
		
		Customer customer = null;
		
		try {
    		// Get matching customer object and output
			customer = typedQuery.getSingleResult();
			System.out.println( customer.toString() );
		} 
		catch ( NoResultException nre) {
			nre.printStackTrace();
		}
		finally {
			entityManager.close();
		}
				
	}
	
	public static void getAllCustomers() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String query = "SELECT c FROM Customer c";
		TypedQuery<Customer> typedQuery = entityManager.createQuery( query, Customer.class );
		List<Customer> custList = null;
		
		try {
			custList = typedQuery.getResultList();
			
			if( custList != null )
				custList.forEach( cust -> System.out.println( cust.toString() ) );
			else 
				System.out.println( "No Customers in the table" );
		} 
		catch ( NoResultException nre) {
			nre.printStackTrace();
		}
		finally {
			entityManager.close();
		}
	}
	
	public static void updateFirstName( int id, String fName ) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction = null;
		Customer cust = null;
		try {
            // Get transaction and start
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

            // Find customer and make changes
			cust = entityManager.find( Customer.class, id );
			
			if( cust != null )
			{
				cust.setFirstName( fName );
				
				// Save the customer object
				entityManager.persist( cust );
				entityTransaction.commit();
			}
			else 
				System.out.println( "updateFirstName - Customer with ID : " + id + " was not found." );

		}catch (Exception e) {
            // If there is an exception rollback changes
			if( entityTransaction!= null )
				entityTransaction.rollback();
			
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		
	}
	
	public static void updateLastName( int id, String lName ) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction = null;
		Customer cust = null;
		try {
			
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

			cust = entityManager.find( Customer.class, id );
			
			if( cust != null )
			{
				cust.setLastName( lName );
				entityManager.persist( cust );
				entityTransaction.commit();
			}
			else 
				System.out.println( "updateLastName - Customer with ID : " + id + " was not found." );

		}catch (Exception e) {
			
			if( entityTransaction!= null )
				entityTransaction.rollback();
			
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		
	}
	
	public static void deleteCustomer( int id ) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction = null;
		Customer cust = null;
		
		try {
			
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

			// find the customer with specified ID
			cust = entityManager.find( Customer.class, id );
			
			if( cust != null )
			{
				// Remove the Customer & Save changes
				entityManager.remove( cust );
				entityTransaction.commit();
				System.out.println( "deleteCustomer - Customer with ID : " + id + " was DELETED." );
			}
			else 
				System.out.println( "deleteCustomer - Customer with ID : " + id + " was not found." );

		}catch (Exception e) {
			
			if( entityTransaction!= null )
				entityTransaction.rollback();
			
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		
	}
	
}
