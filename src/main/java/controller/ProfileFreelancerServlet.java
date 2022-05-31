package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Freelancer;
import model.ImageFreelancer;

import java.io.IOException;
import java.sql.SQLException;

import DAO.impl.ImageFreelancerDAOImpl;

/**
 * Servlet implementation class ProfileFreelancerServlet
 */
public class ProfileFreelancerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ImageFreelancerDAOImpl imageFreelancerDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileFreelancerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        this.imageFreelancerDAO = new ImageFreelancerDAOImpl();
        super.init();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    
	    HttpSession session = request.getSession();
        Freelancer freelancer = (Freelancer) session.getAttribute("user");
        
	    try {
            ImageFreelancer imageFreelancer = imageFreelancerDAO.getOneByFreelancer(freelancer.getRib());
            if(imageFreelancer == null) {
                imageFreelancer = new ImageFreelancer("/freelanceProject/VUE/img/Webp.net-resizeimage (1).png", freelancer.getRib());
            }
            session.setAttribute("ImageUser", imageFreelancer);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    
	    request.getRequestDispatcher("/VUE/ProfileFreelancer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
