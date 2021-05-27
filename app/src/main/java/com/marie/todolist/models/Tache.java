package com.marie.todolist.models;

public class Tache {

    public enum Importance {
        IMPORTANT,
        FAIBLE
    };

    private String titreTache;
    private String dateCreation;
    private Importance importance;
    private boolean estFini;

    // constructeur
    public Tache(String titreTache, String dateCreation, Importance importance, boolean estFini) {
        this.titreTache = titreTache;
        this.dateCreation = dateCreation;
        this.importance = importance;
        this.estFini = estFini;
    }
    // getters and setters
    public String getTitreTache() { return titreTache; }
    public void setTitreTache(String titreTache) { this.titreTache = titreTache; }
    public String getDateCreation() { return dateCreation; }
    public void setDateCreation(String dateCreation) { this.dateCreation = dateCreation; }
    public Importance getImportance() { return importance; }
    public void setImportance(Importance importance) { this.importance = importance; }
    public boolean isEstFini() { return estFini; }
    public void setEstFini(boolean estFini) { this.estFini = estFini; }

    @Override
    public String toString() {
        return "Tache{" +
                "titreTache='" + titreTache + '\'' +
                ", dateCreation='" + dateCreation + '\'' +
                ", importance=" + importance +
                ", estFini=" + estFini +
                '}';
    }
}
