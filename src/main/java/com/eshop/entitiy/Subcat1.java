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

/**
 * Subcat1 generated by hbm2java
 */
@Entity
@Table(name = "subcat1", catalog = "eshop")
public class Subcat1 implements java.io.Serializable {

	private Integer idSubcat1;
	private Maincat maincat;
	private String subcat1name;
	private Integer subcat1status;
	@JsonIgnore
	private Set<Subcat2> subcat2s = new HashSet<Subcat2>(0);
	@JsonIgnore
	private Set<Product> products = new HashSet<Product>(0);

	public Subcat1() {
	}

	public Subcat1(Maincat maincat) {
		this.maincat = maincat;
	}

	public Subcat1(Maincat maincat, String subcat1name, Integer subcat1status, Set<Subcat2> subcat2s,
			Set<Product> products) {
		this.maincat = maincat;
		this.subcat1name = subcat1name;
		this.subcat1status = subcat1status;
		this.subcat2s = subcat2s;
		this.products = products;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idSubcat1", unique = true, nullable = false)
	public Integer getIdSubcat1() {
		return this.idSubcat1;
	}

	public void setIdSubcat1(Integer idSubcat1) {
		this.idSubcat1 = idSubcat1;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Maincat_idMaincat", nullable = false)
	public Maincat getMaincat() {
		return this.maincat;
	}

	public void setMaincat(Maincat maincat) {
		this.maincat = maincat;
	}

	@Column(name = "Subcat1Name")
	public String getSubcat1name() {
		return this.subcat1name;
	}

	public void setSubcat1name(String subcat1name) {
		this.subcat1name = subcat1name;
	}

	@Column(name = "Subcat1Status")
	public Integer getSubcat1status() {
		return this.subcat1status;
	}

	public void setSubcat1status(Integer subcat1status) {
		this.subcat1status = subcat1status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subcat1")
	public Set<Subcat2> getSubcat2s() {
		return this.subcat2s;
	}

	public void setSubcat2s(Set<Subcat2> subcat2s) {
		this.subcat2s = subcat2s;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subcat1")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
