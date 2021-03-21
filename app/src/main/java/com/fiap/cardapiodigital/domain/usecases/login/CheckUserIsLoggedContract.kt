package com.fiap.cardapiodigital.domain.usecases.login

interface CheckUserIsLoggedContract {
    fun execute(): Boolean
}