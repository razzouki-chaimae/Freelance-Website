package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.Freelancer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import DAO.impl.FreelancerDAOImpl;

/**
 * Servlet implementation class RegisterFreelancerServlet
 */
public class RegisterFreelancerServlet extends HttpServlet {
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
    public RegisterFreelancerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	    
	    PrintWriter out = response.getWriter();
	    
		String nom=request.getParameter("first-name");
		String prenom = request.getParameter("last-name");
		String physical_address = request.getParameter("your_physical_address");
		String email = request.getParameter("your_email");
		String password = request.getParameter("your_password");
		String profession = request.getParameter("your_profession");
		String description = request.getParameter("your_description");
		String credit_card_owner = request.getParameter("credit_card_owner");
		long credit_card_number = Long.parseLong(request.getParameter("credit_card_number"));
		String expiry_date = request.getParameter("expiry_date");
		String cvc_cvv = request.getParameter("cvc_cvv");
		
		try {
		    Freelancer freelancer = new Freelancer(nom, prenom, email, password, physical_address, profession, description, credit_card_number);
            boolean addFreelancer = freelancerDAO.add(freelancer);
            //out.println("Bienvenu "+prenom);
            HttpSession session = request.getSession();
            session.setAttribute("user", freelancer);
            
            this.getServletContext().getRequestDispatcher("/OffresServlet").forward(request, response);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            out.println("Error "+e);
        }
        
	}

}
