package DAO;

import java.sql.SQLException;
import java.util.Set;

import model.ImageFreelancer;

public interface ImageFreelancerDAO {
    
    // add new image freelancer
    Boolean add(ImageFreelancer imageFreelancer) throws SQLException;
    
    // Read image freelancer
    ImageFreelancer getOneByFreelancer(Long freelancer_RIB) throws SQLException;
    Set<ImageFreelancer> getAll() throws SQLException;
    
    // Update Entreprise
    Boolean update(ImageFreelancer imageFreelancer) throws SQLException;
    
    // Delete Entreprise
    Boolean deleteByRIB(Long freelancer_RIB) throws SQLException;

}
