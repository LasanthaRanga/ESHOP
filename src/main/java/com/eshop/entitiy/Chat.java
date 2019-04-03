package com.eshop.entitiy;
// Generated Mar 18, 2019 10:10:47 PM by Hibernate Tools 4.3.5.Final

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
 * Chat generated by hbm2java
 */
@Entity
@Table(name = "chat", catalog = "eshop")
public class Chat implements java.io.Serializable {

	private Integer idChat;
	private Integer from;
	private Integer to;
	private String message;
	private Date datetime;
	private String other;

	public Chat() {
	}

	public Chat(Integer from, Integer to, String message, Date datetime, String other) {
		this.from = from;
		this.to = to;
		this.message = message;
		this.datetime = datetime;
		this.other = other;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idChat", unique = true, nullable = false)
	public Integer getIdChat() {
		return this.idChat;
	}

	public void setIdChat(Integer idChat) {
		this.idChat = idChat;
	}

	@Column(name = "from")
	public Integer getFrom() {
		return this.from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	@Column(name = "to")
	public Integer getTo() {
		return this.to;
	}

	public void setTo(Integer to) {
		this.to = to;
	}

	@Column(name = "message", length = 65535)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datetime", length = 26)
	public Date getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	@Column(name = "other")
	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

}
