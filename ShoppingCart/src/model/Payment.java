package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the PAYMENT database table.
 * 
 */
@Entity
@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String billadd;

	private String cnumber;

	@Temporal(TemporalType.DATE)
	private Date pdate;

	private String shipadd;

	private String total;

	//bi-directional many-to-one association to Shopuser
	@ManyToOne
	@JoinColumn(name="USERID")
	private Shopuser shopuser;

	public Payment() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBilladd() {
		return this.billadd;
	}

	public void setBilladd(String billadd) {
		this.billadd = billadd;
	}

	public String getCnumber() {
		return this.cnumber;
	}

	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}

	public Date getPdate() {
		return this.pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public String getShipadd() {
		return this.shipadd;
	}

	public void setShipadd(String shipadd) {
		this.shipadd = shipadd;
	}

	public String getTotal() {
		return this.total;
	}

	public void setTotal(String total2) {
		this.total = total2;
	}

	public Shopuser getShopuser() {
		return this.shopuser;
	}

	public void setShopuser(Shopuser shopuser) {
		this.shopuser = shopuser;
	}

}