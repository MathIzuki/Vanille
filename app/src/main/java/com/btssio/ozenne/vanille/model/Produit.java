package com.btssio.ozenne.vanille.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Produit implements Comparable<Produit>{

    /**
     *
     * @param id
     * @param description
     * @param image
     * @param prix
     * @param categorieDuProduit
     */
    public Produit(String id, String description, String image, float prix, Categorie categorieDuProduit) {
        super();
        this.id = id;
        this.description = description;
        this.image = image;
        this.prix = prix;
        this.categorieDuProduit = categorieDuProduit;
        this.lesPromos = new ArrayList<>();
    }

    private String id;
    private String description;
    private String image;
    private float prix;
    private Categorie categorieDuProduit;
    private List<Promotion> lesPromos;


    @Override
    public String toString() {
        return id + " " + description;
    }

    public boolean getPromo(LocalDate date, Promotion[] promo) {
        promo[0] = null;
        boolean result = false;
        int i = 0;
        while ((i < lesPromos.size()) && (promo[0] == null)) {
            if ((lesPromos.get(i).getDebutPromo().compareTo(date) <= 0) && (lesPromos.get(i).getFinPromo().compareTo(date) >= 0)) {
                promo[0] = lesPromos.get(i);
                result = true;
            }
            i++;
        }
        return result;
    }

    /**
     * renvoie l'id la description et le prix du produit correspondant à la date
     * affiche le prix promotionnel suivi du mot PROMO lorsque le produit est en promotion
     * @param date date de prise en compte du prix du produit
     * @return chaine représentant le produit
     */
    public String toString(LocalDate date) {
        String chaine = this.toString();
        Promotion[] promo = new Promotion[1];
        if (this.getPromo(date, promo)) {
            chaine += " " + String.format("%.2f", prix * (1 - promo[0].getRemise())) + " € " + "PROMO";
        } else {
            chaine += " " + String.format("%.2f", prix) + " €";
        }
        return chaine;
    }



    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    @Override
    public int compareTo(Produit o) {
        return this.description.compareTo(o.getDescription());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Categorie getCategorieDuProduit() {
        return categorieDuProduit;
    }

    public void setCategorieDuProduit(Categorie categorieDuProduit) {
        this.categorieDuProduit = categorieDuProduit;
    }

    public List<Promotion> getLesPromos() {
        return lesPromos;
    }

    public void setLesPromos(List<Promotion> lesPromos) {
        this.lesPromos = lesPromos;
    }

}
