package com.epazarlama.otopazarlama.util;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Yorumlar implements Serializable {
	@Id
	@GeneratedValue
	private Long Yorum_ID;
	private String Yorum_Icerigi;

	@ManyToOne
	private Kullanicilar kullanici;
	@ManyToOne
	private Araclar ilan;

	public Long getYorum_ID() {
		return Yorum_ID;
	}

	public void setYorum_ID(Long yorum_ID) {
		Yorum_ID = yorum_ID;
	}

	public String getYorum_Icerigi() {
		return Yorum_Icerigi;
	}

	public void setYorum_Icerigi(String yorum_Icerigi) {
		Yorum_Icerigi = yorum_Icerigi;
	}

	public Kullanicilar getKullanici() {
		return kullanici;
	}

	public void setKullanici(Kullanicilar kullanici) {
		this.kullanici = kullanici;
	}

	public Araclar getIlan() {
		return ilan;
	}

	public void setIlan(Araclar ilan) {
		this.ilan = ilan;
	}

}
