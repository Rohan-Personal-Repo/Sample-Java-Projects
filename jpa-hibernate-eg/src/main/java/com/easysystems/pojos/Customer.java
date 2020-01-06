package com.easysystems.pojos;

/*
	The Java Persistance API (JPA) makes it easy to use object data with
 	a database. With it you can Persist object data in a database. 
 	Hibernate is a Object Relational Mapping system that implements JPA.
*/
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


// Entity defines which objects should be persisted in the database 
@Entity
// Defines the name of the table created for the entity
@Table( name = "customer" )
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// All entities must define a primary key which you define with
	// the @Id annotation
	@Id
	
	// You can override the default column name 
	// Map id to the CustID field in the DB
	// You can have it auto generate
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "custID", unique = true )
	private int id;
	
	@Column( name = "firstName", nullable = false )
	private String firstName;
	
	@Column( name = "lastName", nullable = false )
	private String lastName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
