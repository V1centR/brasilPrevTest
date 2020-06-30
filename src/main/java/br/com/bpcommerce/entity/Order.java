package br.com.bpcommerce.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int orderitems;

	private String orderstatus;

	//bi-directional many-to-one association to Orderitem
	@OneToMany(mappedBy="order")
	private List<Orderitem> orderitemsSet;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customer customer;

	public Order() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(int orderitems) {
		this.orderitems = orderitems;
	}

	public String getOrderstatus() {
		return this.orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public List<Orderitem> getOrderitemsSet() {
		return this.orderitemsSet;
	}

	public void setOrderitemsSet(List<Orderitem> orderitemsSet) {
		this.orderitemsSet = orderitemsSet;
	}

	public Orderitem addOrderitemsSet(Orderitem orderitemsSet) {
		getOrderitemsSet().add(orderitemsSet);
		orderitemsSet.setOrder(this);

		return orderitemsSet;
	}

	public Orderitem removeOrderitemsSet(Orderitem orderitemsSet) {
		getOrderitemsSet().remove(orderitemsSet);
		orderitemsSet.setOrder(null);

		return orderitemsSet;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}