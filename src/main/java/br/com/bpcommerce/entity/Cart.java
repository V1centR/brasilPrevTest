package br.com.bpcommerce.entity;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bprevcart")
public class Cart {

	@Id
	private ObjectId _id;
	private String iduser;
	private ArrayList<ProductCart> prodInfo;
	private Double totalCart;
	
	public Cart() {}
	
	public Cart(ObjectId _id,String iduser, ArrayList<ProductCart> prodInfo, Double totalCart) {
		
		this._id = _id;
		this.iduser = iduser;
		this.prodInfo = prodInfo;
		this.totalCart = totalCart;
	}
	
	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getIduser() {
		return iduser;
	}

	public void setIduser(String iduser) {
		this.iduser = iduser;
	}

	public ArrayList<ProductCart> getProdInfo() {
		return prodInfo;
	}

	public void setProdInfo(ArrayList<ProductCart> prodInfo) {
		this.prodInfo = prodInfo;
	}

	public Double getTotalCart() {
		return totalCart;
	}

	public void setTotalCart(Double totalCart) {
		this.totalCart = totalCart;
	}
	
}
