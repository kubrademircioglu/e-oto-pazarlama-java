package com.epazarlama.otopazarlama.util;

import java.util.List;

import javax.persistence.EntityManager;

public class RenkIslemleri extends Islemler implements StandartIslemler {

	private Renk renk = new Renk();

	@Override
	public String kaydet() {
		// TODO Auto-generated method stub
		super.kaydet(renk);
		renk = new Renk();
		return "OzellikleriDoldur.xhtml?faces-redirect=true";
	}

	@Override
	public void sil() {
		// TODO Auto-generated method stub
		super.sil(renk);
		renk = new Renk();
	}

	@Override
	public void guncelle() {
		// TODO Auto-generated method stub
		super.guncelle(renk);
		renk = new Renk();
	}

	public List<Renk> getListRenk() {
		EntityManager em = EntityUtil.getEntityManager();
		return em.createQuery("from Renk").getResultList();
	}

	public Renk getRenk() {
		return renk;
	}

	public void setRenk(Renk renk) {
		this.renk = renk;
	}

}
