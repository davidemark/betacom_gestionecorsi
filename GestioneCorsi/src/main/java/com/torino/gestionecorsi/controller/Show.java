package com.torino.gestionecorsi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.torino.gestionecorsi.businesscomponent.facade.AdminFacade;
import com.torino.gestionecorsi.businesscomponent.model.Corsista;

@WebServlet("/show")
public class Show extends HttpServlet {

	private static final long serialVersionUID = 5554782608003661796L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			Long codcorsista = Long.valueOf(request.getParameter("codcorsista"));
			Corsista corsista = AdminFacade.getInstance().findCorsistaByCod(codcorsista);
			session.setAttribute("corsista", corsista);
			response.sendRedirect("utilities/show.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}

}
