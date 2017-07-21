package com.epazarlama.otopazarlama.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Seri implements Serializable {
	@Id
	@GeneratedValue
	private Long Seri_ID;
	private String Seri_Adi;
	@ManyToOne
	private Marka Marka;

	@OneToMany(mappedBy = "Seri")
	private List<Araclar> listeIlan = new ArrayList<Araclar>();

	public Long getSeri_ID() {
		return Seri_ID;
	}

	public void setSeri_ID(Long seri_ID) {
		Seri_ID = seri_ID;
	}

	public String getSeri_Adi() {
		return Seri_Adi;
	}

	public void setSeri_Adi(String seri_Adi) {
		Seri_Adi = seri_Adi;
	}

	public List<Araclar> getListeIlan() {
		return listeIlan;
	}

	public void setListeIlan(List<Araclar> listeIlan) {
		this.listeIlan = listeIlan;
	}

	public Marka getMarka() {
		return Marka;
	}

	public void setMarka(Marka marka) {
		Marka = marka;
	}

}
