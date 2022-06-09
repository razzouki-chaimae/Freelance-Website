package DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import DAO.PostulantsDAO;
import DAO.factory.Factory;
import model.Postulant;

public class PostulantDAOImpl implements PostulantsDAO {

    static Connection con = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    @Override
    public Boolean add(Postulant postulant) throws SQLException {
        int row = 0;
        if (!isExist(postulant)) {
            String query = "INSERT INTO postulants (project, freelancer) VALUES (?, ?);";
            con = Factory.dbConnect();
            ps = con.prepareStatement(query);
            ps.setInt(1, postulant.getOffre());
            ps.setLong(2, postulant.getFreelancer());
            row = ps.executeUpdate();
            con.close();
        }
        return row > 0;
    }

    @Override
    public Boolean isExist(Postulant postulant) throws SQLException {
        String query = "SELECT * FROM postulants WHERE `project` = ? AND `freelancer` = ?";
        con = Factory.dbConnect();
        ps = con.prepareStatement(query);
        ps.setInt(1, postulant.getOffre());
        ps.setLong(2, postulant.getFreelancer());
        rs = ps.executeQuery();
        return rs.next();
    }

    @Override
    public Set<Postulant> getAllByOffre(int offre) throws SQLException {
        Set<Postulant> postulants = new HashSet<Postulant>();
        String query = "SELECT * FROM postulants WHERE `project` = ?";
        con = Factory.dbConnect();
        ps = con.prepareStatement(query);
        ps.setInt(1, offre);
        rs = ps.executeQuery();
        while (rs.next()) {
            Postulant postulant = new Postulant();
            postulant.setOffre(rs.getInt("project"));
            postulant.setFreelancer(rs.getLong("freelancer"));

            postulants.add(postulant);
        }
        con.close();
        return postulants;
    }

    @Override
    public Set<Postulant> getAllByFreelancer(Long freelancer) throws SQLException {
        Set<Postulant> postulants = new HashSet<Postulant>();
        String query = "SELECT * FROM postulants WHERE `freelancer` = ?";
        con = Factory.dbConnect();
        ps = con.prepareStatement(query);
        ps.setLong(1, freelancer);
        rs = ps.executeQuery();
        while (rs.next()) {
            Postulant postulant = new Postulant();
            postulant.setOffre(rs.getInt("project"));
            postulant.setFreelancer(rs.getLong("freelancer"));

            postulants.add(postulant);
        }
        con.close();
        return postulants;
    }

    @Override
    public Boolean deleteAllByOffre(int offre) throws SQLException {
        String query = "DELETE FROM postulants WHERE project=?";
        con = Factory.dbConnect();
        ps = con.prepareStatement(query);
        ps.setInt(1, offre);
        int row = ps.executeUpdate();
        con.close();
        return row > 0;
    }

    @Override
    public Boolean deleteAllByFreelancer(Long freelancer) throws SQLException {
        String query = "DELETE FROM postulants WHERE freelancer=?";
        con = Factory.dbConnect();
        ps = con.prepareStatement(query);
        ps.setLong(1, freelancer);
        int row = ps.executeUpdate();
        con.close();
        return row > 0;
    }

}
