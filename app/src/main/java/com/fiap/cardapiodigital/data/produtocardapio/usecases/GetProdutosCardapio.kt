package com.fiap.cardapiodigital.data.produtocardapio.usecases

import com.fiap.cardapiodigital.domain.entities.ProdutoCardapioEntity
import com.fiap.cardapiodigital.domain.usecases.cardapio.GetProdutosCardapioContract

//fazem uma única funcão
//para cada funcionalidade do data um useCases
class GetProdutosCardapio :GetProdutosCardapioContract{

    override fun getProdutosCardapio(): List<ProdutoCardapioEntity> {
        TODO("Not yet implemented")
    }


}