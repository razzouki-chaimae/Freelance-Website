package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Freelancer;
import model.Offre;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Set;

import DAO.impl.FreelancerDAOImpl;
import DAO.impl.OffreDAOImpl;

/**
 * Servlet implementation class GetProfileFreelancer
 */
public class GetProfileFreelancer extends HttpServlet {
    private static final long serialVersionUID = 1L;
    FreelancerDAOImpl freelancerDAO;
    OffreDAOImpl offreDAO;

    @Override
    public void init() throws ServletException {
        freelancerDAO = new FreelancerDAOImpl();
        this.offreDAO = new OffreDAOImpl();
        super.init();
    }

    public GetProfileFreelancer() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // response.getWriter().append("Served at: ").append(request.getContextPath());
        PrintWriter out = response.getWriter();
        try {
            Long rib_freelancer = Long.parseLong(request.getParameter("id"));
            int id_offre = Integer.parseInt(request.getParameter("offre"));
            request.setAttribute("idOffre", id_offre);

            Freelancer freelancer = freelancerDAO.getOneByRIB(rib_freelancer);
            request.setAttribute("freelancer", freelancer);
            
            Set<Offre> offres = offreDAO.getOffresByFreelancer(rib_freelancer);
            request.setAttribute("offres", offres);
            
            request.getRequestDispatcher("/VUE/ViewFreelancer.jsp").forward(request, response);
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
