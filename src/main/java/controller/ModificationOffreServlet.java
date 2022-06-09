package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Offre;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import DAO.impl.OffreDAOImpl;

public class ModificationOffreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    OffreDAOImpl offreDAO;

    @Override
    public void init() throws ServletException {
        offreDAO = new OffreDAOImpl();
        super.init();
    }

    public ModificationOffreServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // doGet(request, response);
        PrintWriter out = response.getWriter();
        try {
            String titre = request.getParameter("titre");
            String description = request.getParameter("description");
            double budget = Double.parseDouble(request.getParameter("budget"));
            int deadline = Integer.parseInt(request.getParameter("deadline"));
            String skills = request.getParameter("skills");

            int idOffre = Integer.parseInt(request.getParameter("id"));

            Offre offre = offreDAO.getOneById(idOffre);
            
            boolean updateOffre;
            if(offre.getFreelancer()!=0)
                updateOffre = offreDAO.update(
                                    new Offre(offre.getProjectId(), titre, description, budget, deadline, skills, offre.getEntreprise(), offre.getFreelancer(), offre.isDone()));
            else 
                updateOffre = offreDAO.update(
                        new Offre(offre.getProjectId(), titre, description, budget, deadline, skills, offre.getEntreprise(), null, offre.isDone()));
            if(updateOffre)
                System.out.println("L'offre a été bien modifié");
            else
                System.out.println("L'offre n'est pas modifié");
            
            this.getServletContext().getRequestDispatcher("/ProfileEntrepriseServlet").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("Error "+e);
        }
    }

}
