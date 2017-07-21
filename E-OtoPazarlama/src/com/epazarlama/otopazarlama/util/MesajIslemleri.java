package com.epazarlama.otopazarlama.util;

import java.util.List;

import javax.persistence.EntityManager;

public class MesajIslemleri extends Islemler implements StandartIslemler {

	private Mesajlar mesaj = new Mesajlar();
	private Mesajlar yanitlar = new Mesajlar();
	private String alici;
	private String gonderici;
	private String icerik = "";
	private String yanit = "";

	public String mesajKaydet(String alan, String gonderen, String icerik) {
		alici = alan;

		gonderici = gonderen;
		if (alici == "" || gonderici == "") {
			mesaj = new Mesajlar();
			alici = "";
			gonderici = "";
			icerik = "";
			yanit = "";
			return "KayitOl-GirisYap.xhtml?faces-redirect=true";
		} else {
			System.out.println("---------------**************** mesaj kaydet");
			mesaj.setMesajIcerik(icerik);
			System.out.println("--- alici = " + alici);
			System.out.println("--- gonderici = " + gonderici);
			System.out.println("--- içerik = " + mesaj.getMesajIcerik());
			kaydet();
			mesaj = new Mesajlar();
			alici = "";
			gonderici = "";
			icerik = "";
			yanit = "";
			return "KullaniciBilgisi.xhtml?faces-redirect=true";
		}

	}

	@Override
	public String kaydet() {
		// TODO Auto-generated method stub
		for (Kullanicilar a : super.kullaniciGetir(getAlici())) {
			mesaj.setAlici(a);
		}
		for (Kullanicilar g : super.kullaniciGetir(getGonderici())) {
			mesaj.setGonderici(g);
		}
		if (!mesaj.getAlici().equals(null) && !mesaj.getGonderici().equals(null)) {
			super.kaydet(mesaj);
			mesaj = new Mesajlar();
			setAlici(new String());
			setGonderici(new String());
		}
		return "IlanBilgisi.xhtml?faces-redirect=true";
	}

	@Override
	public void sil() {
		// TODO Auto-generated method stub
		super.sil(mesaj);
		mesaj = new Mesajlar();
	}

	@Override
	public void guncelle() {
		// TODO Auto-generated method stub
		super.guncelle(mesaj);
		mesaj = new Mesajlar();

	}

	public List<Mesajlar> getLisMesajlarim(Kullanicilar kullanici) {
		EntityManager em = EntityUtil.getEntityManager();
		System.out.println("---------******-----------" + kullanici.getKullanici_ID());
		return em.createQuery("from Mesajlar Where alici_Kullanici_ID=:k")
				.setParameter("k", kullanici.getKullanici_ID()).getResultList();

	}

	public List<Mesajlar> getLisGelenMesajlar(Kullanicilar kullanici) {
		EntityManager em = EntityUtil.getEntityManager();
		System.out.println("---------******-----------" + kullanici.getKullanici_ID());
		return em.createQuery("from Mesajlar Where gonderici_Kullanici_ID=:k")
				.setParameter("k", kullanici.getKullanici_ID()).getResultList();

	}

	public Mesajlar getMesaj() {
		return mesaj;
	}

	public void setMesaj(Mesajlar mesaj) {
		this.mesaj = mesaj;
	}

	public String getAlici() {
		return alici;
	}

	public void setAlici(String alici) {
		this.alici = alici;
	}

	public String getGonderici() {
		return gonderici;
	}

	public void setGonderici(String gonderici) {
		this.gonderici = gonderici;
	}

	public String getIcerik() {
		return icerik;
	}

	public void setIcerik(String icerik) {
		this.icerik = icerik;
	}

	public String getYanit() {
		return yanit;
	}

	public void setYanit(String yanit) {
		this.yanit = yanit;
	}

	public Mesajlar getYanitlar() {
		return yanitlar;
	}

	public void setYanitlar(Mesajlar yanitlar) {
		this.yanitlar = yanitlar;
	}

}
