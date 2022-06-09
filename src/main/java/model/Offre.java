package model;

public class Offre {
    
    private int projectId;
    private String titre;
    private String description;
    private double budget;
    private int deadline;
    private String skills;
    private Long entreprise;
    private Long freelancer;
    boolean done;
    
    public Offre() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Offre(int projectId, String titre, String description, double budget, int deadline, String skills,
            Long entreprise, Long freelancer) {
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
    public Offre(String titre, String description, double budget, int deadline, String skills,
            Long entreprise, Long freelancer) {
        super();
        this.titre = titre;
        this.description = description;
        this.budget = budget;
        this.deadline = deadline;
        this.skills = skills;
        this.entreprise = entreprise;
        this.freelancer = freelancer;
    }
    public Offre(int projectId, String titre, String description, double budget, int deadline, String skills,
            Long entreprise, Long freelancer, boolean done) {
        super();
        this.projectId = projectId;
        this.titre = titre;
        this.description = description;
        this.budget = budget;
        this.deadline = deadline;
        this.skills = skills;
        this.entreprise = entreprise;
        this.freelancer = freelancer;
        this.done = done;
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
    public Long getEntreprise() {
        return entreprise;
    }
    public void setEntreprise(Long entreprise) {
        this.entreprise = entreprise;
    }
    public Long getFreelancer() {
        return freelancer;
    }
    public void setFreelancer(Long freelancer) {
        this.freelancer = freelancer;
    }
    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
    @Override
    public String toString() {
        return "Offre [projectId=" + projectId + ", titre=" + titre + ", description=" + description + ", budget="
                + budget + ", deadline=" + deadline + ", skills=" + skills + ", entreprise=" + entreprise
                + ", freelancer=" + freelancer + "]";
    }
}
