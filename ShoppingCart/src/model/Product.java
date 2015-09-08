package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PRODUCT database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long prodid;

	private String description;

	private String picture;

	private double price;

	private String prodname;

	//bi-directional many-to-one association to Cart
	@OneToMany(mappedBy="product")
	private List<Cart> carts;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="product")
	private List<Comment> comments;

	public Product() {
	}

	public long getProdid() {
		return this.prodid;
	}

	public void setProdid(long prodid) {
		this.prodid = prodid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProdname() {
		return this.prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Cart addCart(Cart cart) {
		getCarts().add(cart);
		cart.setProduct(this);

		return cart;
	}

	public Cart removeCart(Cart cart) {
		getCarts().remove(cart);
		cart.setProduct(null);

		return cart;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setProduct(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setProduct(null);

		return comment;
	}

}