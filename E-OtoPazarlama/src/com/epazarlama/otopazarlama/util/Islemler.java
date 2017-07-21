package com.epazarlama.otopazarlama.util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

public class Islemler {

	public void kaydet(Object veri) {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(veri);
		em.getTransaction().commit();
	}

	public void sil(Object veri) {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(veri);
		em.getTransaction().commit();
	}

	public void guncelle(Object veri) {
		EntityManager em = EntityUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(veri);
		em.getTransaction().commit();
	}

	List<Kullanicilar> kullaniciGetir(String k_adi) {
		List<Kullanicilar> kullanici = new ArrayList<Kullanicilar>();
		try {
			EntityManager em = EntityUtil.getEntityManager();
			em.getTransaction().begin();
			kullanici = em.createQuery("from Kullanicilar where Kullanici_Adi =:ad").setParameter("ad", k_adi).getResultList();
			for(Kullanicilar k : kullanici){
				System.out.println("-----ii---k.adi------->>>>>" + k.getKullanici_Adi());
				System.out.println("-----ii----k.id------>>>>>" + k.getKullanici_ID());
			}
			
			em.getTransaction().commit();
			return kullanici;
		} catch (Exception e) {
			kullanici.add(null);
			return kullanici;
		}

	}

	List<Araclar> ilanGetir(Long i_no) {
		List<Araclar> ilan = new ArrayList<Araclar>();
		try {
			EntityManager em = EntityUtil.getEntityManager();
			em.getTransaction().begin();
			ilan = em.createQuery("from Araclar where Arac_ID =:id").setParameter("id", i_no).getResultList();
			em.getTransaction().commit();
			return ilan;
		} catch (Exception e) {
			ilan.add(null);
			return ilan;
		}

	}
	List<Marka> markaGetir(String m_adi) {
		List<Marka> marka = new ArrayList<Marka>();
		try {
			EntityManager em = EntityUtil.getEntityManager();
			em.getTransaction().begin();
			marka = em.createQuery("from Marka where Marka_Adi =:ad").setParameter("ad",m_adi).getResultList();
			em.getTransaction().commit();
			return marka;
		} catch (Exception e) {
			marka.add(null);
			return marka;
		}

	}
	
	List<Seri> seriGetir(String s_adi) {
		List<Seri> seri = new ArrayList<Seri>();
		try {
			EntityManager em = EntityUtil.getEntityManager();
			em.getTransaction().begin();
			seri = em.createQuery("from Seri where Seri_Adi =:ad").setParameter("ad",s_adi).getResultList();
			em.getTransaction().commit();
			return seri;
		} catch (Exception e) {
			seri.add(null);
			return seri;
		}

	}
	
	List<Vites> vitesGetir(String v_adi) {
		List<Vites> Vites = new ArrayList<Vites>();
		try {
			EntityManager em = EntityUtil.getEntityManager();
			em.getTransaction().begin();
			Vites = em.createQuery("from Vites where Vites_Turu =:ad").setParameter("ad",v_adi).getResultList();
			em.getTransaction().commit();
			return Vites;
		} catch (Exception e) {
			Vites.add(null);
			return Vites;
		}

	}
	
	List<Yakit> yakitGetir(String y_adi) {
		List<Yakit> Yakit = new ArrayList<Yakit>();
		try {
			EntityManager em = EntityUtil.getEntityManager();
			em.getTransaction().begin();
			Yakit = em.createQuery("from Yakit where Yakit_Turu =:ad").setParameter("ad",y_adi).getResultList();
			em.getTransaction().commit();
			return Yakit;
		} catch (Exception e) {
			Yakit.add(null);
			return Yakit;
		}

	}
	
	List<Kasa> kasaGetir(String k_adi) {
		List<Kasa> Kasa = new ArrayList<Kasa>();
		try {
			EntityManager em = EntityUtil.getEntityManager();
			em.getTransaction().begin();
			Kasa = em.createQuery("from Kasa where KasaTipi =:ad").setParameter("ad",k_adi).getResultList();
			em.getTransaction().commit();
			return Kasa;
		} catch (Exception e) {
			Kasa.add(null);
			return Kasa;
		}

	}
	List<Renk> renkGetir(String r_adi) {
		List<Renk> Renk = new ArrayList<Renk>();
		try {
			EntityManager em = EntityUtil.getEntityManager();
			em.getTransaction().begin();
			Renk = em.createQuery("from Renk where Renk_Adi =:ad").setParameter("ad",r_adi).getResultList();
			em.getTransaction().commit();
			return Renk;
		} catch (Exception e) {
			Renk.add(null);
			return Renk;
		}

	}

}
