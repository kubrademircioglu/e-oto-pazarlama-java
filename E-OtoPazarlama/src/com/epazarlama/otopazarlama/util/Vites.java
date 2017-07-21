package com.epazarlama.otopazarlama.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vites implements Serializable {
	@Id
	@GeneratedValue
	private Long Vites_ID;
	private String Vites_Turu;
	
	@OneToMany(mappedBy = "Vites")
	private List<Araclar> listIlan = new ArrayList<Araclar>();

	public Long getVites_ID() {
		return Vites_ID;
	}

	public void setVites_ID(Long vites_ID) {
		Vites_ID = vites_ID;
	}

	public String getVites_Turu() {
		return Vites_Turu;
	}

	public void setVites_Turu(String vites_Turu) {
		Vites_Turu = vites_Turu;
	}

	public List<Araclar> getListIlan() {
		return listIlan;
	}

	public void setListIlan(List<Araclar> listIlan) {
		this.listIlan = listIlan;
	}

}
