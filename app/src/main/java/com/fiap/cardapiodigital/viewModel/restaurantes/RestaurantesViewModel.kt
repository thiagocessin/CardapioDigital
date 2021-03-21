package com.fiap.cardapiodigital.viewModel.restaurantes

import androidx.lifecycle.ViewModel
import com.fiap.cardapiodigital.domain.usecases.restaurantes.ListarRestaurantesContract

class RestaurantesViewModel(
    contract: RestaurantesContract,
    listarRestaurantesContract: ListarRestaurantesContract): ViewModel() {


    fun onCreate(){}


}