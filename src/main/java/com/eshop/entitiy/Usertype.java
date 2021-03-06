package com.eshop.entitiy;
// Generated Apr 10, 2019 12:46:25 AM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Usertype generated by hbm2java
 */
@Entity
@Table(name = "usertype", catalog = "eshop")
public class Usertype implements java.io.Serializable {

	private Integer idUserType;
	private String userTypeName;
	private Set<User> users = new HashSet<User>(0);
	private Set<UsertypeHasPage> usertypeHasPages = new HashSet<UsertypeHasPage>(0);

	public Usertype() {
	}

	public Usertype(String userTypeName, Set<User> users, Set<UsertypeHasPage> usertypeHasPages) {
		this.userTypeName = userTypeName;
		this.users = users;
		this.usertypeHasPages = usertypeHasPages;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idUserType", unique = true, nullable = false)
	public Integer getIdUserType() {
		return this.idUserType;
	}

	public void setIdUserType(Integer idUserType) {
		this.idUserType = idUserType;
	}

	@Column(name = "UserTypeName")
	public String getUserTypeName() {
		return this.userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usertype")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usertype")
	public Set<UsertypeHasPage> getUsertypeHasPages() {
		return this.usertypeHasPages;
	}

	public void setUsertypeHasPages(Set<UsertypeHasPage> usertypeHasPages) {
		this.usertypeHasPages = usertypeHasPages;
	}

}
