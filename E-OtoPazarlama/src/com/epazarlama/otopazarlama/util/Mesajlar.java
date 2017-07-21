package com.epazarlama.otopazarlama.util;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Mesajlar implements Serializable {
	@Id
	@GeneratedValue
	private Long Mesaj_ID;
	private String MesajIcerik;
	@ManyToOne
	private Kullanicilar alici;
	@ManyToOne
	private Kullanicilar gonderici;

	public Long getMesaj_ID() {
		return Mesaj_ID;
	}

	public void setMesaj_ID(Long mesaj_ID) {
		Mesaj_ID = mesaj_ID;
	}

	public String getMesajIcerik() {
		return MesajIcerik;
	}

	public void setMesajIcerik(String mesajIcerik) {
		MesajIcerik = mesajIcerik;
	}

	public Kullanicilar getAlici() {
		return alici;
	}

	public void setAlici(Kullanicilar alici) {
		this.alici = alici;
	}

	public Kullanicilar getGonderici() {
		return gonderici;
	}

	public void setGonderici(Kullanicilar gonderici) {
		this.gonderici = gonderici;
	}

}
