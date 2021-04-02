package com.fiap.cardapiodigital.domain.usecases.pedidos

import com.fiap.cardapiodigital.domain.entities.PedidoEntity
import com.fiap.cardapiodigital.domain.entities.ProdutoCardapioEntity
import com.fiap.cardapiodigital.domain.helpers.DomainError

interface CriarPedidoContract {

    fun inserir(
        pedido: PedidoEntity,
        onSuccessListener: () -> Unit,
        onFailureListener: (DomainError) -> Unit
    )
}