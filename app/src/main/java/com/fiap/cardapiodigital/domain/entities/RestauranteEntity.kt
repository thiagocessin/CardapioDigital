package com.fiap.cardapiodigital.domain.entities

import com.fiap.cardapiodigital.domain.helpers.TiposRestauranteEnum

class RestauranteEntity(
    val nome:String,
    val tipo: TiposRestauranteEnum
) {
}