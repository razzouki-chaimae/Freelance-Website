package DAO;

import java.sql.SQLException;
import java.util.Set;

import model.Offre;

public interface OffreDAO {
    
    // Create Offre
    Boolean add(Offre offre) throws SQLException;
    
    // Read Offre
    Offre getOneById(int projectId) throws SQLException;
    Set<Offre> getAll() throws SQLException;
    
    // Update Entreprise
    Boolean update(Offre offre) throws SQLException;
    
    // Delete Entreprise
    Boolean deleteById(int projectId) throws SQLException;

}
