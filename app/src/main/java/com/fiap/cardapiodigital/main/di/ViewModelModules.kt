package com.fiap.cardapiodigital.main.di

import com.fiap.cardapiodigital.data.login.usecases.CheckUserIsLogged
import com.fiap.cardapiodigital.data.login.usecases.MakeLogin
import com.fiap.cardapiodigital.data.produtocardapio.usecases.GetProdutosCardapio
import com.fiap.cardapiodigital.data.restaurantes.usecases.ListarRestaurantes
import com.fiap.cardapiodigital.data.signUp.useCases.MakeSignUp
import com.fiap.cardapiodigital.domain.usecases.signUp.MakeSignUpContract
import com.fiap.cardapiodigital.viewModel.login.LoginContract
import com.fiap.cardapiodigital.viewModel.login.LoginViewModel
import com.fiap.cardapiodigital.viewModel.produtocardapio.ProdutoCardapioContract
import com.fiap.cardapiodigital.viewModel.produtocardapio.ProdutoCardapioViewModel
import com.fiap.cardapiodigital.viewModel.restaurantes.RestaurantesContract
import com.fiap.cardapiodigital.viewModel.restaurantes.RestaurantesViewModel
import com.fiap.cardapiodigital.viewModel.signUp.SignUpContract
import com.fiap.cardapiodigital.viewModel.signUp.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModules {


    val modules = module {
        viewModel { (contract: LoginContract) ->
            LoginViewModel(contract, get<CheckUserIsLogged>(), get<MakeLogin>()) }

        viewModel { (contract: ProdutoCardapioContract) ->
            ProdutoCardapioViewModel(contract, get<GetProdutosCardapio>()) }

        viewModel { (contract: SignUpContract) ->
            SignUpViewModel(contract, get<MakeSignUp>())
        }

        viewModel{(contract: RestaurantesContract) ->
            RestaurantesViewModel(contract, get<ListarRestaurantes>())

        }
    }

}