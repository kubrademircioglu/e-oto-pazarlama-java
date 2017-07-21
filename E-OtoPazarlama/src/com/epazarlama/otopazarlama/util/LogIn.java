package com.epazarlama.otopazarlama.util;

public class LogIn extends Islemler {

	private Kullanicilar kullanici = new Kullanicilar();
	private String kullaniciadi = null;
	private String parola = null;

	public String girisYap() {

		for (Kullanicilar kullanicilar : super.kullaniciGetir(kullaniciadi)) {

			if (kullanicilar.getKullanici_Adi().equals(kullaniciadi) && kullanicilar.getParola().equals(parola)) {
				System.out.println("--- " + kullanicilar.isKullaniciTuru());
				if (kullanicilar.isKullaniciTuru()) {
					kullanici = kullanicilar;
					kullaniciadi = kullanicilar.getKullanici_Adi();
					return "Admin";
				} else {
					kullanici = kullanicilar;
					kullaniciadi = kullanicilar.getKullanici_Adi();
					return "Kullanici";
				}
				
			}
		}
		kullaniciadi = null;
		parola = null;
		System.out.println("Hatalý");
		return "Hatali";
	}

	public Kullanicilar kullaniciBilgisi() {

		Kullanicilar k = new Kullanicilar();
		for (Kullanicilar kullanicilar : super.kullaniciGetir(kullaniciadi)) {
			k = kullanicilar;

		}
		return k;

	}


	public String sorgu(IlanBean ib) {
		if (kullaniciadi != null) {
			ib.gitAnasayfa();
			return "IlanEkle.xhtml";
		} else {

			return "KayitOl-GirisYap";
		}

	}

	public Kullanicilar getKullanici() {
		return kullanici;
	}

	public void setKullanici(Kullanicilar kullanici) {
		this.kullanici = kullanici;
	}

	public String getKullaniciadi() {
		return kullaniciadi;
	}

	public void setKullaniciadi(String kullaniciadi) {
		this.kullaniciadi = kullaniciadi;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

}
