package com.epazarlama.otopazarlama.util;

public class IlanBean {

	private IlanIslemleri ilanIslemleri = new IlanIslemleri();
	private KasaIslemleri kasaIslemleri = new KasaIslemleri();
	private MarkaIslemleri markaIslemleri = new MarkaIslemleri();
	private RenkIslemleri renkIslemleri = new RenkIslemleri();
	private ResimIslemleri resimIslemleri = new ResimIslemleri();
	private SeriIslemleri seriIslemleri = new SeriIslemleri();
	private VitesIslemleri vitesIslemleri = new VitesIslemleri();
	private YakitIslemleri yakitIslemleri = new YakitIslemleri();
	private Araclar arac;

	public String gitAnasayfa() {
		ilanIslemleri = new IlanIslemleri();
		kasaIslemleri = new KasaIslemleri();
		markaIslemleri = new MarkaIslemleri();
		renkIslemleri = new RenkIslemleri();
		seriIslemleri = new SeriIslemleri();
		vitesIslemleri = new VitesIslemleri();
		yakitIslemleri = new YakitIslemleri();
		resimIslemleri = new ResimIslemleri();
		arac = null;

		return "index.xhtml?faces-redirect=true";
	}

	public IlanIslemleri getIlanIslemleri() {
		return ilanIslemleri;
	}

	public void setIlanIslemleri(IlanIslemleri ilanIslemleri) {
		this.ilanIslemleri = ilanIslemleri;
	}

	public KasaIslemleri getKasaIslemleri() {
		return kasaIslemleri;
	}

	public void setKasaIslemleri(KasaIslemleri kasaIslemleri) {
		this.kasaIslemleri = kasaIslemleri;
	}

	public MarkaIslemleri getMarkaIslemleri() {
		return markaIslemleri;
	}

	public void setMarkaIslemleri(MarkaIslemleri markaIslemleri) {
		this.markaIslemleri = markaIslemleri;
	}

	public RenkIslemleri getRenkIslemleri() {
		return renkIslemleri;
	}

	public void setRenkIslemleri(RenkIslemleri renkIslemleri) {
		this.renkIslemleri = renkIslemleri;
	}

	public ResimIslemleri getResimIslemleri() {
		return resimIslemleri;
	}

	public void setResimIslemleri(ResimIslemleri resimIslemleri) {
		this.resimIslemleri = resimIslemleri;
	}

	public SeriIslemleri getSeriIslemleri() {
		return seriIslemleri;
	}

	public void setSeriIslemleri(SeriIslemleri seriIslemleri) {
		this.seriIslemleri = seriIslemleri;
	}

	public VitesIslemleri getVitesIslemleri() {
		return vitesIslemleri;
	}

	public void setVitesIslemleri(VitesIslemleri vitesIslemleri) {
		this.vitesIslemleri = vitesIslemleri;
	}

	public YakitIslemleri getYakitIslemleri() {
		return yakitIslemleri;
	}

	public void setYakitIslemleri(YakitIslemleri yakitIslemleri) {
		this.yakitIslemleri = yakitIslemleri;
	}

	public Araclar getArac() {
		return arac;
	}

	public void setArac(Araclar arac) {
		this.arac = arac;
		resimIslemleri.setI_ID(arac.getIlan_ID());
		ilanIslemleri.setIlan(arac);
	}
}
