package com.fiap.cardapiodigital.domain.usecases.signUp

import com.fiap.cardapiodigital.domain.helpers.DomainError

interface MakeSignUpContract {
    fun execute(
        name: String,
        email: String,
        password: String,
        onSuccessListener: () -> Unit,
        onFailureListener: (DomainError) -> Unit
    )
}