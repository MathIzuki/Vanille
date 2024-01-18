package com.btssio.ozenne.vanille.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Catalogue {
    /**
     *
     * @param id
     * @param titre
     * @param dateEdition
     */
    public Catalogue(String id, String titre, LocalDate dateEdition) {
        super();
        this.id = id;
        this.titre = titre;
        this.dateEdition = dateEdition;
        this.lesProduits = new ArrayList<>();
    }

    private String id;
    private String titre;
    private LocalDate dateEdition;
    private List<Produit> lesProduits;

    public List<Produit> getLesProduitsCategorie(Categorie categorieRecherchee) {
        List<Produit> produitsCategorie = new ArrayList<>();

        for (Produit produit : lesProduits) {
            if (produit.getCategorieDuProduit().equals(categorieRecherchee)) {
                produitsCategorie.add(produit);
            }
        }

        // Sort the products using Collections.sort and the natural order (compareTo) of Produit
        Collections.sort(produitsCategorie);

        return produitsCategorie;
    }

    /**

     * renvoi le produit correspondant à l'id passé en parametre
     * @param id : identifiant du produit
     * @param produitTrouve : produit recherche , null si pas trouvé
     * @return : index du produit dans la liste (-1 si pas trouvé)
     */
    public int getProduit(String id, Produit[] produitTrouve) {
        for (int i = 0; i < lesProduits.size(); i++) {
            if (lesProduits.get(i).getId().equals(id)) {
                produitTrouve[0] = lesProduits.get(i);
                return i;
            }
        }
        return -1;
    }

    /**
     * ajoute un produit à la liste s'il n'est pas déjà référencé
     * @param unProduit
     * @return renvoie true si le produit a pu être ajouté false dans le cas contraire
     */
    public boolean ajouterUnProduit(Produit unProduit) {
        if (!lesProduits.contains(unProduit)) {
            lesProduits.add(unProduit);
            return true;
        }
        return false;
    }

    /**
     * Supprime un produit de la liste s'il existe
     * @param unProduit : produit à supprimer
     * @return true si le produit a pu être supprimé, false dans le cas contraire
     */
    public boolean supprimerUnProduit(Produit unProduit) {
        if (lesProduits.contains(unProduit)) {
            lesProduits.remove(unProduit);
            return true;
        }
        return false;
    }

    /**
     * Modifie un produit de la liste s'il existe
     * @param unProduit : produit modifié
     * @return true si le produit a pu être modifié, false dans le cas contraire
     */
    public boolean modifierUnProduit(Produit unProduit) {
        for (Produit produitCourant : lesProduits) {
            if (produitCourant.getId().equals(unProduit.getId())) {
                // Si les identifiants sont égaux, remplace le produit existant par le nouveau
                lesProduits.set(lesProduits.indexOf(produitCourant), unProduit);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public LocalDate getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(LocalDate dateEdition) {
        this.dateEdition = dateEdition;
    }

    public List<Produit> getLesProduits() {
        return lesProduits;
    }

    public void setLesProduits(List<Produit> lesProduits) {
        this.lesProduits = lesProduits;
    }

}