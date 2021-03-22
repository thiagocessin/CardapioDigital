package com.fiap.cardapiodigital.viewModel.restaurantes

import androidx.lifecycle.ViewModel
import com.fiap.cardapiodigital.domain.usecases.restaurantes.ListarRestaurantesContract

class RestaurantesViewModel(
    private val contract: RestaurantesContract,
    private val listarRestaurantesContract: ListarRestaurantesContract): ViewModel() {


    fun onCreate(){
        listarRestaurantesContract.criarLitaRestaurantes()
    }


}