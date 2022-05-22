package model;

public class Offre {
    
    private int projectId;
    private String titre;
    private String description;
    private double budget;
    private int deadline;
    private String skills;
    private int entreprise;
    private int freelancer;
    
    public Offre() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Offre(int projectId, String titre, String description, double budget, int deadline, String skills,
            int entreprise, int freelancer) {
        super();
        this.projectId = projectId;
        this.titre = titre;
        this.description = description;
        this.budget = budget;
        this.deadline = deadline;
        this.skills = skills;
        this.entreprise = entreprise;
        this.freelancer = freelancer;
    }
    
    public int getProjectId() {
        return projectId;
    }
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getBudget() {
        return budget;
    }
    public void setBudget(double budget) {
        this.budget = budget;
    }
    public int getDeadline() {
        return deadline;
    }
    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }
    public String getSkills() {
        return skills;
    }
    public void setSkills(String skills) {
        this.skills = skills;
    }
    public int getEntreprise() {
        return entreprise;
    }
    public void setEntreprise(int entreprise) {
        this.entreprise = entreprise;
    }
    public int getFreelancer() {
        return freelancer;
    }
    public void setFreelancer(int freelancer) {
        this.freelancer = freelancer;
    }

}
