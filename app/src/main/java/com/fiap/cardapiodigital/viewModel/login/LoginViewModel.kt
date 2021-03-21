package com.fiap.cardapiodigital.viewModel.login

import androidx.lifecycle.ViewModel
import com.fiap.cardapiodigital.domain.helpers.DomainError
import com.fiap.cardapiodigital.domain.usecases.login.CheckUserIsLoggedContract
import com.fiap.cardapiodigital.domain.usecases.login.MakeLoginContract

class LoginViewModel (
    private val contract: LoginContract,
    private val checkUserIsLogged: CheckUserIsLoggedContract,
    private val makeLogin: MakeLoginContract) : ViewModel(){

    var email: String = ""
    var password: String = ""

    fun onCreate() {
        if (checkUserIsLogged.execute()) {
            contract.goToMainActivity()
        }
    }

    fun onLoginPressed() {
        makeLogin.execute(email, password, {
            contract.goToMainActivity()
        }, { error ->
            when (error) {
                DomainError.GENERIC_ERROR -> contract.showGenericErrorMessage()
            }
        })

    }

    fun onSignUpPressed() {
        contract.goToSignUpActivity()
    }


}