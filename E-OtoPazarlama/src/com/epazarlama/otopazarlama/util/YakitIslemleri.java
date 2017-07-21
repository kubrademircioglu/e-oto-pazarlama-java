package com.epazarlama.otopazarlama.util;

import java.util.List;

import javax.persistence.EntityManager;

public class YakitIslemleri extends Islemler implements StandartIslemler {

	private Yakit yakit = new Yakit();
	@Override
	public String kaydet() {
		// TODO Auto-generated method stub
		super.kaydet(yakit);
		yakit=new Yakit();
		return "OzellikleriDoldur.xhtml?faces-redirect=true";
	}

	@Override
	public void sil() {
		// TODO Auto-generated method stub
		super.sil(yakit);
		yakit = new Yakit();
	}

	@Override
	public void guncelle() {
		// TODO Auto-generated method stub
		super.guncelle(yakit);
		yakit = new Yakit();
	}

	public List<Yakit> getListYakit(){
		EntityManager em = EntityUtil.getEntityManager();
		return em.createQuery("from Yakit").getResultList();
	}
	
	public Yakit getYakit() {
		return yakit;
	}

	public void setYakit(Yakit yakit) {
		this.yakit = yakit;
	}

}
