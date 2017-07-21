package com.epazarlama.otopazarlama.util;

import java.util.List;

import javax.persistence.EntityManager;

public class KullaniciKaydet extends Islemler implements StandartIslemler{

	private Kullanicilar kullanici = new Kullanicilar();
	private Boolean kontrol=false;

	@Override
	public String kaydet() {
		System.out.println(kullanici.getKullanici_Adi());
		for (Kullanicilar k : super.kullaniciGetir(kullanici.getKullanici_Adi())) {
			kontrol = true;
		}
	if(kontrol == false){
			super.kaydet(kullanici);
			
		}
	else {
		System.out.println("Kullanici adi var.");
	}
		kullanici = new Kullanicilar();
		return "KayitOl-GirisYap.xhtml?faces-redirect=true";
	}

	@Override
	public void sil() {
		super.sil(kullanici);
		kullanici = new Kullanicilar();
	}

	@Override
	public void guncelle() {
		super.guncelle(kullanici);
		kullanici = new Kullanicilar();
	}
	
	public List<Kullanicilar> getListKullanici(){
		EntityManager em = EntityUtil.getEntityManager();
		return em.createQuery("from Kullanicilar").getResultList();
	}

	
	public Kullanicilar getKullanici() {
		return kullanici;
	}

	public void setKullanici(Kullanicilar kullanici) {
		this.kullanici = kullanici;
	}

	

	public Boolean getKontrol() {
		return kontrol;
	}

	public void setKontrol(Boolean kontrol) {
		this.kontrol = kontrol;
	}


	
}
