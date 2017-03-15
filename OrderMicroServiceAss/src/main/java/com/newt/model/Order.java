package com.newt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORDERS_DETAILS")
public class Order {
	@Id
	private String cFirstName;
	@Column
	private String cLastName;
	@Column
	private long cPhone;
	@Column
	private String orderDate;
	@Column
	private String soldBy;
	public Order() {
		super();
	}
	public Order(String cFirstName, String cLastName, long cPhone, String orderDate, String soldBy) {
		super();
		this.cFirstName = cFirstName;
		this.cLastName = cLastName;
		this.cPhone = cPhone;
		this.orderDate = orderDate;
		this.soldBy = soldBy;
	}
	public String getcFirstName() {
		return cFirstName;
	}
	public void setcFirstName(String cFirstName) {
		this.cFirstName = cFirstName;
	}
	public String getcLastName() {
		return cLastName;
	}
	public void setcLastName(String cLastName) {
		this.cLastName = cLastName;
	}
	public long getcPhone() {
		return cPhone;
	}
	public void setcPhone(long cPhone) {
		this.cPhone = cPhone;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getSoldBy() {
		return soldBy;
	}
	public void setSoldBy(String string) {
		this.soldBy = string;
	}
	@Override
	public String toString() {
		return "Order [cFirstName=" + cFirstName + ", cLastName=" + cLastName + ", cPhone=" + cPhone + ", orderDate="
				+ orderDate + ", soldBy=" + soldBy + "]";
	}
	
}
