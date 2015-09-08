package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CART database table.
 * 
 */
@Entity
@NamedQuery(name="Cart.findAll", query="SELECT c FROM Cart c")
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long orderid;

	@Column(updatable=false)
	private long qty;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="PRODID")
	private Product product;

	//bi-directional many-to-one association to Shopuser
	@ManyToOne
	@JoinColumn(name="USERID")
	private Shopuser shopuser;

	public Cart() {
	}

	public long getOrderid() {
		return this.orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	public long getQty() {
		return this.qty;
	}

	public void setQty(long qTY2) {
		this.qty = qTY2;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Shopuser getShopuser() {
		return this.shopuser;
	}

	public void setShopuser(Shopuser shopuser) {
		this.shopuser = shopuser;
	}

}