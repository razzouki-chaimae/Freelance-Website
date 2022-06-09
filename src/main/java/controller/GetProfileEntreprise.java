package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Entreprise;
import model.Offre;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Set;

import DAO.impl.EntrepriseDAOImpl;
import DAO.impl.OffreDAOImpl;

/**
 * Servlet implementation class GetProfileEntreprise
 */
public class GetProfileEntreprise extends HttpServlet {
    private static final long serialVersionUID = 1L;
    EntrepriseDAOImpl entrepriseDAO;
    OffreDAOImpl offreDAO;

    @Override
    public void init() throws ServletException {
        this.entrepriseDAO = new EntrepriseDAOImpl();
        this.offreDAO = new OffreDAOImpl();
        super.init();
    }

    public GetProfileEntreprise() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            Long rib_entreprise = Long.parseLong(request.getParameter("id"));
            System.out.println("id received : "+rib_entreprise);
            
            Entreprise entreprise = entrepriseDAO.getOneByRIB(rib_entreprise);
            request.setAttribute("entreprise", entreprise);
            
            Set<Offre> offres = offreDAO.getOffresByEntreprise(rib_entreprise);
            request.setAttribute("offres", offres);
            
            //out.println("Entreprise : "+entreprise.getNomEntreprise());
            request.getRequestDispatcher("/VUE/ViewEntreprise.jsp").forward(request, response);
            
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("Error "+e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
