package com.torino.gestionecorsi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.torino.gestionecorsi.businesscomponent.utilities.Login;


@WebServlet("/controllo")
public class Controllo extends HttpServlet {
	private static final long serialVersionUID = 7427356753542790548L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeadmin = request.getParameter("nomeadmin");
		String cognomeadmin = request.getParameter("cognomeadmin");
		String codadmin = request.getParameter("codadmin");
		
		HttpSession session = request.getSession();
		String adminpass=null;
		int conto = (Integer)session.getAttribute("conto");
		if (nomeadmin != null && cognomeadmin != null && codadmin != null ) {
			try {
				Login l = new Login();
				adminpass = l.getCodAdmin(nomeadmin, cognomeadmin);
				if (adminpass!=null && adminpass.equals(codadmin)) {
					session.setAttribute("nomeadmin", nomeadmin);
					session.setAttribute("cognomeadmin", cognomeadmin);
					response.sendRedirect("index.jsp");
				}else if(--conto >0){
					
					session.setAttribute("conto", (Integer)conto);
					response.sendRedirect("utilities/login.jsp");
				}else {
					response.sendRedirect("utilities/tentativiesauriti.jsp");
				}
			}catch(Exception e) {
				e.printStackTrace();
				throw new ServletException(e.getMessage());
			}
			
			
		}else {
			response.sendRedirect("utilities/login.jsp");
		}
		
		
	}

}
