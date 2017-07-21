package com.epazarlama.otopazarlama.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;

import javax.persistence.EntityManager;

import org.apache.commons.io.FilenameUtils;

import org.primefaces.model.UploadedFile;

public class ResimIslemleri extends Islemler implements StandartIslemler {

	private Resimler resim = new Resimler();
	private Long i_ID = 1L;
	private byte[] bytes;
	private UploadedFile uploadedFile;
	private BufferedImage img = null;
	private String resimYolu = "resources/images/";
	private Long r_ID=1L;
	
	public BufferedImage getResimGetir(){
		File file = new File("C://java/eclipse/SabahYeni/E-OtoPazarlama/WebContent/resources/images/1_1.png");
		BufferedImage bi;
		try {
			bi = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("------catch");
			bi=null;
			e.printStackTrace();
		}
		return bi;
	}

	public String resimGetir(Araclar araclar){
		String resimyolu=" ";
		try{
			EntityManager em = EntityUtil.getEntityManager();
			List<Resimler> listResim = em.createQuery("from resimler where ilan_Arac_ID=:i").setParameter("i", araclar.getIlan_ID()).getResultList();
			for (Resimler resimler : listResim) {
				resimyolu = resimler.getResim_Yolu();
				break;
			}
		}
		catch(Exception e){
			resimyolu = "bos.gif";
		}
		if(resimyolu == " "){
			resimyolu = "bos.gif";
		}
		System.out.println("---------------" + resimyolu);
		return resimyolu;
	}
	public void ilanIDGetir() {
		System.out.println("----------ilanIDGetir = " );
		try{
			EntityManager em = EntityUtil.getEntityManager();
			List<Araclar> listA = em.createQuery("from Araclar").getResultList();
			for (Araclar a : listA) {
				i_ID = a.getIlan_ID();
				resim.setIlan(a);
			}
			
		}
		catch(Exception e){
			i_ID = 1L;
		}
		
		System.out.println("iid = " + i_ID);
		System.out.println("rid = " + r_ID);
	}

	public void resimIDGetir() { // maksimum resimID getirir
		System.out.println("----------resimIDGetir = " );
		try{
			EntityManager em = EntityUtil.getEntityManager();
			List<Resimler> listR = em.createQuery("from Resimler").getResultList();
			for (Resimler r : listR) {
				r_ID = r.getResim_ID() + 1L;
				System.out.println("----------" + r.getResim_ID());
				System.out.println("-------" + r_ID);
			}
		}
		catch(Exception e){
			r_ID = 1L;
		}
		
		System.out.println("iid = " + i_ID);
		System.out.println("rid = " + r_ID);
	}

	public void submit() {
		try {

			ilanIDGetir();
			resimIDGetir();
			System.out.println("-----------Submit Giriþ file name "  );
System.out.println("-----------Submit Giriþ file name " + uploadedFile.getFileName() );
			String fileName = FilenameUtils.getName(uploadedFile.getFileName());
			System.out.println("------------ submit2");
			String contentType = uploadedFile.getContentType();
			System.out.println("------------ submit3");
			bytes = uploadedFile.getContents();
			System.out.println("------------ submit4");
			img = ImageIO.read(new ByteArrayInputStream(bytes));
System.out.println("------------ submit5");
			resim.setResim_Yolu(i_ID + "_" + r_ID + ".png");
			System.out.println("iid = " + i_ID);
			System.out.println("rid = " + r_ID);
			System.out.println("----" + resim.getResim_Yolu());

			File outputfile = new File("C://java/eclipse/SabahYeni/E-OtoPazarlama/WebContent/resources/images/" + resim.getResim_Yolu());
			ImageIO.write(img, "png", outputfile);
         
			kaydet();

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
					String.format("File '%s' of type '%s' successfully uploaded!", fileName, contentType)));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(String.format("Yükleme Sýrasýnda Bir Hata Oluþtu!")));
		}

	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	@Override
	public String kaydet() {
		// TODO Auto-generated method stub

		for (Araclar i : super.ilanGetir(i_ID)) {
			resim.setIlan(i);

		}

		super.kaydet(getResim());
		setResim(new Resimler());
		return "IlanEkle.xhtml?faces-redirect=true";
	}

	@Override
	public void sil() {
		// TODO Auto-generated method stub
		super.sil(getResim());
		setResim(new Resimler());
	}

	@Override
	public void guncelle() {
		// TODO Auto-generated method stub
		super.guncelle(getResim());
		setResim(new Resimler());
	}

	public List<Resimler> getListResimler() {
		EntityManager em = EntityUtil.getEntityManager(); // Query hatalý
															// olabilir.
		IlanIslemleri i = new IlanIslemleri();
		i_ID = i.getIlan().getIlan_ID();
		System.out.println("---------------" + i_ID);
		return em.createQuery("from Resimler where ilan_Arac_ID =:id").setParameter("id", i_ID).getResultList();
	}

	public Resimler getResim() {
		return resim;
	}

	public void setResim(Resimler resim) {
		this.resim = resim;
	}

	public Long getI_ID() {
		return i_ID;
	}

	public void setI_ID(Long i_ID) {
		this.i_ID = i_ID;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public String getResimYolu() {
		return resimYolu;
	}

	public void setResimYolu(String resimYolu) {
		this.resimYolu = resimYolu;
	}

	public Long getR_ID() {
		return r_ID;
	}

	public void setR_ID(Long r_ID) {
		this.r_ID = r_ID;
	}

}
