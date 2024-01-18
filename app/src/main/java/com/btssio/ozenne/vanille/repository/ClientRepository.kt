package com.btssio.ozenne.vanille.repository

import android.content.Context
import com.btssio.ozenne.vanille.model.Client
import com.btssio.ozenne.vanille.outils.Serializer

private val nomFichier = "saveClient"

abstract class ClientRepository {

    companion object Factory{
        fun enregistrerLeClient(leClient: Client, context: Context){
            Serializer.serialize(nomFichier, leClient, context)
        }

        fun recupererLeClient(context : Context): Client? {
            return Serializer.deSerialize(nomFichier,context) as Client?
        }

        fun effacerLeClient(context: Context) {
            context.deleteFile(nomFichier)
        }
    }
}