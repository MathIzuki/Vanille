package com.btssio.ozenne.vanille.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.content.Intent
import android.widget.ListView
import com.btssio.ozenne.vanille.R
import com.btssio.ozenne.vanille.model.Produit
import com.btssio.ozenne.vanille.repository.CatalogueRepository

class ListeProduitsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste_produits)
        val listeV = findViewById<ListView>(R.id.listeProduitsListV)
        var lesProduits = CatalogueRepository.RecupererLeCatalogue(this) as MutableList<Produit>
        val itemsAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lesProduits)
        listeV.setAdapter(itemsAdapter)

        listeV.setOnItemClickListener(){parent, view, position, id ->
            val intention = Intent(this, ProduitActivity::class.java)
            intention.putExtra("index", position)
            startActivity(intention)
        }
    }
}