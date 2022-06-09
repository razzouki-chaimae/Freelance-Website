package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Freelancer;
import model.Offre;
import model.Postulant;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import DAO.impl.OffreDAOImpl;
import DAO.impl.PostulantDAOImpl;

/**
 * Servlet implementation class AddPostulant
 */
public class AddPostulant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostulantDAOImpl postulantDAO;
	OffreDAOImpl offreDAO;
       
	@Override
    public void init() throws ServletException {
        postulantDAO = new PostulantDAOImpl();
        offreDAO = new OffreDAOImpl();
	    super.init();
	}
	
    public AddPostulant() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    HttpSession session = request.getSession();
	    Freelancer freelancer = (Freelancer) session.getAttribute("user");
	    
	    int id_offre = Integer.parseInt(request.getParameter("id"));
	    
	    try {
            postulantDAO.add(new Postulant(id_offre, freelancer.getRib()));
            
            Set<Offre> myProjects = offreDAO.getOffresByFreelancer(freelancer.getRib());
            //Set<Postulant> myProjects = postulantDAO.getAllByFreelancer(freelancer.getRib());
            request.setAttribute("myProjects", myProjects);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    
	    request.getRequestDispatcher("/OffresServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
