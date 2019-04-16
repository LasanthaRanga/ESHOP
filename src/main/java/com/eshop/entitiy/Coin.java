package com.eshop.entitiy;
// Generated Apr 10, 2019 12:46:25 AM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Coin generated by hbm2java
 */
@Entity
@Table(name = "coin", catalog = "eshop")
public class Coin implements java.io.Serializable {

	private Integer idCoin;
	private Double coinRate;
	private Integer coinRateStatus;
	private Date coinRateChangeDate;

	public Coin() {
	}

	public Coin(Double coinRate, Integer coinRateStatus, Date coinRateChangeDate) {
		this.coinRate = coinRate;
		this.coinRateStatus = coinRateStatus;
		this.coinRateChangeDate = coinRateChangeDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idCoin", unique = true, nullable = false)
	public Integer getIdCoin() {
		return this.idCoin;
	}

	public void setIdCoin(Integer idCoin) {
		this.idCoin = idCoin;
	}

	@Column(name = "CoinRate", precision = 22, scale = 0)
	public Double getCoinRate() {
		return this.coinRate;
	}

	public void setCoinRate(Double coinRate) {
		this.coinRate = coinRate;
	}

	@Column(name = "CoinRateStatus")
	public Integer getCoinRateStatus() {
		return this.coinRateStatus;
	}

	public void setCoinRateStatus(Integer coinRateStatus) {
		this.coinRateStatus = coinRateStatus;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CoinRateChangeDate", length = 10)
	public Date getCoinRateChangeDate() {
		return this.coinRateChangeDate;
	}

	public void setCoinRateChangeDate(Date coinRateChangeDate) {
		this.coinRateChangeDate = coinRateChangeDate;
	}

}
