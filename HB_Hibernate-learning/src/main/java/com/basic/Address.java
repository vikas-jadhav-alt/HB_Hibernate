package com.basic;

import java.util.Arrays;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "student_address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	@Column(name = "address_id")
	private int adressId;
	// address_id integer not null auto_increment
	// primary key (address_id)

	@Column(name = "STREET", length = 50)
	private String street;

	@Column(name = "CITY", length = 100) // CITY varchar(100)
	private String city;

	@Column(name = "is_open") // is_open bit
	private boolean isOpen;

	@Transient
	private double x;

	@Column(name = "added_date")
	@Temporal(TemporalType.DATE)
	private Date addedDate;

	@Lob // => image tinyblob ==> default
	@Column(name = "image", columnDefinition="BLOB") //=> image BLOB
	private byte[] image;

	public Address() {
		super();
	}

	public int getAdressId() {
		return adressId;
	}

	public void setAdressId(int adressId) {
		this.adressId = adressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Address [adressId=" + adressId + ", street=" + street + ", city=" + city + ", isOpen=" + isOpen + ", x="
				+ x + ", addedDate=" + addedDate + ", image=" + Arrays.toString(image) + "]";
	}

}
