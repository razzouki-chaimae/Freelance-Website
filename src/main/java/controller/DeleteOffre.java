package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import DAO.impl.OffreDAOImpl;

public class DeleteOffre extends HttpServlet {
    private static final long serialVersionUID = 1L;
    OffreDAOImpl offreDAO;

    @Override
    public void init() throws ServletException {
        offreDAO = new OffreDAOImpl();
        super.init();
    }

    public DeleteOffre() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // response.getWriter().append("Served at: ").append(request.getContextPath());
        PrintWriter out = response.getWriter();

        try {
            int idOffre = Integer.parseInt(request.getParameter("id"));
            
            boolean deleteOffre = offreDAO.deleteById(idOffre);

            if (deleteOffre)
                System.out.println("L'offre "+ idOffre +" a été bien supprimé");
            else
                System.out.println("L'offre "+ idOffre +" n'a pas été supprimé");
            
            this.getServletContext().getRequestDispatcher("/ProfileEntrepriseServlet").forward(request, response);
            
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("Error " + e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
