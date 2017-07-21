package com.epazarlama.otopazarlama.util;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
 
@ManagedBean(name = "dfView")
public class DFView {
         
    public void showMessage(String baslik, String icerik ) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, baslik, icerik);
         
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
    
    public void goster(String baslik,String mesaj) {
        addMessage(baslik, mesaj);
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    
    public void mesajSayfasi() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        RequestContext.getCurrentInstance().openDialog("mesajGonder", options, null);
    }
    
    public void mesaj() {
    	RequestContext context = RequestContext.getCurrentInstance();
    	context.execute("PF('mesajGonder').show();");
    	
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        RequestContext.getCurrentInstance().openDialog("mesajGonder", options, null);
    }
    
    
    
}