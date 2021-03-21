package com.fiap.cardapiodigital.main.di

import com.fiap.cardapiodigital.data.login.usecases.CheckUserIsLogged
import com.fiap.cardapiodigital.data.login.usecases.MakeLogin
import com.fiap.cardapiodigital.data.produtocardapio.usecases.GetProdutosCardapio
import com.fiap.cardapiodigital.viewModel.login.LoginContract
import com.fiap.cardapiodigital.viewModel.login.LoginViewModel
import com.fiap.cardapiodigital.viewModel.produtocardapio.ProdutoCardapioContract
import com.fiap.cardapiodigital.viewModel.produtocardapio.ProdutoCardapioViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModules {


    val modules = module {
        viewModel { (contract: LoginContract) ->
            LoginViewModel(contract, get<CheckUserIsLogged>(), get<MakeLogin>()) }

        viewModel { (contract: ProdutoCardapioContract) ->
            ProdutoCardapioViewModel(contract, get<GetProdutosCardapio>()) }
    }

}