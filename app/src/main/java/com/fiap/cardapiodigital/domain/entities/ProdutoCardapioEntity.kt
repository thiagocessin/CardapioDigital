package com.fiap.cardapiodigital.domain.entities

import com.fiap.cardapiodigital.domain.helpers.TiposRestauranteEnum

class ProdutoCardapioEntity(
    val nome: String,
    val valor: Long,
    val descricao: String,
    val tipoRestaurante: TiposRestauranteEnum
) {
}