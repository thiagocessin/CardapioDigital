package com.fiap.cardapiodigital.domain.usecases.pedidos

import com.fiap.cardapiodigital.domain.entities.PedidoEntity
import com.fiap.cardapiodigital.domain.entities.RestauranteEntity
import com.google.firebase.auth.FirebaseUser

interface ListarPedidosContract {

    fun listarTodosPedidos(onResult: (ArrayList<PedidoEntity>) -> Unit)

    fun listarPedidosPorCliente(onResult: (ArrayList<PedidoEntity>) -> Unit)
}