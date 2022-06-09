package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Freelancer;
import model.ImageFreelancer;
import model.Offre;
import model.Postulant;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import DAO.impl.ImageFreelancerDAOImpl;
import DAO.impl.OffreDAOImpl;
import DAO.impl.PostulantDAOImpl;

/**
 * Servlet implementation class ProfileFreelancerServlet
 */
public class ProfileFreelancerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ImageFreelancerDAOImpl imageFreelancerDAO;
	OffreDAOImpl offreDAO;
	PostulantDAOImpl postulantDAO;
       
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
        this.offreDAO = new OffreDAOImpl();
        this.postulantDAO = new PostulantDAOImpl();
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
                imageFreelancer = new ImageFreelancer("/freelanceProject/VUE/img/1111111111111111.jpg", freelancer.getRib());
            }
            session.setAttribute("ImageUser", imageFreelancer);
            
            Set<Offre> myProjects = offreDAO.getOffresByFreelancer(freelancer.getRib());
            //Set<Postulant> myProjects = postulantDAO.getAllByFreelancer(freelancer.getRib());
            request.setAttribute("myProjects", myProjects);
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
