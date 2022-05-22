package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Freelancer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import DAO.FreelancerDAO;
import DAO.impl.FreelancerDAOImpl;

/**
 * Servlet implementation class FreelancerController
 */
public class FreelancerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FreelancerDAOImpl freelancerDAO;
	
	@Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        this.freelancerDAO = new FreelancerDAOImpl();
        super.init();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreelancerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    try {
            Set<Freelancer> freelancers = freelancerDAO.getAll();
            
            request.setAttribute("freelancers", freelancers);
	        
            //sendredirect fblast getRequestDispatcher
            this.getServletContext().getRequestDispatcher("/VUE/ListAllFreelancers.jsp").forward(request, response);
            
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
