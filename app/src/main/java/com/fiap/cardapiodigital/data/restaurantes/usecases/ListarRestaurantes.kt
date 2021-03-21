package com.fiap.cardapiodigital.data.restaurantes.usecases

import com.fiap.cardapiodigital.data.restaurantes.model.RestaurantesModel
import com.fiap.cardapiodigital.domain.helpers.TiposRestauranteEnum
import com.fiap.cardapiodigital.domain.usecases.restaurantes.ListarRestaurantesContract

class ListarRestaurantes() : ListarRestaurantesContract {
    override fun listarTodosRestaurantes(): List<RestaurantesModel> {
        TODO("Not yet implemented")
    }

    override fun listarRestaurantesPorTipo(tipoRestaurante: TiposRestauranteEnum): List<RestaurantesModel> {
        TODO("Not yet implemented")
    }
}