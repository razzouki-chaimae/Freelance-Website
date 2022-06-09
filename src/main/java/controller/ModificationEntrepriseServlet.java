package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Entreprise;
import model.Freelancer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import DAO.impl.EntrepriseDAOImpl;
import DAO.impl.FreelancerDAOImpl;

/**
 * Servlet implementation class ModificationEntrepriseServlet
 */
public class ModificationEntrepriseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntrepriseDAOImpl entrepriseDAO;

    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        this.entrepriseDAO = new EntrepriseDAOImpl();
        super.init();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificationEntrepriseServlet() {
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
	    
        request.setAttribute("nomEntreprise", entreprise.getNomEntreprise());
        request.setAttribute("numeroTelephone", entreprise.getNumeroTelephone());
        request.setAttribute("emailEntreprise", entreprise.getEmailEntreprise());
        request.setAttribute("old_password", entreprise.getPassword());
        request.setAttribute("adressePhysique", entreprise.getAdressePhysique());
        request.setAttribute("domaine", entreprise.getDomaine());
        request.setAttribute("description", entreprise.getDescription());
        
        request.getRequestDispatcher("/VUE/ModifyEntreprise.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
        PrintWriter out = response.getWriter();
        
        String nomEntreprise=request.getParameter("nomEntreprise");
        String numeroTelephone = request.getParameter("numeroTelephone");
        String physical_address = request.getParameter("adressePhysique");
        String emailEntreprise = request.getParameter("emailEntreprise");
        String oldPassword = request.getParameter("old_password");
        String newPassword = request.getParameter("new_password");
        String domaine = request.getParameter("domaine");
        String description = request.getParameter("description");
        
        HttpSession session = request.getSession();
        Entreprise entreprise = (Entreprise) session.getAttribute("user");
        
        try {
            Entreprise newEntreprise = new Entreprise(nomEntreprise, emailEntreprise, newPassword, numeroTelephone, physical_address, domaine, description, entreprise.getRib());
            boolean updateFreelancer = entrepriseDAO.update(newEntreprise);
            
            if(updateFreelancer) {
                session.setAttribute("user", newEntreprise);
                System.out.println("Modifications effectuées avec succes!");
            }
            else    System.out.println("Modifications echouées!");
            
            
            this.getServletContext().getRequestDispatcher("/ProfileEntrepriseServlet").forward(request, response);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            out.println("Error "+e);
        }
	}

}
