package com.fiap.cardapiodigital.data.login.usecases

import com.fiap.cardapiodigital.domain.helpers.DomainError
import com.fiap.cardapiodigital.domain.usecases.login.MakeLoginContract
import com.google.firebase.auth.FirebaseAuth

class MakeLogin (
    private val auth: FirebaseAuth
) : MakeLoginContract{


    override fun execute(
        email: String,
        password: String,
        onSuccessListener: () -> Unit,
        onFailureListener: (DomainError) -> Unit
    ) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                onSuccessListener()
            }
            .addOnFailureListener {
                onFailureListener(DomainError.GENERIC_ERROR)
            }
    }


}