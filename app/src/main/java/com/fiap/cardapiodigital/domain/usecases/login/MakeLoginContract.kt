package com.fiap.cardapiodigital.domain.usecases.login

import com.fiap.cardapiodigital.domain.helpers.DomainError

interface MakeLoginContract {
    fun execute(email: String,
                password: String,
                onSuccessListener: () -> Unit,
                onFailureListener: (DomainError) -> Unit)
}