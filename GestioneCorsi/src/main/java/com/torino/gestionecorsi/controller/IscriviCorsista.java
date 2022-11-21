package com.torino.gestionecorsi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.torino.gestionecorsi.businesscomponent.CorsoCorsistaBC;
import com.torino.gestionecorsi.businesscomponent.facade.AdminFacade;
import com.torino.gestionecorsi.businesscomponent.model.Corsista;
import com.torino.gestionecorsi.businesscomponent.model.Corso;
import com.torino.gestionecorsi.businesscomponent.model.CorsoCorsista;
import com.torino.gestionecorsi.businesscomponent.utilities.Report;
import com.torino.gestionecorsi.businesscomponent.utilities.Validator;

/**
 * Servlet implementation class IscriviCorsista
 */
@WebServlet("/iscriviCorsista")
public class IscriviCorsista extends HttpServlet {
	private static final long serialVersionUID = -8815447927953556772L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		long codCorsista = Long.valueOf(request.getParameter("codcorsista"));
		long codCorso = Long.valueOf(request.getParameter("codcorso"));
		
		try {
			Corsista corsista = AdminFacade.getInstance().findCorsistaByCod(codCorsista);
			Corso corso = AdminFacade.getInstance().findCorsoByCod(codCorso);
			Boolean check1 = Validator.getFactory().validate(corsista);
			Boolean check2 = Validator.getFactory().validate(corso);
			Corso[]corsiCorsista = AdminFacade.getInstance().getCorsiByCorsista(corsista);
			boolean contains= false;
			for(int i=0;i<corsiCorsista.length && !contains;i++) {
				if(corsiCorsista[i].getCodcorso()==corso.getCodcorso())
					contains=true;
			}
			if(check1&&check2&&!contains) {
				CorsoCorsista corcorsista = new CorsoCorsista();
				corcorsista.setCodCorso(codCorso);
				corcorsista.setCodCorsista(codCorsista);
				AdminFacade.getInstance().create(corcorsista);
				response.sendRedirect("utilities/show.jsp");
			}else {
				session.setAttribute("checkCorsista",check1);
				session.setAttribute("checkCorso", check2);
				 response.sendRedirect("utilities/errorevalidazione.jsp");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
		
		
	}

}
