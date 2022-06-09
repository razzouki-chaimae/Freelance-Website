package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Entreprise;

import java.io.IOException;
import java.sql.SQLException;

import DAO.impl.EntrepriseDAOImpl;
import DAO.impl.FreelancerDAOImpl;

/**
 * Servlet implementation class DeleteEntreprise
 */
public class DeleteEntreprise extends HttpServlet {
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
    public DeleteEntreprise() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        // response.getWriter().append("Served at: ").append(request.getContextPath());
        try {
            HttpSession session = request.getSession();
            Entreprise entreprise = (Entreprise) session.getAttribute("user");

            boolean deleteEntreprise;

            deleteEntreprise = entrepriseDAO.deleteByRIB(entreprise.getRib());

            String data;

            if (deleteEntreprise) {
                session.invalidate();
                data = "ok";
            } else {
                System.out.println("can't delete entreprise");
                data = "not";
            }

            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(data);
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception : can't delete entreprise");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
