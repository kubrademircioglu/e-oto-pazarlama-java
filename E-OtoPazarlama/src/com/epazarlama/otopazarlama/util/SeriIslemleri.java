package com.epazarlama.otopazarlama.util;

import java.util.List;

import javax.persistence.EntityManager;

public class SeriIslemleri extends Islemler implements StandartIslemler {

	private Seri seri = new Seri();
	private String M_Adi;

	@Override
	public String kaydet() {
		// TODO Auto-generated method stub
		System.out.println("------------------------->>>>>>>>>>>>>>" + M_Adi);
		for (Marka m : super.markaGetir(M_Adi)) {
			System.out.println("------------------------->>>>>>>>>>>>>>" + m.getMarka_Adi());
			seri.setMarka(m);
		}

		super.kaydet(seri);
		seri = new Seri();
		return "OzellikleriDoldur.xhtml?faces-redirect=true";
	}

	@Override
	public void sil() {
		// TODO Auto-generated method stub
		super.sil(seri);
		seri = new Seri();
	}

	@Override
	public void guncelle() {
		// TODO Auto-generated method stub
		super.guncelle(seri);
		seri = new Seri();

	}

	public List<Seri> getListSeriler() {
		for (Marka m : super.markaGetir(getM_Adi())) {
			seri.setMarka(m);
		}
		EntityManager em = EntityUtil.getEntityManager(); // Query hatalý olabilir.
		return em.createQuery("from Seri where Marka =: m ").setParameter("m", seri.getMarka()).getResultList();
	}

	public Seri getSeri() {
		return seri;
	}

	public void setSeri(Seri seri) {
		this.seri = seri;
	}

	public String getM_Adi() {
		return M_Adi;
	}

	public void setM_Adi(String m_Adi) {
		M_Adi = m_Adi;
	}

}
