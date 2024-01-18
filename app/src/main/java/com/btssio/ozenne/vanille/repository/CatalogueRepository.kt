package com.btssio.ozenne.vanille.repository

import android.content.Context
import com.btssio.ozenne.vanille.model.Categorie
import com.btssio.ozenne.vanille.model.Produit
import com.btssio.ozenne.vanille.model.Promotion
import java.time.LocalDate


abstract class CatalogueRepository {

    companion object Factory{
        fun RecupererLeCatalogue(context: Context?): List<Produit> {

            //simulation de récupération du catalogue
            val lesProduits: MutableList<Produit> = ArrayList()
            val bonbons = Categorie("bon", "Bonbons")
            val chocolats = Categorie("cho", "Chocolats")
            val date = LocalDate.now()
            val debDate = LocalDate.now().minusDays(2)
            val finDate = LocalDate.now().plusDays(10)
            val produit1 = Produit("B001", "Bonbons acidulés Lot 1 Kg", " ", 2.2.toFloat(), bonbons)
            val promotion = Promotion("hal", "Promotion pour Halloween", debDate, finDate, 0.2f)
            produit1.lesPromos.add(promotion)
            lesProduits.add(produit1)
            val produit2 = Produit("B002", "Bonbons glacés Lot 2 Kg", " ", 4.4.toFloat(), bonbons)
            lesProduits.add(produit2)
            val produit3 = Produit("B003", "Bonbons chocolat Lot 3 Kg", " ", 3.0.toFloat(), chocolats)
            lesProduits.add(produit3)
            val produit4 = Produit("B004", "Bonbons caramel Lot 4 Kg", " ", 5.0.toFloat(), bonbons)
            lesProduits.add(produit4)
            val produit5 = Produit("B005", "Bonbons acidulés Lot 5 Kg", " ", 1.0.toFloat(), bonbons)
            lesProduits.add(produit5)
            lesProduits[1].lesPromos.add(promotion)
            return lesProduits
        }
    }
}