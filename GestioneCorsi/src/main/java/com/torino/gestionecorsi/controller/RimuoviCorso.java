package com.torino.gestionecorsi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.torino.gestionecorsi.businesscomponent.facade.AdminFacade;
import com.torino.gestionecorsi.businesscomponent.model.Corso;

@WebServlet("/rimuoviCorso")
public class RimuoviCorso extends HttpServlet {

	private static final long serialVersionUID = 9112435601153320197L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String codcorsoS = request.getParameter("cod");
			
			if (codcorsoS != null) {
				long codcorso = Long.valueOf(codcorsoS);
				Corso c = new Corso();
				c.setCodcorso(codcorso);
				AdminFacade.getInstance().delete(c);
				response.sendRedirect("utilities/corsi.jsp");
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}

}
