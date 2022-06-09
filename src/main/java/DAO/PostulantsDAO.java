package DAO;

import java.sql.SQLException;
import java.util.Set;

import model.Postulant;


public interface PostulantsDAO {

    // Create Postulant
    Boolean add(Postulant postulant) throws SQLException;
    
    // Read Postulant
    Boolean isExist(Postulant postulant) throws SQLException;
    Set<Postulant> getAllByOffre(int offre) throws SQLException;
    Set<Postulant> getAllByFreelancer(Long freelancer) throws SQLException;
    
    // Update Postulant
    //Boolean update(Postulant postulant) throws SQLException;
    
    // Delete Postulant
    Boolean deleteAllByOffre(int offre) throws SQLException;
    Boolean deleteAllByFreelancer(Long freelancer) throws SQLException;
    
}
