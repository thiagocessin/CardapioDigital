package com.fiap.cardapiodigital.domain.usecases.restaurantes

import com.fiap.cardapiodigital.data.restaurantes.model.RestaurantesModel
import com.fiap.cardapiodigital.domain.helpers.TiposRestauranteEnum

interface ListarRestaurantesContract {

    fun listarTodosRestaurantes(): List<RestaurantesModel>;

    fun listarRestaurantesPorTipo(tipoRestaurante: TiposRestauranteEnum) : List<RestaurantesModel>;

    fun criarLitaRestaurantes()
}