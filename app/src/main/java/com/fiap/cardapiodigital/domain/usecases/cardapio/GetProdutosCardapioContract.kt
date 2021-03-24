package com.fiap.cardapiodigital.domain.usecases.cardapio

import com.fiap.cardapiodigital.domain.entities.ProdutoCardapioEntity
import com.fiap.cardapiodigital.domain.helpers.TiposRestauranteEnum

interface GetProdutosCardapioContract {

    fun listarprodutosPorTipo(tipoRestaurante: TiposRestauranteEnum,onResult: (ArrayList<ProdutoCardapioEntity>) -> Unit)
}