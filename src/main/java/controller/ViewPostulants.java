package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Freelancer;
import model.Offre;
import model.Postulant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import DAO.impl.FreelancerDAOImpl;
import DAO.impl.OffreDAOImpl;
import DAO.impl.PostulantDAOImpl;

public class ViewPostulants extends HttpServlet {
    private static final long serialVersionUID = 1L;
    PostulantDAOImpl postulantDAO;
    FreelancerDAOImpl freelancerDAO;
    OffreDAOImpl offreDAO;

    @Override
    public void init() throws ServletException {
        postulantDAO = new PostulantDAOImpl();
        freelancerDAO = new FreelancerDAOImpl();
        offreDAO = new OffreDAOImpl();
        super.init();
    }

    public ViewPostulants() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            int offre = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("idOffre", offre);
            
            Offre infosOffre = offreDAO.getOneById(offre);
            request.setAttribute("titre", infosOffre.getTitre());
            request.setAttribute("description", infosOffre.getDescription());
            request.setAttribute("deadline", infosOffre.getDeadline());
            request.setAttribute("budget", infosOffre.getBudget());
            request.setAttribute("skills", infosOffre.getSkills());

            Set<Postulant> postulants = postulantDAO.getAllByOffre(offre);
            request.setAttribute("postulants", postulants);
            
            if(! postulants.isEmpty()) {
                
                Set<Freelancer> freelancers = new HashSet<Freelancer>();
                
                for(Postulant postulant : postulants) {
                    Freelancer freelancer = freelancerDAO.getOneByRIB(postulant.getFreelancer());
                    freelancers.add(freelancer);
                }
                
                request.setAttribute("freelancers", freelancers);
            }
            
            request.getRequestDispatcher("/VUE/ViewPostulants.jsp").forward(request, response);
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
