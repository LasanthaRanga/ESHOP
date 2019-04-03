package com.eshop.entitiy;
// Generated Mar 18, 2019 10:10:47 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Ulavels generated by hbm2java
 */
@Entity
@Table(name = "ulavels", catalog = "eshop")
public class Ulavels implements java.io.Serializable {

	private Integer idUlavels;
	private String ulavelDiscription;
	private Double ulavelSalse;
	private Double ulavelCoins;
	private Double ulavelTarget;

	public Ulavels() {
	}

	public Ulavels(String ulavelDiscription, Double ulavelSalse, Double ulavelCoins, Double ulavelTarget) {
		this.ulavelDiscription = ulavelDiscription;
		this.ulavelSalse = ulavelSalse;
		this.ulavelCoins = ulavelCoins;
		this.ulavelTarget = ulavelTarget;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idULavels", unique = true, nullable = false)
	public Integer getIdUlavels() {
		return this.idUlavels;
	}

	public void setIdUlavels(Integer idUlavels) {
		this.idUlavels = idUlavels;
	}

	@Column(name = "ULavelDiscription", length = 65535)
	public String getUlavelDiscription() {
		return this.ulavelDiscription;
	}

	public void setUlavelDiscription(String ulavelDiscription) {
		this.ulavelDiscription = ulavelDiscription;
	}

	@Column(name = "ULavelSalse", precision = 22, scale = 0)
	public Double getUlavelSalse() {
		return this.ulavelSalse;
	}

	public void setUlavelSalse(Double ulavelSalse) {
		this.ulavelSalse = ulavelSalse;
	}

	@Column(name = "ULavelCoins", precision = 22, scale = 0)
	public Double getUlavelCoins() {
		return this.ulavelCoins;
	}

	public void setUlavelCoins(Double ulavelCoins) {
		this.ulavelCoins = ulavelCoins;
	}

	@Column(name = "ULavelTarget", precision = 22, scale = 0)
	public Double getUlavelTarget() {
		return this.ulavelTarget;
	}

	public void setUlavelTarget(Double ulavelTarget) {
		this.ulavelTarget = ulavelTarget;
	}

}
