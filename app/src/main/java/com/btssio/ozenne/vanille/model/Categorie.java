package com.btssio.ozenne.vanille.model;

public class Categorie {

    /**
     *
     * @param id
     * @param libelle
     */
    public Categorie(String id, String libelle) {
        super();
        this.id = id;
        this.libelle = libelle;
    }

    private String id;
    private String libelle;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}