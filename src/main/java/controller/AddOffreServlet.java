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
import java.io.PrintWriter;
import java.sql.SQLException;

import DAO.impl.FreelancerDAOImpl;
import DAO.impl.OffreDAOImpl;

/**
 * Servlet implementation class AddOffreServlet
 */
public class AddOffreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OffreDAOImpl offreDAO;
	
	@Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        this.offreDAO = new OffreDAOImpl();
        super.init();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOffreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    request.getRequestDispatcher("/VUE/AddOffre.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	    PrintWriter out = response.getWriter();
	    
	    HttpSession session = request.getSession();
        Entreprise entreprise = (Entreprise) session.getAttribute("user");
	    
	    String titre =request.getParameter("Offre_Title");
	    String description =request.getParameter("description");
	    Double budget = Double.parseDouble(request.getParameter("Budget"));
	    int deadline = Integer. parseInt(request.getParameter("deadline"));
	    String skills =request.getParameter("Skills");
	    Long rib_entreprise = entreprise.getRib();
	    
	    Offre offre = new Offre(titre, description, budget, deadline, skills, rib_entreprise, null);
	    
	    try {
            boolean addFreelancer = offreDAO.add(offre);
            //out.println("l'offre a été bien ajouté ");
            request.getRequestDispatcher("/ProfileEntrepriseServlet").forward(request, response);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            out.println("Error "+e);
        }
	    
	}

}
