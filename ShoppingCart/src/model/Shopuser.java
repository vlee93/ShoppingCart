package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SHOPUSERS database table.
 * 
 */
@Entity
@Table(name="SHOPUSERS", schema = "TESTDB")
@NamedQuery(name="Shopuser.findAll", query="SELECT s FROM Shopuser s")
public class Shopuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long userid;

	private String email;

	private String fullname;

	private String username;

	private String userpass;

	private String usertype;

	//bi-directional many-to-one association to Cart
	@OneToMany(mappedBy="shopuser")
	private List<Cart> carts;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="shopuser")
	private List<Comment> comments;

	public Shopuser() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return this.userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getUsertype() {
		return this.usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Cart addCart(Cart cart) {
		getCarts().add(cart);
		cart.setShopuser(this);

		return cart;
	}

	public Cart removeCart(Cart cart) {
		getCarts().remove(cart);
		cart.setShopuser(null);

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
		comment.setShopuser(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setShopuser(null);

		return comment;
	}

}