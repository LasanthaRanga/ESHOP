package com.eshop.entitiy;
// Generated Apr 10, 2019 12:46:25 AM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Shop generated by hbm2java
 */
@Entity
@Table(name = "shop", catalog = "eshop")
public class Shop implements java.io.Serializable {

	private Integer idShop;
	private User user;
	private String shopName;
	private Date shopStartDate;
	private Integer shopStatus;
	private String shopDiscription;

	private Set<Cart> carts = new HashSet<Cart>(0);
	
	private Set<ShopHasUser> shopHasUsers = new HashSet<ShopHasUser>(0);
	
	private Set<Sale> sales = new HashSet<Sale>(0);
	
	private Set<Shophasproduct> shophasproducts = new HashSet<Shophasproduct>(0);

	public Shop() {
	}

	public Shop(User user) {
		this.user = user;
	}

	public Shop(User user, String shopName, Date shopStartDate, Integer shopStatus, String shopDiscription,
			Set<Cart> carts, Set<ShopHasUser> shopHasUsers, Set<Sale> sales, Set<Shophasproduct> shophasproducts) {
		this.user = user;
		this.shopName = shopName;
		this.shopStartDate = shopStartDate;
		this.shopStatus = shopStatus;
		this.shopDiscription = shopDiscription;
		this.carts = carts;
		this.shopHasUsers = shopHasUsers;
		this.sales = sales;
		this.shophasproducts = shophasproducts;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idShop", unique = true, nullable = false)
	public Integer getIdShop() {
		return this.idShop;
	}

	public void setIdShop(Integer idShop) {
		this.idShop = idShop;
	}
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "User_idUser", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "ShopName")
	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ShopStartDate", length = 10)
	public Date getShopStartDate() {
		return this.shopStartDate;
	}

	public void setShopStartDate(Date shopStartDate) {
		this.shopStartDate = shopStartDate;
	}

	@Column(name = "ShopStatus")
	public Integer getShopStatus() {
		return this.shopStatus;
	}

	public void setShopStatus(Integer shopStatus) {
		this.shopStatus = shopStatus;
	}

	@Column(name = "ShopDiscription")
	public String getShopDiscription() {
		return this.shopDiscription;
	}

	public void setShopDiscription(String shopDiscription) {
		this.shopDiscription = shopDiscription;
	}
	@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shop")
	public Set<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}
	@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shop")
	public Set<ShopHasUser> getShopHasUsers() {
		return this.shopHasUsers;
	}

	public void setShopHasUsers(Set<ShopHasUser> shopHasUsers) {
		this.shopHasUsers = shopHasUsers;
	}
	@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shop")
	public Set<Sale> getSales() {
		return this.sales;
	}

	public void setSales(Set<Sale> sales) {
		this.sales = sales;
	}
	@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "shop")
	public Set<Shophasproduct> getShophasproducts() {
		return this.shophasproducts;
	}

	public void setShophasproducts(Set<Shophasproduct> shophasproducts) {
		this.shophasproducts = shophasproducts;
	}

}
