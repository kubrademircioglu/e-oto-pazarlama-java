package com.epazarlama.otopazarlama.util;

public class KullaniciBean {

	private KullaniciKaydet kullanicikaydet = new KullaniciKaydet();
	private LogIn giris = new LogIn();
	private YorumIslemleri yorumislemleri = new YorumIslemleri();
	private MesajIslemleri mesajislemleri = new MesajIslemleri();

	public String cikisYap(){
		kullanicikaydet = new KullaniciKaydet();
		giris = new LogIn();
		yorumislemleri = new YorumIslemleri();
		mesajislemleri = new MesajIslemleri();
		return "index.xhtml?faces-redirect=true";
	}
	
	public LogIn getGiris() {
		return giris;
	}

	public void setGiris(LogIn giris) {
		this.giris = giris;
	}

	public KullaniciKaydet getKullanicikaydet() {
		return kullanicikaydet;
	}

	public void setKullanicikaydet(KullaniciKaydet kullanicikaydet) {
		this.kullanicikaydet = kullanicikaydet;
	}

	public YorumIslemleri getYorumislemleri() {
		return yorumislemleri;
	}

	public void setYorumislemleri(YorumIslemleri yorumislemleri) {
		this.yorumislemleri = yorumislemleri;
	}

	public MesajIslemleri getMesajislemleri() {
		return mesajislemleri;
	}

	public void setMesajislemleri(MesajIslemleri mesajislemleri) {
		this.mesajislemleri = mesajislemleri;
	}

}
