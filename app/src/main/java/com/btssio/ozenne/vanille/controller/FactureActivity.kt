package com.btssio.ozenne.vanille.controller

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.btssio.ozenne.vanille.R
import com.btssio.ozenne.vanille.model.Client
import com.btssio.ozenne.vanille.model.Commande
import com.btssio.ozenne.vanille.repository.ClientRepository

class FactureActivity : AppCompatActivity() {
    val commandeEnCours = Commande
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facture)
        val btAnnuler = findViewById<Button>(R.id.factureBtAnnuler)
        val editNom = findViewById<EditText>(R.id.factureEditNom)
        val editMail = findViewById<EditText>(R.id.factureEditMail)
        val editPrenom = findViewById<EditText>(R.id.factureEditPrenom)
        val editAdresse = findViewById<EditText>(R.id.factureEditAdresse)
        var txtMontant = findViewById<TextView>(R.id.factureTxtMontant)
        val btValider = findViewById<Button>(R.id.factureBtValider)
        val btModifier = findViewById<Button>(R.id.factureBtModifier)

        txtMontant.text = String.format("%.2f €", commandeEnCours.getTotalCommande())
        //récupération du client
        val leClientRecupere = ClientRepository.recupererLeClient(this)
        Log.i("Client récupéré", leClientRecupere.toString())
        editNom.setText(leClientRecupere?.nom ?: "")
        editPrenom.setText(leClientRecupere?.prenom ?: "")
        editAdresse.setText(leClientRecupere?.adresse ?: "")
        editMail.setText(leClientRecupere?.mail ?: "")


        btValider.setOnClickListener {
            // Récupération des informations saisies par l'utilisateur
            val nom = editNom.text.toString()
            val prenom = editPrenom.text.toString()
            val adresse = editAdresse.text.toString()
            val mail = editMail.text.toString()

            // Création d'un client avec les informations saisies
            val nouveauClient = Client(nom, prenom, adresse, mail)

            // Ajout du client à la commande
            commandeEnCours.leClient = nouveauClient
            ClientRepository.enregistrerLeClient(nouveauClient,this)
            Log.i("Client enregistré", nouveauClient.toString())

            // Récupération du montant de la commande
            val montantCommande = commandeEnCours.getTotalCommande()

            // Création et affichage du Toast
            val toastMessage = "Votre commande d'un montant de " + String.format("%.2f € ", montantCommande) + "a bien été envoyée ! " +
                    "Vous recevrez un mail de confirmation à l'adresse suivant : " + nouveauClient.mail
            Toast.makeText(this@FactureActivity, toastMessage, Toast.LENGTH_SHORT).show()
            Log.i("Valider","onClick"+ commandeEnCours.leClient.toString())


        }

        btAnnuler.setOnClickListener() {
            // Effacer les informations du client
            val intention = Intent(this, MainActivity::class.java)
            commandeEnCours.lignesCommande.clear()
            startActivity(intention)
            finish()
        }

        btModifier.setOnClickListener() {
            val intention = Intent(this, ListeProduitsActivity::class.java)
            startActivity(intention)
            finish()
        }



    }
}