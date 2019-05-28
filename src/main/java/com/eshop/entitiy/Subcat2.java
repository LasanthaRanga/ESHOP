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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Subcat2 generated by hbm2java
 */
@Entity
@Table(name = "subcat2", catalog = "eshop")
public class Subcat2 implements java.io.Serializable {

	private Integer idSubcat2;
	private Subcat1 subcat1;
	private String subcat2name;
	private Integer subcat2status;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "products"})
	private Set<Product> products = new HashSet<Product>(0);
	
	

	public Subcat2() {
	}

	public Subcat2(Subcat1 subcat1) {
		this.subcat1 = subcat1;
	}

	public Subcat2(Subcat1 subcat1, String subcat2name, Integer subcat2status, Set<Product> products) {
		this.subcat1 = subcat1;
		this.subcat2name = subcat2name;
		this.subcat2status = subcat2status;
		this.products = products;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idSubcat2", unique = true, nullable = false)
	public Integer getIdSubcat2() {
		return this.idSubcat2;
	}

	public void setIdSubcat2(Integer idSubcat2) {
		this.idSubcat2 = idSubcat2;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Subcat1_idSubcat1", nullable = false)
	public Subcat1 getSubcat1() {
		return this.subcat1;
	}

	public void setSubcat1(Subcat1 subcat1) {
		this.subcat1 = subcat1;
	}

	@Column(name = "Subcat2Name")
	public String getSubcat2name() {
		return this.subcat2name;
	}

	public void setSubcat2name(String subcat2name) {
		this.subcat2name = subcat2name;
	}

	@Column(name = "Subcat2Status")
	public Integer getSubcat2status() {
		return this.subcat2status;
	}

	public void setSubcat2status(Integer subcat2status) {
		this.subcat2status = subcat2status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subcat2")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
