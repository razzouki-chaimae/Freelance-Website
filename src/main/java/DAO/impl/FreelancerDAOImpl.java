package DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import DAO.FreelancerDAO;
import DAO.factory.Factory;
import model.Freelancer;

public class FreelancerDAOImpl implements FreelancerDAO{
    
    static Connection con = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    @Override
    public Boolean add(Freelancer freelancer) throws SQLException {
        String query="INSERT INTO freelancer (nom, prenom, email, password, adressePhysique, profession, description, rib) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        ps.setString(1, freelancer.getNom());
        ps.setString(2, freelancer.getPrenom());
        ps.setString(3, freelancer.getEmail());
        ps.setString(4, freelancer.getPassword());
        ps.setString(5, freelancer.getAdressePhysique());
        ps.setString(6, freelancer.getProfession());
        ps.setString(7, freelancer.getDescription());
        ps.setLong(8, freelancer.getRib());
        int row = ps.executeUpdate();
        con.close();
        return row > 0;
    }

    @Override
    public Freelancer getOneByRIB(Long freelancer_RIB) throws SQLException {
        Freelancer freelancer = new Freelancer();
        String query="SELECT * FROM freelancer WHERE `rib` = ?";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        ps.setLong(1, freelancer_RIB);
        rs=ps.executeQuery();
        rs.next();
        freelancer.setNom(rs.getString("nom"));
        freelancer.setPrenom(rs.getString("prenom"));
        freelancer.setEmail(rs.getString("email"));
        freelancer.setPassword(rs.getString("password"));
        freelancer.setAdressePhysique(rs.getString("adressePhysique"));
        freelancer.setProfession(rs.getString("profession"));
        freelancer.setDescription(rs.getString("description"));
        freelancer.setRib(rs.getLong("rib"));
        con.close();
        return freelancer;
    }

    @Override
    public Set<Freelancer> getAll() throws SQLException {
        Set<Freelancer> freelancers = new HashSet<Freelancer>();
        String query="SELECT * FROM freelancer";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        rs=ps.executeQuery();
        while(rs.next()) {
            Freelancer freelancer = new Freelancer();
            freelancer.setNom(rs.getString("nom"));
            freelancer.setPrenom(rs.getString("prenom"));
            freelancer.setEmail(rs.getString("email"));
            freelancer.setPassword(rs.getString("password"));
            freelancer.setAdressePhysique(rs.getString("adressePhysique"));
            freelancer.setProfession(rs.getString("profession"));
            freelancer.setDescription(rs.getString("description"));
            freelancer.setRib(rs.getLong("rib"));
            freelancers.add(freelancer);
        }
        con.close();
        return freelancers;
    }
    
    @Override
    public Boolean update(Freelancer freelancer) throws SQLException {
        String query = "UPDATE freelancer SET nom = ?, prenom = ?, email = ?, password = ?, adressePhysique = ?, profession = ?, description = ? WHERE rib = ?";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        ps.setString(1, freelancer.getNom());
        ps.setString(2, freelancer.getPrenom());
        ps.setString(3, freelancer.getEmail());
        ps.setString(4, freelancer.getPassword());
        ps.setString(5, freelancer.getAdressePhysique());
        ps.setString(6, freelancer.getProfession());
        ps.setString(7, freelancer.getDescription());
        ps.setLong(8, freelancer.getRib());
        int row = ps.executeUpdate();
        con.close();
        return row > 0;
    }

    @Override
    public Boolean deleteByRIB(Long freelancer_RIB) throws SQLException {
        String query = "DELETE FROM freelancer WHERE rib=?";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        ps.setLong(1, freelancer_RIB);
        int row = ps.executeUpdate();
        con.close();
        return row > 0;
    }

    @Override
    public Freelancer authentifier(String email, String password) throws SQLException {
        Freelancer freelancer = null;
        String query="SELECT * FROM freelancer WHERE email like ? AND password like ?";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        ps.setString(1, email);
        ps.setString(2, password);
        rs=ps.executeQuery();
        if(rs.next()) {
            freelancer = new Freelancer();
            freelancer.setNom(rs.getString("nom"));
            freelancer.setPrenom(rs.getString("prenom"));
            freelancer.setEmail(rs.getString("email"));
            freelancer.setPassword(rs.getString("password"));
            freelancer.setAdressePhysique(rs.getString("adressePhysique"));
            freelancer.setProfession(rs.getString("profession"));
            freelancer.setDescription(rs.getString("description"));
            freelancer.setRib(rs.getLong("rib"));
        }
        con.close();
        return freelancer;
    }
    
}