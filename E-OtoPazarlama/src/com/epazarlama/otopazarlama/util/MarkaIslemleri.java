package com.epazarlama.otopazarlama.util;

import java.util.List;

import javax.persistence.EntityManager;

public class MarkaIslemleri extends Islemler implements StandartIslemler{
	
	private Marka marka = new Marka();
	

	@Override
	public String kaydet() {
		// TODO Auto-generated method stub
		super.kaydet(marka);
		marka = new Marka();
		return "OzellikleriDoldur.xhtml?faces-redirect=true";
	}

	@Override
	public void sil() {
		// TODO Auto-generated method stub
		super.sil(marka);
		marka = new Marka();
		
	}

	@Override
	public void guncelle() {
		// TODO Auto-generated method stub
		super.guncelle(marka);
		marka = new Marka();
	}
	
	public List<Marka> getListMarka(){
		EntityManager em = EntityUtil.getEntityManager();
		return em.createQuery("from Marka").getResultList();
	}

	public Marka getMarka() {
		return marka;
	}

	public void setMarka(Marka marka) {
		this.marka = marka;
	}

}
