package model;

public class Entreprise {
    
    private String nomEntreprise;
    private String emailEntreprise;
    private String password;
    private String numeroTelephone;
    private String adressePhysique;
    private String domaine;
    private long rib ;
    
    public Entreprise() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Entreprise(String nomEntreprise, String emailEntreprise, String password, String numeroTelephone,
            String adressePhysique, String domaine, long rib) {
        super();
        this.nomEntreprise = nomEntreprise;
        this.emailEntreprise = emailEntreprise;
        this.password = password;
        this.numeroTelephone = numeroTelephone;
        this.adressePhysique = adressePhysique;
        this.domaine = domaine;
        this.rib = rib;
    }
    
    public String getNomEntreprise() {
        return nomEntreprise;
    }
    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }
    public String getEmailEntreprise() {
        return emailEntreprise;
    }
    public void setEmailEntreprise(String emailEntreprise) {
        this.emailEntreprise = emailEntreprise;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNumeroTelephone() {
        return numeroTelephone;
    }
    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }
    public String getAdressePhysique() {
        return adressePhysique;
    }
    public void setAdressePhysique(String adressePhysique) {
        this.adressePhysique = adressePhysique;
    }
    public String getDomaine() {
        return domaine;
    }
    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }
    public long getRib() {
        return rib;
    }
    public void setRib(long rib) {
        this.rib = rib;
    }

}
