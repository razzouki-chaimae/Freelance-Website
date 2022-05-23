package DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import DAO.EntrepriseDAO;
import DAO.factory.Factory;
import model.Entreprise;
import model.Freelancer;

public class EntrepriseDAOImpl implements EntrepriseDAO {
    
    static Connection con = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    @Override
    public Boolean add(Entreprise entreprise) throws SQLException {
        String query="INSERT INTO entreprise (nomEntreprise, emailEntreprise, numeroTelephone, adressePhysique, domaine, password, rib) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?);";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        ps.setString(1, entreprise.getNomEntreprise());
        ps.setString(2, entreprise.getEmailEntreprise());
        ps.setString(3, entreprise.getNumeroTelephone());
        ps.setString(4, entreprise.getAdressePhysique());
        ps.setString(5, entreprise.getDomaine());
        ps.setString(6, entreprise.getPassword());
        ps.setLong(7, entreprise.getRib());
        int row = ps.executeUpdate();
        con.close();
        return row > 0;
    }

    @Override
    public Entreprise getOneByRIB(Long entreprise_RIB) throws SQLException {
        Entreprise entreprise = new Entreprise();
        String query="SELECT * FROM entreprise WHERE `rib` = ?";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        ps.setLong(1, entreprise_RIB);
        rs=ps.executeQuery();
        rs.next();
        entreprise.setNomEntreprise(rs.getString("nomEntreprise"));
        entreprise.setEmailEntreprise(rs.getString("emailEntreprise"));
        entreprise.setNumeroTelephone(rs.getString("numeroTelephone"));
        entreprise.setAdressePhysique(rs.getString("adressePhysique"));
        entreprise.setDomaine(rs.getString("domaine"));
        entreprise.setPassword(rs.getString("password"));
        entreprise.setRib(rs.getLong("rib"));
        con.close();
        return entreprise;
    }

    @Override
    public Set<Entreprise> getAll() throws SQLException {
        Set<Entreprise> entreprises = new HashSet<Entreprise>();
        String query="SELECT * FROM entreprise";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        rs=ps.executeQuery();
        while(rs.next()) {
            Entreprise entreprise = new Entreprise();
            entreprise.setNomEntreprise(rs.getString("nomEntreprise"));
            entreprise.setEmailEntreprise(rs.getString("emailEntreprise"));
            entreprise.setNumeroTelephone(rs.getString("numeroTelephone"));
            entreprise.setAdressePhysique(rs.getString("adressePhysique"));
            entreprise.setDomaine(rs.getString("domaine"));
            entreprise.setPassword(rs.getString("password"));
            entreprise.setRib(rs.getLong("rib"));
            entreprises.add(entreprise);
        }
        con.close();
        return entreprises;
    }

    @Override
    public Boolean update(Entreprise entreprise) throws SQLException {
        String query = "UPDATE entreprise SET nomEntreprise = ?, emailEntreprise = ?, numeroTelephone = ?, adressePhysique = ?, domaine = ?, password = ? WHERE rib = ?";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        ps.setString(1, entreprise.getNomEntreprise());
        ps.setString(2, entreprise.getEmailEntreprise());
        ps.setString(3, entreprise.getNumeroTelephone());
        ps.setString(4, entreprise.getAdressePhysique());
        ps.setString(5, entreprise.getDomaine());
        ps.setString(6, entreprise.getPassword());
        ps.setLong(7, entreprise.getRib());
        int row = ps.executeUpdate();
        con.close();
        return row > 0;
    }

    @Override
    public Boolean deleteByRIB(Long entreprise_RIB) throws SQLException {
        String query = "DELETE FROM entreprise WHERE rib=?";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        ps.setLong(1, entreprise_RIB);
        int row = ps.executeUpdate();
        con.close();
        return row > 0;
    }

    @Override
    public Entreprise authentifier(String email, String password) throws SQLException {
        Entreprise entreprise = null;
        String query="SELECT * FROM entreprise WHERE emailEntreprise like ? AND password like ?";
        con=Factory.dbConnect();
        ps=con.prepareStatement(query);
        ps.setString(1, email);
        ps.setString(2, password);
        rs=ps.executeQuery();
        if(rs.next()) {
            entreprise = new Entreprise();
            entreprise.setNomEntreprise(rs.getString("nomEntreprise"));
            entreprise.setEmailEntreprise(rs.getString("emailEntreprise"));
            entreprise.setNumeroTelephone(rs.getString("numeroTelephone"));
            entreprise.setAdressePhysique(rs.getString("adressePhysique"));
            entreprise.setDomaine(rs.getString("domaine"));
            entreprise.setPassword(rs.getString("password"));
            entreprise.setRib(rs.getLong("rib"));
        }
        con.close();
        return entreprise;
    }

}