package DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import DAO.ImageFreelancerDAO;
import DAO.factory.Factory;
import model.ImageFreelancer;

public class ImageFreelancerDAOImpl implements ImageFreelancerDAO {
    
    static Connection con = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    @Override
    public Boolean add(ImageFreelancer imageFreelancer) throws SQLException {
        String query="INSERT INTO imagefreelancer (freelacer, urlImage) VALUES (?, ?);";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        ps.setLong(1, imageFreelancer.getRibFreelancer());
        ps.setString(2, imageFreelancer.getUrlImange());
        int row = ps.executeUpdate();
        con.close();
        return row > 0;
    }

    @Override
    public ImageFreelancer getOneByFreelancer(Long freelancer_RIB) throws SQLException {
        ImageFreelancer imageFreelancer =  null;
        String query="SELECT * FROM imagefreelancer WHERE `freelacer` = ?";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        ps.setLong(1, freelancer_RIB);
        rs=ps.executeQuery();
        if(rs.next()) {
            imageFreelancer = new ImageFreelancer();
            imageFreelancer.setUrlImange(rs.getString("urlImage"));
            imageFreelancer.setRibFreelancer(rs.getLong("freelacer"));
            }
        con.close();
        return imageFreelancer;
    }

    @Override
    public Set<ImageFreelancer> getAll() throws SQLException {
        Set<ImageFreelancer> imagesFreelancers = new HashSet<ImageFreelancer>();
        String query="SELECT * FROM imagefreelancer";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        rs=ps.executeQuery();
        while(rs.next()) {
            ImageFreelancer imageFreelancer = new ImageFreelancer();
            imageFreelancer.setUrlImange(rs.getString("urlImage"));
            imageFreelancer.setRibFreelancer(rs.getLong("freelacer"));
            imagesFreelancers.add(imageFreelancer);
        }
        con.close();
        return imagesFreelancers;
    }

    @Override
    public Boolean update(ImageFreelancer imageFreelancer) throws SQLException {
        String query = "UPDATE imagefreelancer SET urlImage = ? WHERE freelacer = ?";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        ps.setString(1, imageFreelancer.getUrlImange());
        ps.setLong(2, imageFreelancer.getRibFreelancer());
        int row = ps.executeUpdate();
        con.close();
        return row > 0;
    }

    @Override
    public Boolean deleteByRIB(Long freelancer_RIB) throws SQLException {
        String query = "DELETE FROM imagefreelancer WHERE freelacer=?";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        ps.setLong(1, freelancer_RIB);
        int row = ps.executeUpdate();
        con.close();
        return row > 0;
    }

}
