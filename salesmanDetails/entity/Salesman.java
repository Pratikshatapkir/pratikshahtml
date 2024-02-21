package com.expleo.salesmanDetails.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Salesman {
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int SalesmanId;
	private String name;
	private String address;
	private int mno;
	private String region;
	private String pswd;
	public Salesman() {
		super();
	}
	 
	public Salesman(int salesmanId, String name, String address, int mno, String region, String pswd) {
		super();
		SalesmanId = salesmanId;
		this.name = name;
		this.address = address;
		this.mno = mno;
		this.region = region;
		this.pswd = pswd;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	
	
	
	
	
}
