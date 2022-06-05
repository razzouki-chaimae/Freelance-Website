package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Freelancer;
import model.ImageFreelancer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import DAO.impl.FreelancerDAOImpl;
import DAO.impl.ImageFreelancerDAOImpl;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FreelancerDAOImpl freelancerDAO;
	ImageFreelancerDAOImpl imageFreelancerDAO;
    
    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        this.freelancerDAO = new FreelancerDAOImpl();
        this.imageFreelancerDAO = new ImageFreelancerDAOImpl();
        super.init();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    try {
            Set<Freelancer> freelancers = freelancerDAO.getAll();
            request.setAttribute("freelancers", freelancers);
            
            Set<ImageFreelancer> imagesFreelancers = imageFreelancerDAO.getAll();
            request.setAttribute("ImageUsers", imagesFreelancers);
            
            this.getServletContext().getRequestDispatcher("/VUE/index.jsp").forward(request, response);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
