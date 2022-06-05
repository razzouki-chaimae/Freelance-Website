package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Offre;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import DAO.impl.FreelancerDAOImpl;
import DAO.impl.OffreDAOImpl;

/**
 * Servlet implementation class OffresServlet
 */
public class OffresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OffreDAOImpl offresDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OffresServlet() {
        super();
        // TODO Auto-generated constructor stub
        offresDAO = new OffreDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    try {
            Set<Offre> offres = offresDAO.getAll();
            System.out.println(offres);
            request.setAttribute("offres", offres);
            request.getRequestDispatcher("/VUE/Offres.jsp").forward(request, response);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
