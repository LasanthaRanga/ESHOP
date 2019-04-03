package com.eshop.entitiy;
// Generated Mar 18, 2019 10:10:47 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ShopHasUser generated by hbm2java
 */
@Entity
@Table(name = "shop_has_user", catalog = "eshop")
public class ShopHasUser implements java.io.Serializable {

	private Integer idShopHasUser;
	private Shop shop;
	private User user;
	private Integer shopHasUserStatus;

	public ShopHasUser() {
	}

	public ShopHasUser(Shop shop, User user) {
		this.shop = shop;
		this.user = user;
	}

	public ShopHasUser(Shop shop, User user, Integer shopHasUserStatus) {
		this.shop = shop;
		this.user = user;
		this.shopHasUserStatus = shopHasUserStatus;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idShop_has_User", unique = true, nullable = false)
	public Integer getIdShopHasUser() {
		return this.idShopHasUser;
	}

	public void setIdShopHasUser(Integer idShopHasUser) {
		this.idShopHasUser = idShopHasUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Shop_idShop", nullable = false)
	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "User_idUser", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "Shop_has_UserStatus")
	public Integer getShopHasUserStatus() {
		return this.shopHasUserStatus;
	}

	public void setShopHasUserStatus(Integer shopHasUserStatus) {
		this.shopHasUserStatus = shopHasUserStatus;
	}

}
