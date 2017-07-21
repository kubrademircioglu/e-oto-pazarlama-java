package com.epazarlama.otopazarlama.util;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

public class IlanIslemleri extends Islemler implements StandartIslemler {

	private Araclar ilan = new Araclar();
	private Araclar ilanduzenle = new Araclar();
	private ResimIslemleri resimIslemleri = new ResimIslemleri();

	private String Marka_Adi;
	private String Seri_Adi;
	private String Vites_Adi;
	private String Yakit_Adi;
	private String Kasa_Adi;
	private String Renk_Adi;
	private String Kullanici_Adi;
	private Long Mark_ID;
	private Long maxFiyat = 0L;
	private Long KM = 0L;
	private Long minFiyat = 0L;
	private Long maxKM = 0L;
	private List<Seri> SeriListesi = new ArrayList<Seri>();

	public void filtrele() {

		List<Araclar> filtreliIlanlar = new ArrayList<Araclar>();

		List<Araclar> tumIlanlar = getListIlanlar();
		List<Araclar> markaIlanlar =new ArrayList<Araclar>();
		List<Araclar> seriIlanlar =new ArrayList<Araclar>();
		List<Araclar> kmIlanlar =new ArrayList<Araclar>();
		List<Araclar> fiyatIlanlar =new ArrayList<Araclar>();
		
		
		for (Araclar araclar : tumIlanlar) {
			if(araclar.getMarka().getMarka_Adi().equals(Marka_Adi)){
				markaIlanlar.add(araclar);
			}
		}
		
		for (Araclar araclar : markaIlanlar) {
			if(araclar.getSeri().getSeri_Adi().equals(Seri_Adi)){
				seriIlanlar.add(araclar);
			}
		}

		for (Araclar araclar : tumIlanlar) {
			if(Long.parseLong(araclar.getKM())<=maxKM ){
				kmIlanlar.add(araclar);
			}
		}
		
		for (Araclar araclar : tumIlanlar) {
			if(araclar.getIlan_Fiyati()<=maxFiyat ){
				fiyatIlanlar.add(araclar);
			}
		}
		
		if(seriIlanlar.size()>0){
			for (Araclar araclar : seriIlanlar) {
				filtreliIlanlar.add(araclar);
			}
		}
		if(markaIlanlar.size()>0){
			if(filtreliIlanlar.size()<=0){
				for (Araclar araclar : markaIlanlar) {
					filtreliIlanlar.add(araclar);
				}
			}
		}
		
		
	/*	for (Araclar araclar : tumIlanlar) {
			if (araclar.getMarka().getMarka_Adi().equals(Marka_Adi)) {
				if (araclar.getSeri().getSeri_Adi().equals(Seri_Adi)) {
					if (Long.parseLong(araclar.getKM(), 10) <= maxKM && Long.parseLong(araclar.getKM(), 10) >= KM) {
						if (araclar.getIlan_Fiyati() <= maxFiyat && araclar.getIlan_Fiyati() >= minFiyat) {
							filtreliIlanlar.add(araclar);
						}
						
					}
				}
			}
		}
*/
	}

	public String gitIlanVer() {
		Marka_Adi = "";
		Seri_Adi = "";
		Vites_Adi = "";
		Yakit_Adi = "";
		Kasa_Adi = "";
		Renk_Adi = "";
		ilan = new Araclar();
		resimIslemleri = new ResimIslemleri();

		return "kullaniciBean.giris.sorgu()";
	}

	public String kullaniciAdiGetir(String k_adi) {
		Kullanici_Adi = k_adi;
		return Kullanici_Adi;
	}

	@Override
	public String kaydet() {
		// TODO Auto-generated method stub

		for (Marka m : super.markaGetir(getMarka_Adi())) {
			ilan.setMarka(m);
			Mark_ID = m.getMarka_ID();
		}
		for (Seri m : super.seriGetir(getSeri_Adi())) {
			ilan.setSeri(m);
		}
		for (Vites m : super.vitesGetir(getVites_Adi())) {
			ilan.setVites(m);
		}
		for (Yakit m : super.yakitGetir(getYakit_Adi())) {
			ilan.setYakit(m);
		}
		for (Kasa m : super.kasaGetir(getKasa_Adi())) {
			ilan.setKasa(m);
		}
		for (Renk m : super.renkGetir(getRenk_Adi())) {
			ilan.setRenk(m);
		}
		for (Kullanicilar m : super.kullaniciGetir(Kullanici_Adi)) {
			ilan.setKullanici(m);

			System.out.println(m.getKullanici_Adi());
		}

		
		Date date = new Date();
		ilan.setIlan_Tarihi(date);

		super.kaydet(ilan);

		ilan = new Araclar();
		Marka_Adi = new String();
		Seri_Adi = new String();
		Vites_Adi = new String();
		Yakit_Adi = new String();
		Kasa_Adi = new String();
		Renk_Adi = new String();
		Kullanici_Adi = new String();
		return "IlanEkle.xhtml?faces-redirect=true";

	}

	@Override
	public void sil() {
		// TODO Auto-generated method stub
		super.sil(ilan);
		ilan = new Araclar();
		setMarka_Adi(new String());
		setSeri_Adi(new String());
		setVites_Adi(new String());
		setYakit_Adi(new String());
		setKasa_Adi(new String());
		setRenk_Adi(new String());
		setKullanici_Adi(new String());

	}

	@Override
	public void guncelle() {
		// TODO Auto-generated method stub

		for (Marka m : super.markaGetir(getMarka_Adi())) {
			ilanduzenle.setMarka(m);
			Mark_ID = m.getMarka_ID();
		}
		for (Seri m : super.seriGetir(getSeri_Adi())) {
			ilanduzenle.setSeri(m);
		}
		for (Vites m : super.vitesGetir(getVites_Adi())) {
			ilanduzenle.setVites(m);
		}
		for (Yakit m : super.yakitGetir(getYakit_Adi())) {
			ilanduzenle.setYakit(m);
		}
		for (Kasa m : super.kasaGetir(getKasa_Adi())) {
			ilanduzenle.setKasa(m);
		}
		for (Renk m : super.renkGetir(getRenk_Adi())) {
			ilanduzenle.setRenk(m);
		}
		for (Kullanicilar m : super.kullaniciGetir(Kullanici_Adi)) {
			ilanduzenle.setKullanici(m);

			System.out.println(m.getKullanici_Adi());
		}

		super.guncelle(ilanduzenle);
		ilanduzenle = new Araclar();
		setMarka_Adi(new String());
		setSeri_Adi(new String());
		setVites_Adi(new String());
		setYakit_Adi(new String());
		setKasa_Adi(new String());
		setRenk_Adi(new String());
		setKullanici_Adi(new String());

	}

	public List<Araclar> getListIlanlar() {
		try {
			EntityManager em = EntityUtil.getEntityManager();
			System.out.println("Try bölümü");
			List<Araclar> la = em.createQuery("from Araclar").getResultList();
			for (Araclar araclar : la) {
				System.out.println("------>" + araclar.getDurum());
			}
			return la;
		} catch (Exception e) {
			System.out.println("Catch bölümü");
			return null;
		}

	}

	public List<Araclar> getListKullaniciIlanlari(Kullanicilar kullanici) {
		try {
			EntityManager em = EntityUtil.getEntityManager();

			List<Araclar> la = em.createQuery("from Araclar Where Kullanici_Kullanici_ID =:k")
					.setParameter("k", kullanici.getKullanici_ID()).getResultList();

			return la;
		} catch (Exception e) {
			System.out.println("Catch bölümü");
			return null;
		}

	}

	public List<Seri> getListSeriler() {
		System.out.println("-------------------------->>>>>" + Mark_ID);
		System.out.println("-------------------------->>>>>" + Marka_Adi);
		if (Mark_ID == null) {
			Mark_ID = 1L;
		}
		EntityManager em = EntityUtil.getEntityManager(); // Query hatalý
															// olabilir.
		return em.createQuery("from Seri").getResultList();
		// where Marka_Marka_ID =:m ").setParameter("m",
		// Mark_ID).getResultList();
	}

	public void onMarkaChange() {
		if (Marka_Adi != null && !Marka_Adi.equals("")) {
			for (Marka m : super.markaGetir(Marka_Adi)) {
				ilan.setMarka(m);
				Mark_ID = m.getMarka_ID();
			}
			EntityManager em = EntityUtil.getEntityManager(); // Query hatalý
																// olabilir.
			SeriListesi = em.createQuery("from Seri where Marka_Marka_ID =:m ").setParameter("m", Mark_ID)
					.getResultList();
		}

	}

	public Araclar getIlan() {
		return ilan;
	}

	public void setIlan(Araclar ilan) {
		this.ilan = ilan;
	}

	public String getMarka_Adi() {
		return Marka_Adi;
	}

	public void setMarka_Adi(String marka_Adi) {
		Marka_Adi = marka_Adi;
	}

	public String getSeri_Adi() {
		return Seri_Adi;
	}

	public void setSeri_Adi(String seri_Adi) {
		Seri_Adi = seri_Adi;
	}

	public String getVites_Adi() {
		return Vites_Adi;
	}

	public void setVites_Adi(String vites_Adi) {
		Vites_Adi = vites_Adi;
	}

	public String getYakit_Adi() {
		return Yakit_Adi;
	}

	public void setYakit_Adi(String yakit_Adi) {
		Yakit_Adi = yakit_Adi;
	}

	public String getKasa_Adi() {
		return Kasa_Adi;
	}

	public void setKasa_Adi(String kasa_Adi) {
		Kasa_Adi = kasa_Adi;
	}

	public String getRenk_Adi() {
		return Renk_Adi;
	}

	public void setRenk_Adi(String renk_Adi) {
		Renk_Adi = renk_Adi;
	}

	public String getKullanici_Adi() {
		return Kullanici_Adi;
	}

	public void setKullanici_Adi(String kullanici_Adi) {
		Kullanici_Adi = kullanici_Adi;
	}

	public Long getMark_ID() {
		return Mark_ID;
	}

	public void setMark_ID(Long mark_ID) {
		Mark_ID = mark_ID;
	}

	public List<Seri> getSeriListesi() {
		return SeriListesi;
	}

	public void setSeriListesi(List<Seri> seriListesi) {
		SeriListesi = seriListesi;
	}

	public ResimIslemleri getResimIslemleri() {
		return resimIslemleri;
	}

	public void setResimIslemleri(ResimIslemleri resimIslemleri) {
		this.resimIslemleri = resimIslemleri;
	}

	public Araclar getIlanduzenle() {
		return ilanduzenle;
	}

	public void setIlanduzenle(Araclar ilanduzenle) {
		this.ilanduzenle = ilanduzenle;
	}

	public Long getKM() {
		return KM;
	}

	public void setKM(Long kM) {
		KM = kM;
	}

	public Long getMaxFiyat() {
		return maxFiyat;
	}

	public void setMaxFiyat(Long maxFiyat) {
		this.maxFiyat = maxFiyat;
	}

	public Long getMaxKM() {
		return maxKM;
	}

	public void setMaxKM(Long maxKM) {
		this.maxKM = maxKM;
	}

	public Long getMinFiyat() {
		return minFiyat;
	}

	public void setMinFiyat(Long minFiyat) {
		this.minFiyat = minFiyat;
	}

}
