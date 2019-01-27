package com.accolite.model;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
@NamedQueries({
	@NamedQuery(name="All",query="from Person"),
	@NamedQuery(name="getid",query="from Person where id = :id")
})
public class Person {

	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY) //** primary key **
	private int id;
	
	private String name;
	
//	@Embedded
//	private Address address;
//
//	public Address getAddress() {
//		return address;
//	}

//	public void setAddress(Address address) {
//		this.address = address;
//	}
	
//	@Embedded
//	@AttributeOverrides({@AttributeOverride(name="street",column = @Column(name="home_street")),
//		@AttributeOverride(name="city",column = @Column(name="home_city"))
//	})
//	private Address residentaddress;
//	
//	@Embedded
//	@AttributeOverrides({@AttributeOverride(name="street",column = @Column(name="business_street")),
//		@AttributeOverride(name="city",column = @Column(name="business_city"))
//	})
//	private Address businessaddress;
	
	@ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "person_addresses", joinColumns = @JoinColumn(name = "id"))
	Set<Address> addresses = new HashSet<Address>();
	
	@Override
	public String toString() {
//		return "Person [id=" + id + ", name=" + name + " , businessaddress=" + businessaddress +" , residentaddress=" + residentaddress +"]";
		return "Person [id=" + id + ", name=" + name + " , addresses=" + Arrays.asList(addresses)+"]";
	}
	
	public Set<Address> getAddresses() {
		return addresses;
	}
	
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	
//	public Address getResidentaddress() {
//		return residentaddress;
//	}
//
//	public void setResidentaddress(Address residentaddress) {
//		this.residentaddress = residentaddress;
//	}
//
//	public Address getBusinessaddress() {
//		return businessaddress;
//	}
//
//	public void setBusinessaddress(Address businessaddress) {
//		this.businessaddress = businessaddress;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
