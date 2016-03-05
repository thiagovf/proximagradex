package br.com.equipejr.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "NEXT_BEER")
public class NextBeer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_to_pay")
	private Calendar dateToPay;

	@Column(nullable = false)
	private Boolean paid;

	@Column(nullable = false)
	private String motivation;

	@Column(nullable = false, columnDefinition = "Varchar(255) default ''")
	private String lat;

	@Column(nullable = false, columnDefinition = "Varchar(255) default ''")
	private String lng;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	private User payer;

	public Calendar getDate() {
		return date;
	}

	public void setDateToPay(Calendar dateToPay) {
		this.dateToPay = dateToPay;
	}

	public Calendar getDateToPay() {
		return dateToPay;
	}

	public User getPayer() {
		return payer;
	}

	public String getMotivation() {
		return motivation;
	}

	public Long getId() {
		return id;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}

	public void setPayer(User payer) {
		this.payer = payer;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

}
