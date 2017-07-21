package com.epazarlama.otopazarlama.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Yakit implements Serializable {
	@Id
	@GeneratedValue
	private Long Yakit_ID;
	private String Yakit_Turu;
	
	@OneToMany(mappedBy = "Yakit")
	private List<Araclar> listIlan = new ArrayList<Araclar>();

	public Long getYakit_ID() {
		return Yakit_ID;
	}

	public void setYakit_ID(Long yakit_ID) {
		Yakit_ID = yakit_ID;
	}

	public String getYakit_Turu() {
		return Yakit_Turu;
	}

	public void setYakit_Turu(String yakit_Turu) {
		Yakit_Turu = yakit_Turu;
	}

	public List<Araclar> getListIlan() {
		return listIlan;
	}

	public void setListIlan(List<Araclar> listIlan) {
		this.listIlan = listIlan;
	}

}
