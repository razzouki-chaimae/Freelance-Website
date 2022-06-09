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
        String query="INSERT INTO offre (titre, description, budget, deadline, skills, entreprise) "
                + "VALUES (?, ?, ?, ?, ?, ?);";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        ps.setString(1, offre.getTitre());
        ps.setString(2, offre.getDescription());
        ps.setDouble(3, offre.getBudget());
        ps.setInt(4, offre.getDeadline());
        ps.setString(5, offre.getSkills());
        ps.setLong(6, offre.getEntreprise());
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
        offre.setDone(rs.getBoolean("done"));
        con.close();
        return offre;
    }
    
    @Override
    public Set<Offre> getOffresByFreelancer(Long freelancer) throws SQLException {
        Set<Offre> offres = new HashSet<Offre>();
        String query="SELECT * FROM offre WHERE `freelancer` = ?";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        ps.setLong(1, freelancer);
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
            offre.setDone(rs.getBoolean("done"));
            offres.add(offre);
        }
        con.close();
        return offres;
    }

    @Override
    public Set<Offre> getOffresByEntreprise(Long entreprise) throws SQLException {
        Set<Offre> offres = new HashSet<Offre>();
        String query="SELECT * FROM offre WHERE `entreprise` = ?";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        ps.setLong(1, entreprise);
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
            offre.setDone(rs.getBoolean("done"));
            offres.add(offre);
        }
        con.close();
        return offres;
    }
    
    // returns offres that doesn't have a freelancer yet
    @Override
    public Set<Offre> getAll() throws SQLException {
        Set<Offre> offres = new HashSet<Offre>();
        String query="SELECT * FROM offre WHERE `done` = false";
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
            offre.setDone(rs.getBoolean("done"));
            offres.add(offre);
        }
        con.close();
        return offres;
    }

    @Override
    public Boolean update(Offre offre) throws SQLException {
        if(offre.getFreelancer()==null) {
            String query = "UPDATE offre SET titre = ?, description = ?, budget = ?, deadline = ?, skills = ?, entreprise = ?, done = ? WHERE projectId = ?";
            con=Factory.dbConnect();
            ps=con.prepareStatement(query);
            ps.setString(1, offre.getTitre());
            ps.setString(2, offre.getDescription());
            ps.setDouble(3, offre.getBudget());
            ps.setInt(4, offre.getDeadline());
            ps.setString(5, offre.getSkills());
            ps.setLong(6, offre.getEntreprise());
            ps.setBoolean(7, offre.isDone());
            ps.setInt(8, offre.getProjectId());
            int row = ps.executeUpdate();
            con.close();
            return row > 0;
        } else {
            String query = "UPDATE offre SET titre = ?, description = ?, budget = ?, deadline = ?, skills = ?, entreprise = ?, freelancer = ?, done = ? WHERE projectId = ?";
            con=Factory.dbConnect();
            ps=con.prepareStatement(query);
            ps.setString(1, offre.getTitre());
            ps.setString(2, offre.getDescription());
            ps.setDouble(3, offre.getBudget());
            ps.setInt(4, offre.getDeadline());
            ps.setString(5, offre.getSkills());
            ps.setLong(6, offre.getEntreprise());
            ps.setLong(7, offre.getFreelancer());
            ps.setBoolean(8, offre.isDone());
            ps.setInt(9, offre.getProjectId());
            int row = ps.executeUpdate();
            con.close();
            return row > 0;
        }
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
