package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Freelancer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import DAO.impl.FreelancerDAOImpl;

/**
 * Servlet implementation class ModificationFreelancerServlet
 */
public class ModificationFreelancerServlet extends HttpServlet {
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
    public ModificationFreelancerServlet() {
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
        Freelancer freelancer = (Freelancer) session.getAttribute("user");
        request.setAttribute("nom", freelancer.getNom());
        request.setAttribute("prenom", freelancer.getPrenom());
        request.setAttribute("email", freelancer.getEmail());
        request.setAttribute("old_password", freelancer.getPassword());
        request.setAttribute("adressePhysique", freelancer.getAdressePhysique());
        request.setAttribute("profession", freelancer.getProfession());
        request.setAttribute("description", freelancer.getDescription());
        
        request.getRequestDispatcher("/VUE/ModifyFreelancer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

	    PrintWriter out = response.getWriter();
        
        String nom=request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String physical_address = request.getParameter("adressePhysique");
        String email = request.getParameter("email");
        String oldPassword = request.getParameter("old_password");
        String newPassword = request.getParameter("new_password");
        String profession = request.getParameter("profession");
        String description = request.getParameter("description");
        
        HttpSession session = request.getSession();
        Freelancer freelancer = (Freelancer) session.getAttribute("user");
        
        try {
            Freelancer newFreelancer = new Freelancer(nom, prenom, email, newPassword, physical_address, profession, description, freelancer.getRib());
            boolean updateFreelancer = freelancerDAO.update(newFreelancer);
            
            if(updateFreelancer) {
                session.setAttribute("user", newFreelancer);
                System.out.println("Modifications effectuées avec succes!");
            }
            else    System.out.println("Modifications echouées!");
            
            this.getServletContext().getRequestDispatcher("/ProfileFreelancer").forward(request, response);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            out.println("Error "+e);
        }
        
    }

}
