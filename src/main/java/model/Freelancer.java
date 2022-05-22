package model;

public class Freelancer {
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String adressePhysique;
    private String profession;
    private String description;
    private int rib;
    
    public Freelancer() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Freelancer(String nom, String prenom, String email, String password, String adressePhysique,
            String profession, String description, int rib) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.adressePhysique = adressePhysique;
        this.profession = profession;
        this.description = description;
        this.rib = rib;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAdressePhysique() {
        return adressePhysique;
    }
    public void setAdressePhysique(String adressePhysique) {
        this.adressePhysique = adressePhysique;
    }
    public String getProfession() {
        return profession;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getRib() {
        return rib;
    }
    public void setRib(int rib) {
        this.rib = rib;
    }

}
