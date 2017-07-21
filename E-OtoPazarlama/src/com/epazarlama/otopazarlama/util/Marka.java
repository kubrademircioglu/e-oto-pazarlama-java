package com.epazarlama.otopazarlama.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Marka implements Serializable {
	@Id
	@GeneratedValue
	private Long Marka_ID;
	private String Marka_Adi;

	@OneToMany(mappedBy = "Marka")
	private List<Seri> listeSeri = new ArrayList<Seri>();

	@OneToMany(mappedBy = "Marka")
	List<Araclar> listeIlan = new ArrayList<Araclar>();

	
	

	public List<Seri> getListeSeri() {
		return listeSeri;
	}

	public void setListeSeri(List<Seri> listeSeri) {
		this.listeSeri = listeSeri;
	}

	public String getMarka_Adi() {
		return Marka_Adi;
	}

	public void setMarka_Adi(String marka_Adi) {
		Marka_Adi = marka_Adi;
	}

	public Long getMarka_ID() {
		return Marka_ID;
	}

	public void setMarka_ID(Long marka_ID) {
		Marka_ID = marka_ID;
	}

}
