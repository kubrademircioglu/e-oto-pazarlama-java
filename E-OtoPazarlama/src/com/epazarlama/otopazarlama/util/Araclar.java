package com.epazarlama.otopazarlama.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Araclar implements Serializable {
	@Id
	@GeneratedValue
	private Long Arac_ID;
	private Date ilan_Tarihi;
	private Integer ilan_Fiyati;
	private String Model_Yili;
	private String KM;
	private String Durum;
	private String Aciklama;
	private String Basklik;

	@ManyToOne
	private Marka Marka;
	@ManyToOne
	private Seri Seri;
	@ManyToOne
	private Vites Vites;
	@ManyToOne
	private Yakit Yakit;
	@ManyToOne
	private Kasa Kasa;
	@ManyToOne
	private Renk Renk;
	@ManyToOne
	private Kullanicilar Kullanici;

	@OneToMany(mappedBy = "ilan")
	private List<Yorumlar> listYorum = new ArrayList<Yorumlar>();

	@OneToMany(mappedBy = "ilan")
	private List<Resimler> listResim = new ArrayList<Resimler>();

	public Long getIlan_ID() {
		return getArac_ID();
	}

	public void setIlan_ID(Long ilan_ID) {
		setArac_ID(ilan_ID);
	}

	public Date getIlan_Tarihi() {
		return ilan_Tarihi;
	}

	public void setIlan_Tarihi(Date ilan_Tarihi) {
		this.ilan_Tarihi = ilan_Tarihi;
	}

	public Integer getIlan_Fiyati() {
		return ilan_Fiyati;
	}

	public void setIlan_Fiyati(Integer ilan_Fiyati) {
		this.ilan_Fiyati = ilan_Fiyati;
	}

	public String getModel_Yili() {
		return Model_Yili;
	}

	public void setModel_Yili(String model_Yili) {
		Model_Yili = model_Yili;
	}

	public String getKM() {
		return KM;
	}

	public void setKM(String kM) {
		KM = kM;
	}

	public String getDurum() {
		return Durum;
	}

	public void setDurum(String durum) {
		Durum = durum;
	}

	public String getAciklama() {
		return Aciklama;
	}

	public void setAciklama(String aciklama) {
		Aciklama = aciklama;
	}

	public Marka getMarka() {
		return Marka;
	}

	public void setMarka(Marka marka) {
		Marka = marka;
	}

	public Seri getSeri() {
		return Seri;
	}

	public void setSeri(Seri seri) {
		Seri = seri;
	}

	public Yakit getYakit() {
		return Yakit;
	}

	public void setYakit(Yakit yakit) {
		Yakit = yakit;
	}

	public Vites getVites() {
		return Vites;
	}

	public void setVites(Vites vites) {
		Vites = vites;
	}

	public Kasa getKasa() {
		return Kasa;
	}

	public void setKasa(Kasa kasa) {
		Kasa = kasa;
	}

	public Renk getRenk() {
		return Renk;
	}

	public void setRenk(Renk renk) {
		Renk = renk;
	}

	public Kullanicilar getKullanici() {
		return Kullanici;
	}

	public void setKullanici(Kullanicilar kullanici) {
		Kullanici = kullanici;
	}

	public List<Resimler> getListResim() {
		return listResim;
	}

	public void setListResim(List<Resimler> listResim) {
		this.listResim = listResim;
	}

	public String getBasklik() {
		return Basklik;
	}

	public void setBasklik(String basklik) {
		Basklik = basklik;
	}

	public Long getArac_ID() {
		return Arac_ID;
	}

	public void setArac_ID(Long arac_ID) {
		Arac_ID = arac_ID;
	}

}
