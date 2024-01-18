package com.btssio.ozenne.vanille.controller

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.btssio.ozenne.vanille.R
import com.btssio.ozenne.vanille.model.Commande
import com.btssio.ozenne.vanille.model.Promotion
import com.btssio.ozenne.vanille.repository.CatalogueRepository
import java.time.LocalDate

class ProduitActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    val commandeEnCours = Commande
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produit)
        //simulation de la selection d'un produit
        //val chocolats = Categorie("cho", "Chocolats")
        //val produitSelectionne = Produit("B003", "Bonbons chocolat lot de 3 kg", " ", 3.0F,chocolats)

        val bundle : Bundle? = intent.extras
        val pos : Int = bundle?.getInt("index")?:0
        val produitSelectionne = CatalogueRepository.RecupererLeCatalogue(this).get(pos)

        //liaision avec les élements de l'interface
        val txtPu = findViewById<TextView>(R.id.produitTxtPU)
        val editQuantite = findViewById<EditText>(R.id.editQuantite)
        val btCalculer = findViewById<Button>(R.id.btCalculer)
        val txtTotal = findViewById<TextView>(R.id.labelTotalCalc)
        val txtProduit = produitSelectionne.description
        val txtTitre = findViewById<TextView>(R.id.labelTitre)
        val txtPromo = findViewById<TextView>(R.id.labelPromo)
        val btAjouter = findViewById<Button>(R.id.btAjouter)
        val btRevenir = findViewById<Button>(R.id.btRevenir)
        val btTerminer = findViewById<Button>(R.id.btTerminer)
        val currentDate = LocalDate.now()
        val prixApresRemise = produitSelectionne.getPrixApresRemise(currentDate)
        txtTitre.text = txtProduit.toString()
        txtPu.text = String.format("%.2f €", prixApresRemise)
        txtPromo.text = produitSelectionne.getPromoEtPrixHabituel(currentDate)


        //gestion du clic sur le bouton calculer
        btCalculer.setOnClickListener {
            val qte = if (editQuantite.text.isEmpty()) 0 else editQuantite.text.toString().toInt()
            val total = prixApresRemise * qte
            txtTotal.text = String.format("%.2f €", total)
        }

        btTerminer.setOnClickListener() {
            val intention = Intent(this, FactureActivity::class.java)
            startActivity(intention)
            finish()
        }

        btRevenir.setOnClickListener() {
            val intention = Intent(this, ListeProduitsActivity::class.java)
            startActivity(intention)
            finish()
        }

        btAjouter.setOnClickListener(){
            val quantite = editQuantite.text.toString().toInt()
            if (quantite == 0 ){
                Toast.makeText(this@ProduitActivity, "Erreur ! Impossible d'enregistrer la commande ", Toast.LENGTH_LONG).show()
            }
            else if(editQuantite.text.isEmpty()){
                Toast.makeText(this@ProduitActivity, "Erreur ! Impossible d'enregistrer la commande ", Toast.LENGTH_LONG).show()
            }
            else{0
                commandeEnCours.lignesCommande[produitSelectionne] = quantite

                // Afficher un Toast pour indiquer que le produit a été ajouté à la commande
                val toastMessage = "Produit ajouté à la commande : ${produitSelectionne.description} (Quantité : $quantite)"
                Toast.makeText(this@ProduitActivity, toastMessage, Toast.LENGTH_SHORT).show()
            }


            Log.i("ajouter", commandeEnCours.toString())

        }
    }
}