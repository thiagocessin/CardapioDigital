package com.fiap.cardapiodigital.domain.usecases.pedidos

import com.fiap.cardapiodigital.domain.entities.PedidoEntity
import com.fiap.cardapiodigital.domain.entities.RestauranteEntity

interface ListarPedidosContract {

    fun listarTodosPedidos(onResult: (ArrayList<PedidoEntity>) -> Unit)

    fun listarPedidosPorCliente(onResult: (ArrayList<PedidoEntity>) -> Unit)
}