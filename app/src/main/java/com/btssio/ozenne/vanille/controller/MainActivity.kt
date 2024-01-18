package com.btssio.ozenne.vanille.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.btssio.ozenne.vanille.R
import com.btssio.ozenne.vanille.model.Commande

class MainActivity : AppCompatActivity() {
    // Déclaration d'une propriété 'commandeEnCours' de type Commande
    val commandeEnCours = Commande
    // Méthode appelée lors de la création de l'activité
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Définition du layout de l'activité en utilisant le fichier XML 'activity_main'
        setContentView(R.layout.activity_main)
        // Affichage d'un message Toast indiquant la date de la commande en cours

        Toast.makeText(
            this.applicationContext,
            "Commande du ${commandeEnCours.dateCommande} annulée, retour à la page d'accueil",
            LENGTH_LONG
        ).show()
        val btnAccess = findViewById<Button>(R.id.btAccees)
        btnAccess.setOnClickListener() {
            val intention = Intent(this, ListeProduitsActivity::class.java)
            startActivity(intention)
            finish()
        }
    }


}