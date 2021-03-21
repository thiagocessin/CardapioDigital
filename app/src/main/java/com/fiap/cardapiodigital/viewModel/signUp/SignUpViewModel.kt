package com.fiap.cardapiodigital.viewModel.signUp

import androidx.lifecycle.ViewModel
import com.fiap.cardapiodigital.domain.usecases.signUp.MakeSignUpContract

class SignUpViewModel (
    private val contract: SignUpContract,
    private val makeSignUp: MakeSignUpContract
) : ViewModel(){

    var name = ""
    var email = ""
    var password = ""

    fun onSignUpPressed() {
        makeSignUp.execute(
            name,
            email,
            password,
            {
                contract.goToMainActivity()
            },
            { error ->
                contract.showGenericErrorMessage()
            }
        )
    }

}