package com.fiap.cardapiodigital.main.di

import com.fiap.cardapiodigital.data.produtocardapio.usecases.GetProdutosCardapio
import org.koin.dsl.module

object DataModules {

    val modules = module {

        factory {GetProdutosCardapio()}

    }

}