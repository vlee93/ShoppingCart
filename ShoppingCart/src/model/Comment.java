package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the COMMENTS database table.
 * 
 */
@Entity
@Table(name="COMMENTS")
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long commentid;

	@Temporal(TemporalType.DATE)
	private Date commentdate;

	private String itemcomment;

	private long rating;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="PRODID")
	private Product product;

	//bi-directional many-to-one association to Shopuser
	@ManyToOne
	@JoinColumn(name="USERID")
	private Shopuser shopuser;

	public Comment() {
	}

	public long getCommentid() {
		return this.commentid;
	}

	public void setCommentid(long commentid) {
		this.commentid = commentid;
	}

	public Date getCommentdate() {
		return this.commentdate;
	}

	public void setCommentdate(Date commentdate) {
		this.commentdate = commentdate;
	}

	public String getItemcomment() {
		return this.itemcomment;
	}

	public void setItemcomment(String itemcomment) {
		this.itemcomment = itemcomment;
	}

	public long getRating() {
		return this.rating;
	}

	public void setRating(long rating2) {
		this.rating = rating2;
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