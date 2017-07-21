package com.epazarlama.otopazarlama.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@Entity
public class Resimler implements Serializable {

	@Id
	@GeneratedValue
	private Long Resim_ID;

	private String Resim_Yolu;
	@ManyToOne
	private Araclar ilan;

	public Long getResim_ID() {
		return Resim_ID;
	}

	public void setResim_ID(Long resim_ID) {
		Resim_ID = resim_ID;
	}

	public Araclar getIlan() {
		return ilan;
	}

	public void setIlan(Araclar ilan) {
		this.ilan = ilan;
	}

	

	public String getResim_Yolu() {
		return Resim_Yolu;
	}

	public void setResim_Yolu(String resim_Yolu) {
		Resim_Yolu = resim_Yolu;
	}

}
