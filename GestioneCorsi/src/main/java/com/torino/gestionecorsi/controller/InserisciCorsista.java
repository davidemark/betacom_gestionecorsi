package com.torino.gestionecorsi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.torino.gestionecorsi.businesscomponent.facade.AdminFacade;
import com.torino.gestionecorsi.businesscomponent.model.Corsista;
import com.torino.gestionecorsi.businesscomponent.model.Corso;
import com.torino.gestionecorsi.businesscomponent.model.CorsoCorsista;
import com.torino.gestionecorsi.businesscomponent.utilities.Validator;

@WebServlet("/inserisciCorsista")
public class InserisciCorsista extends HttpServlet {

	private static final long serialVersionUID = -2288777798310656724L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		 String nomecorsista= request.getParameter("nomecorsista");
		 String cognomecorsista = request.getParameter("cognomecorsista");
		 long codcorso = Long.valueOf(request.getParameter("codcorso"));
		 boolean precedentiformativi = request.getParameter("precedentiformativi").equals("true")?true:false;
		 
		 Corsista corsista = new Corsista();
		 corsista.setNome(nomecorsista);
		 System.out.println(nomecorsista);
		 corsista.setCognome(cognomecorsista);
		 corsista.setPrecedentiformativi(precedentiformativi);
		 try {
			 Corso corso = AdminFacade.getInstance().findCorsoByCod(codcorso);
			 boolean check1 = Validator.getFactory().validate(corsista);
			 boolean check2 = Validator.getFactory().validate(corso);
			 if(check1 && check2) {
				 
				 AdminFacade.getInstance().create(corsista);
				 CorsoCorsista corcor = new CorsoCorsista();
				 corcor.setCodCorso(codcorso);
				 corcor.setCodCorsista(corsista.getCodcorsista());
				 AdminFacade.getInstance().create(corcor);
				 System.out.println(corsista.getCodcorsista());
				 session.setAttribute("corsista", corsista);
				 session.setAttribute("codcorso", new Long(codcorso));
				 response.sendRedirect("utilities/confermaInserimentoCorsista.jsp");
			 }else {
				 response.sendRedirect("provaerrore.jsp");
			 }
		 }catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e.getMessage());
			}
	}

}
