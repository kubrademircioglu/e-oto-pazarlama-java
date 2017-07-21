package com.epazarlama.otopazarlama.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Kasa implements Serializable {

	@Id
	@GeneratedValue
	private Long Kasa_ID;
	private String KasaTipi;
	
	@OneToMany(mappedBy = "Kasa")
	private List<Araclar> listIlan = new ArrayList<Araclar>();

	public Long getKasa_ID() {
		return Kasa_ID;
	}

	public void setKasa_ID(Long kasa_ID) {
		Kasa_ID = kasa_ID;
	}

	public String getKasaTipi() {
		return KasaTipi;
	}

	public void setKasaTipi(String kasaTipi) {
		KasaTipi = kasaTipi;
	}

	public List<Araclar> getListIlan() {
		return listIlan;
	}

	public void setListIlan(List<Araclar> listIlan) {
		this.listIlan = listIlan;
	}

}
