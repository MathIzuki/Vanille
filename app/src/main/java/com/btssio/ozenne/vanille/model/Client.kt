package com.btssio.ozenne.vanille.model

import java.io.Serializable

// Déclaration de la classe Client.
data class Client(val _nom : String,
                  val _prenom : String,
                  var adresse : String,
                  var mail: String): Serializable{
    // Déclaration de la classe de données Client avec ses propriétés.

    var nom: String = if (Regex("[a-zA-Z]+").matches(_nom)) _nom else "inconnu"
        // La propriété nom est initialisée avec la valeur de _nom si elle correspond à la regex [a-zA-Z], sinon "inconnu".
        get() = field.uppercase()
    // Lors de l'accès à la propriété nom, elle est retournée en majuscules.

        set(value){
            // Lors de la modification de la propriété nom, la nouvelle valeur est vérifiée par une regex.
            val pattern = "[a-zA-Z]+"
            field = if (Regex(pattern).matches(value)){
                value }
            else{
                "inconnu"}
        }

    var prenom: String = _prenom
        // La propriété prenom est initialisée avec la valeur de _prenom.
        get()= field.replaceFirstChar { it.uppercase() }
    // Lors de l'accès à la propriété prenom, le premier caractère est converti en majuscule.

        set(value){
            // Lors de la modification de la propriété prenom, la nouvelle valeur est directement assignée.
            field = value;
        }
}

