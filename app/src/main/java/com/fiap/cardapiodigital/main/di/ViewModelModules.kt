package com.fiap.cardapiodigital.main.di

import com.fiap.cardapiodigital.data.produtocardapio.usecases.GetProdutosCardapio
import com.fiap.cardapiodigital.viewModel.produtocardapio.ProdutoCardapioContract
import com.fiap.cardapiodigital.viewModel.produtocardapio.ProdutoCardapioViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModules {


    val modules = module {
        viewModel { (contract: ProdutoCardapioContract) ->
            ProdutoCardapioViewModel(contract, get<GetProdutosCardapio>()) }
    }

}