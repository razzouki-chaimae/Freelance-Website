package model;

public class Postulant {
    
    private int offre;
    private long freelancer;
    
    public Postulant() {
        super();
    }

    public Postulant(int offre, long freelancer) {
        super();
        this.offre = offre;
        this.freelancer = freelancer;
    }

    public int getOffre() {
        return offre;
    }

    public void setOffre(int offre) {
        this.offre = offre;
    }

    public long getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(long freelancer) {
        this.freelancer = freelancer;
    }

}
