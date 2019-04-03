package com.eshop.entitiy;
// Generated Mar 18, 2019 10:10:47 PM by Hibernate Tools 4.3.5.Final

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

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "eshop")
public class User implements java.io.Serializable {

	private Integer idUser;
	private Usertype usertype;
	private String userEmail;
	private String userPassword;
	private String userContact1;
	private String userContact2;
	private String userAddress1;
	private String userAddress2;
	private String userAddress3;
	private String userPostalCode;
	private Integer userStatus;
	private String userName;
	private String gender;
	private String userNic;
	private String userDiscription;
	private Double userCurrentCoin;
	private Double userCurrentConinValue;
	private Set<ShopHasUser> shopHasUsers = new HashSet<ShopHasUser>(0);
	private Set<Cart> carts = new HashSet<Cart>(0);
	private Set<Product> products = new HashSet<Product>(0);
	private Set<Shop> shops = new HashSet<Shop>(0);

	public User() {
	}

	public User(Usertype usertype) {
		this.usertype = usertype;
	}

	public User(Usertype usertype, String userEmail, String userPassword, String userContact1, String userContact2,
			String userAddress1, String userAddress2, String userAddress3, String userPostalCode, Integer userStatus,
			String userName, String gender, String userNic, String userDiscription, Double userCurrentCoin,
			Double userCurrentConinValue, Set<ShopHasUser> shopHasUsers, Set<Cart> carts, Set<Product> products,
			Set<Shop> shops) {
		this.usertype = usertype;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userContact1 = userContact1;
		this.userContact2 = userContact2;
		this.userAddress1 = userAddress1;
		this.userAddress2 = userAddress2;
		this.userAddress3 = userAddress3;
		this.userPostalCode = userPostalCode;
		this.userStatus = userStatus;
		this.userName = userName;
		this.gender = gender;
		this.userNic = userNic;
		this.userDiscription = userDiscription;
		this.userCurrentCoin = userCurrentCoin;
		this.userCurrentConinValue = userCurrentConinValue;
		this.shopHasUsers = shopHasUsers;
		this.carts = carts;
		this.products = products;
		this.shops = shops;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idUser", unique = true, nullable = false)
	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserType_idUserType", nullable = false)
	public Usertype getUsertype() {
		return this.usertype;
	}

	public void setUsertype(Usertype usertype) {
		this.usertype = usertype;
	}

	@Column(name = "UserEmail")
	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "UserPassword")
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "UserContact1", length = 45)
	public String getUserContact1() {
		return this.userContact1;
	}

	public void setUserContact1(String userContact1) {
		this.userContact1 = userContact1;
	}

	@Column(name = "UserContact2", length = 45)
	public String getUserContact2() {
		return this.userContact2;
	}

	public void setUserContact2(String userContact2) {
		this.userContact2 = userContact2;
	}

	@Column(name = "UserAddress1")
	public String getUserAddress1() {
		return this.userAddress1;
	}

	public void setUserAddress1(String userAddress1) {
		this.userAddress1 = userAddress1;
	}

	@Column(name = "UserAddress2")
	public String getUserAddress2() {
		return this.userAddress2;
	}

	public void setUserAddress2(String userAddress2) {
		this.userAddress2 = userAddress2;
	}

	@Column(name = "UserAddress3")
	public String getUserAddress3() {
		return this.userAddress3;
	}

	public void setUserAddress3(String userAddress3) {
		this.userAddress3 = userAddress3;
	}

	@Column(name = "UserPostalCode", length = 45)
	public String getUserPostalCode() {
		return this.userPostalCode;
	}

	public void setUserPostalCode(String userPostalCode) {
		this.userPostalCode = userPostalCode;
	}

	@Column(name = "UserStatus")
	public Integer getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	@Column(name = "UserName")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "gender", length = 45)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "UserNic", length = 45)
	public String getUserNic() {
		return this.userNic;
	}

	public void setUserNic(String userNic) {
		this.userNic = userNic;
	}

	@Column(name = "UserDiscription", length = 65535)
	public String getUserDiscription() {
		return this.userDiscription;
	}

	public void setUserDiscription(String userDiscription) {
		this.userDiscription = userDiscription;
	}

	@Column(name = "UserCurrentCoin", precision = 22, scale = 0)
	public Double getUserCurrentCoin() {
		return this.userCurrentCoin;
	}

	public void setUserCurrentCoin(Double userCurrentCoin) {
		this.userCurrentCoin = userCurrentCoin;
	}

	@Column(name = "UserCurrentConinValue", precision = 22, scale = 0)
	public Double getUserCurrentConinValue() {
		return this.userCurrentConinValue;
	}

	public void setUserCurrentConinValue(Double userCurrentConinValue) {
		this.userCurrentConinValue = userCurrentConinValue;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<ShopHasUser> getShopHasUsers() {
		return this.shopHasUsers;
	}

	public void setShopHasUsers(Set<ShopHasUser> shopHasUsers) {
		this.shopHasUsers = shopHasUsers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Shop> getShops() {
		return this.shops;
	}

	public void setShops(Set<Shop> shops) {
		this.shops = shops;
	}

}
