package com.epazarlama.otopazarlama.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Kullanicilar implements Serializable {

	@Id
	@GeneratedValue
	private Long Kullanici_ID;
	@Column(unique = false, nullable = false)
	private String Kullanici_Adi;
	@Column(nullable = false)
	private String Parola;
	@Column(nullable = false)
	private String Ad;
	@Column(nullable = false)
	private String Soyad;
	@Column(nullable = false)
	private String Telefon;
	private boolean kullaniciTuru = false; // false ise normal kullanici true ise admin

	@OneToMany(mappedBy = "alici")
	private List<Mesajlar> listMesajAlici = new ArrayList<Mesajlar>();
	@OneToMany(mappedBy = "gonderici")
	private List<Mesajlar> listMesajGonderici = new ArrayList<Mesajlar>();

	@OneToMany(mappedBy = "Kullanici")
	private List<Araclar> listIlan = new ArrayList<Araclar>();

	@OneToMany(mappedBy = "kullanici")
	private List<Yorumlar> listYorum = new ArrayList<Yorumlar>();

	public Long getKullanici_ID() {
		return Kullanici_ID;
	}

	public void setKullanici_ID(Long kullanici_ID) {
		Kullanici_ID = kullanici_ID;
	}

	public String getKullanici_Adi() {
		return Kullanici_Adi;
	}

	public void setKullanici_Adi(String kullanici_Adi) {
		Kullanici_Adi = kullanici_Adi;
	}

	public String getParola() {
		return Parola;
	}

	public void setParola(String parola) {
		Parola = parola;
	}

	public String getAd() {
		return Ad;
	}

	public void setAd(String ad) {
		Ad = ad;
	}

	public String getSoyad() {
		return Soyad;
	}

	public void setSoyad(String soyad) {
		Soyad = soyad;
	}

	public String getTelefon() {
		return Telefon;
	}

	public void setTelefon(String telefon) {
		Telefon = telefon;
	}

	public List<Mesajlar> getListMesajAlici() {
		return listMesajAlici;
	}

	public void setListMesajAlici(List<Mesajlar> listMesajAlici) {
		this.listMesajAlici = listMesajAlici;
	}

	public List<Mesajlar> getListMesajGonderici() {
		return listMesajGonderici;
	}

	public void setListMesajGonderici(List<Mesajlar> listMesajGonderici) {
		this.listMesajGonderici = listMesajGonderici;
	}

	public List<Araclar> getListIlan() {
		return listIlan;
	}

	public void setListIlan(List<Araclar> listIlan) {
		this.listIlan = listIlan;
	}

	public List<Yorumlar> getListYorum() {
		return listYorum;
	}

	public void setListYorum(List<Yorumlar> listYorum) {
		this.listYorum = listYorum;
	}

	public boolean isKullaniciTuru() {
		return kullaniciTuru;
	}

	public void setKullaniciTuru(boolean kullaniciTuru) {
		this.kullaniciTuru = kullaniciTuru;
	}

}
