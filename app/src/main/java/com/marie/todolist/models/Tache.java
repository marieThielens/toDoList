package com.marie.todolist.models;

public class Tache {

    public enum Importance {
        IMPORTANT,
        FAIBLE
    };

    private int id;
    private String titreTache;
    private String dateCreation;
    private Importance importance;
    private boolean estFini;

    // constructeur
    public Tache(int id, String titreTache, String dateCreation, Importance importance, boolean estFini) {
        this.id = id;
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
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }


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
