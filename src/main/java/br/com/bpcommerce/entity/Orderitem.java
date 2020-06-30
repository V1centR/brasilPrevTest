package br.com.bpcommerce.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the orderitems database table.
 * 
 */
@Entity
@Table(name="orderitems")
@NamedQuery(name="Orderitem.findAll", query="SELECT o FROM Orderitem o")
public class Orderitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String itemprice;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="orderid")
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="productid")
	private Product product;

	public Orderitem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemprice() {
		return this.itemprice;
	}

	public void setItemprice(String itemprice) {
		this.itemprice = itemprice;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}