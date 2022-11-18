package com.torino.gestionecorsi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.torino.gestionecorsi.businesscomponent.facade.AdminFacade;
import com.torino.gestionecorsi.businesscomponent.model.Corsista;
import com.torino.gestionecorsi.businesscomponent.model.CorsoCorsista;

@WebServlet("/inserisciCorsista")
public class InserisciCorsista extends HttpServlet {

	private static final long serialVersionUID = -2288777798310656724L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String nomecorsista= request.getParameter("nomecorsista");
		 String cognomecorsista = request.getParameter("cognomecorsista");
		 long codcorso = Long.valueOf(request.getParameter("codcorso"));
		 boolean precedentiformativi = request.getParameter("precentiformativitrue")!=null?true:false;
		 
		 Corsista corsista = new Corsista();
		 corsista.setNome(nomecorsista);
		 corsista.setCognome(cognomecorsista);
		 corsista.setPrecedentiformativi(precedentiformativi);
		 try {
			 AdminFacade.getInstance().create(corsista);
			 CorsoCorsista corcor = new CorsoCorsista();
			 corcor.setCodCorso(codcorso);
			 corcor.setCodCorsista(corsista.getCodcorsista());
			 AdminFacade.getInstance().create(corcor);
			 System.out.println(corsista.getCodcorsista());
			 request.setAttribute("corsista", corsista);
			 request.setAttribute("codcorso", new Long(codcorso));
			 response.sendRedirect("utilities/confermaInserimentoCorsista.jsp");
		 }catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e.getMessage());
			}
	}

}
