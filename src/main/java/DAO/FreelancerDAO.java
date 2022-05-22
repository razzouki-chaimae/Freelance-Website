package DAO;

import java.sql.SQLException;
import java.util.Set;

import model.Freelancer;

public interface FreelancerDAO {
    
    // Create Freelancer
    Boolean add(Freelancer freelancer) throws SQLException;
    
    // Read Freelancer
    Freelancer getOneByRIB(Long freelancer_RIB) throws SQLException;
    Set<Freelancer> getAll() throws SQLException;
    
    // Update Freelancer
    Boolean update(Freelancer freelancer) throws SQLException;
    
    // Delete Freelancer
    Boolean deleteByRIB(Long freelancer_RIB) throws SQLException;
    
    // authentifier Freelancer
    Freelancer authentifier(String email,String password) throws SQLException;

}
