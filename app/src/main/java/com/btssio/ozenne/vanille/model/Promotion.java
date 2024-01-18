package com.btssio.ozenne.vanille.model;
import java.time.LocalDate;
public class Promotion {

    /**
     *
     * @param id
     * @param libelle
     * @param debutPromo
     * @param finPromo
     * @param remise
     */
    public Promotion(String id, String libelle, LocalDate debutPromo, LocalDate finPromo, float remise) {
        super();
        this.id = id;
        this.libelle = libelle;
        this.debutPromo = debutPromo;
        this.finPromo = finPromo;
        this.remise = remise;
    }

    private String id;
    private String libelle;
    private LocalDate debutPromo;
    private LocalDate finPromo;
    private float remise;

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

    public LocalDate getDebutPromo() {
        return debutPromo;
    }

    public void setDebutPromo(LocalDate debutPromo) {
        this.debutPromo = debutPromo;
    }

    public LocalDate getFinPromo() {
        return finPromo;
    }

    public void setFinPromo(LocalDate finPromo) {
        this.finPromo = finPromo;
    }

    public float getRemise() {
        return remise;
    }

    public void setRemise(float remise) {
        this.remise = remise;
    }

}