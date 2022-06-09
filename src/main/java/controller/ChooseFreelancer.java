package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Offre;
import model.Postulant;

import java.io.IOException;
import java.sql.SQLException;

import DAO.impl.OffreDAOImpl;
import DAO.impl.PostulantDAOImpl;

public class ChooseFreelancer extends HttpServlet {
    private static final long serialVersionUID = 1L;
    OffreDAOImpl offreDAO;
    PostulantDAOImpl postulantDAO;

    @Override
    public void init() throws ServletException {
        offreDAO = new OffreDAOImpl();
        postulantDAO = new PostulantDAOImpl();
        super.init();
    }

    public ChooseFreelancer() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // response.getWriter().append("Served at: ").append(request.getContextPath());
        try {
            Long rib_freelancer = Long.parseLong(request.getParameter("id"));
            int id_offre = Integer.parseInt(request.getParameter("offre"));

            Postulant postulant = new Postulant(id_offre, rib_freelancer);

            Offre offre = offreDAO.getOneById(id_offre);
            offre.setFreelancer(rib_freelancer);
            offre.setDone(true);
            
            boolean updateOffre = offreDAO.update(offre);
            
            this.getServletContext().getRequestDispatcher("/ProfileEntrepriseServlet").forward(request, response);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
