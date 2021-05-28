package com.marie.todolist.models;

public class Tache {

    private long id;
    private String titreTache;
    private String dateCreation;
    private String importance;
    private int finit;

    public Tache( String titreTache, String dateCreation, String importance, int finit) {
        this.id = 0;
        this.titreTache = titreTache;
        this.dateCreation = dateCreation;
        this.importance = importance;
        this.finit = finit;
    }
    // constructeur
    public Tache(long id, String titreTache, String dateCreation, String importance, int finit) {
        this(titreTache,dateCreation,importance,finit);
        this.id = id;

    }
    // getters and setters
    public String getTitreTache() { return titreTache; }
    public void setTitreTache(String titreTache) { this.titreTache = titreTache; }
    public String getDateCreation() { return dateCreation; }
    public void setDateCreation(String dateCreation) { this.dateCreation = dateCreation; }
    public String getImportance() { return importance; }
    public void setImportance(String importance) { this.importance = importance; }
    public int getFinit() { return finit; }
    public void setFinit(int finit) { this.finit = finit; }
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }


    @Override
    public String toString() {
        return "Tache{" +
                "titreTache='" + titreTache + '\'' +
                ", dateCreation='" + dateCreation + '\'' +
                ", importance=" + importance +
                ", estFini=" + finit +
                '}';
    }
}
