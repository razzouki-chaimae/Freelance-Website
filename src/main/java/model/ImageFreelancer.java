package model;

public class ImageFreelancer {
    
    private String urlImange;
    private long ribFreelancer;
    
    public ImageFreelancer() {
        super();
    }

    public ImageFreelancer(String urlImange, long ribFreelancer) {
        super();
        this.urlImange = urlImange;
        this.ribFreelancer = ribFreelancer;
    }

    public String getUrlImange() {
        return urlImange;
    }

    public void setUrlImange(String urlImange) {
        this.urlImange = urlImange;
    }

    public long getRibFreelancer() {
        return ribFreelancer;
    }

    public void setRibFreelancer(long ribFreelancer) {
        this.ribFreelancer = ribFreelancer;
    } 

}
