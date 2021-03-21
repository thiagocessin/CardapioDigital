package com.fiap.cardapiodigital.data.login.usecases

import com.fiap.cardapiodigital.domain.usecases.login.CheckUserIsLoggedContract
import com.google.firebase.auth.FirebaseAuth

class CheckUserIsLogged (
    private val auth: FirebaseAuth
) : CheckUserIsLoggedContract{

    override fun execute(): Boolean {
        return auth.currentUser != null
    }

}