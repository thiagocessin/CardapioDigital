package com.fiap.cardapiodigital.domain.usecases.restaurantes

import com.fiap.cardapiodigital.data.restaurantes.model.RestaurantesModel
import com.fiap.cardapiodigital.domain.entities.RestauranteEntity
import com.fiap.cardapiodigital.domain.helpers.TiposRestauranteEnum

interface ListarRestaurantesContract {

    fun listarTodosRestaurantes(onResult: (ArrayList<RestauranteEntity>) -> Unit);

    fun listarTodosRestaurantesPorTipo(onResult: (ArrayList<RestauranteEntity>) -> Unit);

    fun criarLitaRestaurantes()
}