package br.com.bpcommerce.entity;

public class Cart {

	private String id;
	private String iduser;
	private String prodId;
	private String prodPrice;
	private String prodBrand;
	private String prodPic;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIduser() {
		return iduser;
	}
	public void setIduser(String iduser) {
		this.iduser = iduser;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getProdBrand() {
		return prodBrand;
	}
	public void setProdBrand(String prodBrand) {
		this.prodBrand = prodBrand;
	}
	public String getProdPic() {
		return prodPic;
	}
	public void setProdPic(String prodPic) {
		this.prodPic = prodPic;
	}
	
	
}
