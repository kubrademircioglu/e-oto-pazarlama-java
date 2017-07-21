package com.epazarlama.otopazarlama.util;

import java.util.List;

import javax.persistence.EntityManager;

public class KasaIslemleri extends Islemler implements StandartIslemler {

	private Kasa kasa = new Kasa();
	
	@Override
	public String kaydet() {
		// TODO Auto-generated method stub
		super.kaydet(getKasa());
		setKasa(new Kasa());
		return "OzellikleriDoldur.xhtml?faces-redirect=true";
	}

	@Override
	public void sil() {
		// TODO Auto-generated method stub
		super.sil(getKasa());
		setKasa(new Kasa());
	}

	@Override
	public void guncelle() {
		// TODO Auto-generated method stub
		super.guncelle(getKasa());
		setKasa(new Kasa());
	}
	public List<Kasa> getListeKasa (){
		EntityManager em = EntityUtil.getEntityManager();
		return em.createQuery("from Kasa").getResultList();
	}

	public Kasa getKasa() {
		return kasa;
	}

	public void setKasa(Kasa kasa) {
		this.kasa = kasa;
	}
	

}
