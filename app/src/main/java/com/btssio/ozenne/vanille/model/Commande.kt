package com.btssio.ozenne.vanille.model

import java.time.LocalDate

object Commande {
    var id: Int = 0
    var leClient: Client? = null
    var dateCommande: LocalDate = LocalDate.now()
    val lignesCommande: HashMap<Produit, Int> = HashMap()

    /*init {

        // Création d'une catégorie
        //val bonbons = Categorie("bon", "bonbons")

        // Ajout de lignes à la commande
        lignesCommande[Produit("B004", "Bonbons caramel Lot 4 Kg", "", 5.0.toFloat(), bonbons)] = 10
        lignesCommande[Produit("B005", "Bonbons acidulés Lot 5 Kg", "", 1.0.toFloat(), bonbons)] = 2
    } */

    fun getTotalCommande(): Float {
        var total: Float = 0.0.toFloat()

        // Parcours de la map (dictionnaire)
        for ((produit, quantite) in lignesCommande) {
            // Calcul du prix total pour chaque produit
            total += produit.prix * quantite
        }

        return total
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("Commande id: $id\n")
        stringBuilder.append("Client: ${leClient?.nom}\n")
        stringBuilder.append("Date de commande: $dateCommande\n")
        stringBuilder.append("Lignes de commande:\n")

        for ((produit, quantite) in lignesCommande) {
            stringBuilder.append("   ${produit.description} (Catégorie: ${produit.categorieDuProduit.libelle}) - Prix unitaire: ${produit.prix}, Quantité: $quantite\n")
        }
        stringBuilder.append("Total de la commande: ${getTotalCommande()}")

        return stringBuilder.toString()
    }


}
