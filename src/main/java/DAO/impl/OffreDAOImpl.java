package DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import DAO.OffreDAO;
import DAO.factory.Factory;
import model.Freelancer;
import model.Offre;

public class OffreDAOImpl implements OffreDAO {
    
    static Connection con = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    @Override
    public Boolean add(Offre offre) throws SQLException {
        String query="INSERT INTO offre (projectId, titre, description, budget, deadline, skills, entreprise, freelancer) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        ps.setInt(1, offre.getProjectId());
        ps.setString(2, offre.getTitre());
        ps.setString(3, offre.getDescription());
        ps.setDouble(4, offre.getBudget());
        ps.setInt(5, offre.getDeadline());
        ps.setString(6, offre.getSkills());
        ps.setLong(7, offre.getEntreprise());
        ps.setLong(8, offre.getFreelancer());
        int row = ps.executeUpdate();
        con.close();
        return row > 0;
    }

    @Override
    public Offre getOneById(int projectId) throws SQLException {
        Offre offre = new Offre();
        String query="SELECT * FROM offre WHERE `projectId` = ?";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        ps.setInt(1, projectId);
        rs=ps.executeQuery();
        rs.next();
        offre.setProjectId(rs.getInt("projectId"));
        offre.setTitre(rs.getString("titre"));
        offre.setDescription(rs.getString("description"));
        offre.setBudget(rs.getDouble("budget"));
        offre.setDeadline(rs.getInt("deadline"));
        offre.setSkills(rs.getString("skills"));
        offre.setEntreprise(rs.getLong("entreprise"));
        offre.setFreelancer(rs.getLong("freelancer"));
        con.close();
        return offre;
    }

    @Override
    public Set<Offre> getAll() throws SQLException {
        Set<Offre> offres = new HashSet<Offre>();
        String query="SELECT * FROM offre";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        rs=ps.executeQuery();
        while(rs.next()) {
            Offre offre = new Offre();
            offre.setProjectId(rs.getInt("projectId"));
            offre.setTitre(rs.getString("titre"));
            offre.setDescription(rs.getString("description"));
            offre.setBudget(rs.getDouble("budget"));
            offre.setDeadline(rs.getInt("deadline"));
            offre.setSkills(rs.getString("skills"));
            offre.setEntreprise(rs.getLong("entreprise"));
            offre.setFreelancer(rs.getLong("freelancer"));
            offres.add(offre);
        }
        con.close();
        return offres;
    }

    @Override
    public Boolean update(Offre offre) throws SQLException {
        String query = "UPDATE offre SET titre = ?, description = ?, budget = ?, deadline = ?, skills = ?, entreprise = ?, freelancer = ? WHERE projectId = ?";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        ps.setString(1, offre.getTitre());
        ps.setString(2, offre.getDescription());
        ps.setDouble(3, offre.getBudget());
        ps.setInt(4, offre.getDeadline());
        ps.setString(5, offre.getSkills());
        ps.setLong(6, offre.getEntreprise());
        ps.setLong(7, offre.getFreelancer());
        ps.setInt(8, offre.getProjectId());
        int row = ps.executeUpdate();
        con.close();
        return row > 0;
    }

    @Override
    public Boolean deleteById(int projectId) throws SQLException {
        String query = "DELETE FROM offre WHERE projectId=?";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        ps.setInt(1, projectId);
        int row = ps.executeUpdate();
        con.close();
        return row > 0;
    }

}
