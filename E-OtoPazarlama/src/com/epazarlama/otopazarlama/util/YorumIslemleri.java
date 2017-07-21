package com.epazarlama.otopazarlama.util;

public class YorumIslemleri extends Islemler implements StandartIslemler{

	private Yorumlar yorum = new Yorumlar();
	private String kullaniciadi;
	private Long ilanID;
	
	@Override
	public String kaydet() {
		// TODO Auto-generated method stub
		for (Kullanicilar k : super.kullaniciGetir(kullaniciadi)) {
			yorum.setKullanici(k);
		}
		for(Araclar i : super.ilanGetir(ilanID)){
			yorum.setIlan(i);
		}
		super.kaydet(yorum);
		yorum=new Yorumlar();
		kullaniciadi = new String();
		ilanID = new Long(0);
		return "index.xhtml?faces-redirect=true";
	}

	@Override
	public void sil() {
		// TODO Auto-generated method stub
		super.sil(yorum);
		yorum = new Yorumlar();
		
	}

	@Override
	public void guncelle() {
		// TODO Auto-generated method stub
		
		super.guncelle(yorum);
		yorum = new Yorumlar();
	}

	public Yorumlar getYorum() {
		return yorum;
	}

	public void setYorum(Yorumlar yorum) {
		this.yorum = yorum;
	}

	public String getKullaniciadi() {
		return kullaniciadi;
	}

	public void setKullaniciadi(String kullaniciadi) {
		this.kullaniciadi = kullaniciadi;
	}

	public Long getIlanID() {
		return ilanID;
	}

	public void setIlanID(Long ilanID) {
		this.ilanID = ilanID;
	}

}
