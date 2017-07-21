package com.epazarlama.otopazarlama.util;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class PhaseList implements PhaseListener{

	@Override
	public void afterPhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		 System.out.println("afterPhase() calisti");
	        FacesContext fc = arg0.getFacesContext();
	        String page = fc.getViewRoot().getViewId();
	        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
	        System.out.println("session.getId() = " +session.getId());
	        System.out.println("page = "+page);  
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		 System.out.println("beforePhase() calisti");
	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		System.out.println("getPhaseId() calisti");
        return PhaseId.RESTORE_VIEW;
	}

}
