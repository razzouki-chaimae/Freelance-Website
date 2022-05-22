package DAO;

import java.sql.SQLException;
import java.util.Set;

import model.Entreprise;

public interface EntrepriseDAO {
    
    // Create Entreprise
    Boolean add(Entreprise entreprise) throws SQLException;
    
    // Read Entreprise
    Entreprise getOneByRIB(Long entreprise_RIB) throws SQLException;
    Set<Entreprise> getAll() throws SQLException;
    
    // Update Entreprise
    Boolean update(Entreprise entreprise) throws SQLException;
    
    // Delete Entreprise
    Boolean deleteByRIB(Long entreprise_RIB) throws SQLException;
    
    // authentifier
    Entreprise authentifier(String email,String password) throws SQLException;

}
