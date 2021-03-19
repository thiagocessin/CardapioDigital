package com.fiap.cardapiodigital.domain.usecases.cardapio

import com.fiap.cardapiodigital.domain.entities.ProdutoCardapioEntity

interface GetProdutosCardapioContract {

    fun getProdutosCardapio() : List<ProdutoCardapioEntity>;
}