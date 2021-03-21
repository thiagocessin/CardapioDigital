package com.fiap.cardapiodigital.main.di

import com.fiap.cardapiodigital.data.login.usecases.CheckUserIsLogged
import com.fiap.cardapiodigital.data.login.usecases.MakeLogin
import com.fiap.cardapiodigital.data.produtocardapio.usecases.GetProdutosCardapio
import com.fiap.cardapiodigital.data.signUp.useCases.MakeSignUp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.dsl.module

object DataModules {

    val modules = module {
        factory { CheckUserIsLogged(Firebase.auth) }
        factory { MakeLogin(Firebase.auth) }

        factory { MakeSignUp(Firebase.auth) }

        factory {GetProdutosCardapio()}

    }

}