package com.epazarlama.otopazarlama.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Renk implements Serializable {

	@Id
	@GeneratedValue
	private Long Renk_ID;
	private String Renk_Adi;
	
	@OneToMany(mappedBy = "Renk")
	private List<Araclar> listIlan = new ArrayList<Araclar>();

	public Long getRenk_ID() {
		return Renk_ID;
	}

	public void setRenk_ID(Long renk_ID) {
		Renk_ID = renk_ID;
	}

	public String getRenk_Adi() {
		return Renk_Adi;
	}

	public void setRenk_Adi(String renk_Adi) {
		Renk_Adi = renk_Adi;
	}

	public List<Araclar> getListIlan() {
		return listIlan;
	}

	public void setListIlan(List<Araclar> listIlan) {
		this.listIlan = listIlan;
	}

}
