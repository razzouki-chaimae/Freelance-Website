package controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Entreprise;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import DAO.impl.EntrepriseDAOImpl;

/**
 * Servlet implementation class RegisterEntrepriseServlet
 */
public class RegisterEntrepriseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EntrepriseDAOImpl entrepriseDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterEntrepriseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
	    this.entrepriseDAO = new EntrepriseDAOImpl();
	    super.init();
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
        
        String nomEntreprise=request.getParameter("company-name");
        String numeroTelephone = request.getParameter("phone-number");
        String domaine = request.getParameter("company_domain");
        String emailEntreprise = request.getParameter("company_email");
        String password = request.getParameter("company_password");
        String adressePhysique = request.getParameter("company_physical_address");
        String credit_card_owner = request.getParameter("credit_card_owner");
        long credit_card_number = Long.parseLong(request.getParameter("credit_card_number"));
        String expiry_date = request.getParameter("expiry_date");
        String cvc_cvv = request.getParameter("cvc_cvv");
        
        try {
            boolean addEntreprise = entrepriseDAO.add(
                    new Entreprise(nomEntreprise, emailEntreprise, password, numeroTelephone, adressePhysique, domaine, credit_card_number));
            out.println("Bienvenu "+nomEntreprise);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            out.println("Error "+e);
        }
	}

}
