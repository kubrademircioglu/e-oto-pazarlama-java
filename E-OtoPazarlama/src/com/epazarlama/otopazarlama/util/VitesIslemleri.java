package com.epazarlama.otopazarlama.util;

import java.util.List;

import javax.persistence.EntityManager;

public class VitesIslemleri extends Islemler implements StandartIslemler {

	private Vites vites = new Vites();

	@Override
	public String kaydet() {
		// TODO Auto-generated method stub
		super.kaydet(vites);
		vites = new Vites();
		return "OzellikleriDoldur.xhtml?faces-redirect=true";
	}

	@Override
	public void sil() {
		// TODO Auto-generated method stub
		super.sil(vites);
		vites = new Vites();
	}

	@Override
	public void guncelle() {
		// TODO Auto-generated method stub
		super.guncelle(vites);
		vites = new Vites();
	}

	public List<Vites> getListVites() {
		EntityManager em = EntityUtil.getEntityManager();
		return em.createQuery("from Vites").getResultList();
	}

	public Vites getVites() {
		return vites;
	}

	public void setVites(Vites vites) {
		this.vites = vites;
	}

}
