package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Freelancer;

import java.io.IOException;
import java.sql.SQLException;

import DAO.impl.FreelancerDAOImpl;

/**
 * Servlet implementation class DeleteFreelancer
 */
public class DeleteFreelancer extends HttpServlet {
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
    public DeleteFreelancer() {
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
	        HttpSession session = request.getSession();
	        Freelancer freelancer = (Freelancer) session.getAttribute("user");
	        
            boolean deleteFreelancer = freelancerDAO.deleteByRIB(freelancer.getRib());
            
            String data;
            
            if(deleteFreelancer) {
                session.invalidate();
                //request.getRequestDispatcher("/VUE/index.jsp").forward(request, response);
                data = "ok";
                
            } else {
                System.out.println("can't delete freelancer");
                
                data = "not";
            }
            
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(data);
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Exception : can't delete freelancer");
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
