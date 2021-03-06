package com.eshop.entitiy;
// Generated Apr 10, 2019 12:46:25 AM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Sale generated by hbm2java
 */
@Entity
@Table(name = "sale", catalog = "eshop")
public class Sale implements java.io.Serializable {

	private Integer idSale;
	private Cart cart;
	private Shop shop;
	private Date saleDate;
	private Double totalPrice;
	private Double saleStatus;

	public Sale() {
	}

	public Sale(Cart cart, Shop shop) {
		this.cart = cart;
		this.shop = shop;
	}

	public Sale(Cart cart, Shop shop, Date saleDate, Double totalPrice, Double saleStatus) {
		this.cart = cart;
		this.shop = shop;
		this.saleDate = saleDate;
		this.totalPrice = totalPrice;
		this.saleStatus = saleStatus;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idSale", unique = true, nullable = false)
	public Integer getIdSale() {
		return this.idSale;
	}

	public void setIdSale(Integer idSale) {
		this.idSale = idSale;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Cart_idCart", nullable = false)
	public Cart getCart() {
		return this.cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Shop_idShop", nullable = false)
	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SaleDate", length = 26)
	public Date getSaleDate() {
		return this.saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	@Column(name = "TotalPrice", precision = 22, scale = 0)
	public Double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Column(name = "SaleStatus", precision = 22, scale = 0)
	public Double getSaleStatus() {
		return this.saleStatus;
	}

	public void setSaleStatus(Double saleStatus) {
		this.saleStatus = saleStatus;
	}

}
