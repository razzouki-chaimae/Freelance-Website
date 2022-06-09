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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FreelancerDAOImpl freelancerDAO;
	EntrepriseDAOImpl entrepriseDAO;
       
    @Override
    public void init() throws ServletException {
        freelancerDAO = new FreelancerDAOImpl();
        entrepriseDAO = new EntrepriseDAOImpl();
        // TODO Auto-generated method stub
        super.init();
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    request.getRequestDispatcher("/VUE/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	    PrintWriter out = response.getWriter();
        
	    String email = request.getParameter("email");
        String password = request.getParameter("pass");
        
        try {
            Freelancer freelancer = freelancerDAO.authentifier(email, password);
            if(freelancer!= null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", freelancer);
                //out.println("Bienvenu "+ freelancer.getPrenom());
                this.getServletContext().getRequestDispatcher("/OffresServlet").forward(request, response);
            } else {
                Entreprise entreprise = entrepriseDAO.authentifier(email, password);
                if(entreprise != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", entreprise);
                    //out.println("Bienvenu "+ entreprise.getNomEntreprise());
                    //this.getServletContext().getRequestDispatcher("/AddOffreServlet").forward(request, response);
                    //request.getRequestDispatcher("/VUE/AddOffre.jsp").forward(request, response);
                    this.getServletContext().getRequestDispatcher("/ProfileEntrepriseServlet").forward(request, response);
                } else {
                    //request.getRequestDispatcher("/LoginServlet").forward(request, response);
                    doGet(request, response);
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            out.println("Error "+ e);
        }
	}

}
