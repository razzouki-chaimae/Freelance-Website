package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Entreprise;
import model.Offre;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import DAO.impl.OffreDAOImpl;

/**
 * Servlet implementation class ProfileEntrepriseServlet
 */
public class ProfileEntrepriseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OffreDAOImpl offreDAO;
	
	@Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub  
	    this.offreDAO = new OffreDAOImpl();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileEntrepriseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    HttpSession session = request.getSession();
	    Entreprise entreprise = (Entreprise) session.getAttribute("user");
	    
	    Set<Offre> myOffres;
        try {
            myOffres = offreDAO.getOffresByEntreprise(entreprise.getRib());
            request.setAttribute("myOffres", myOffres);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        request.getRequestDispatcher("/VUE/ProfileEntreprise.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
