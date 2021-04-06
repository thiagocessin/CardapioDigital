package com.fiap.cardapiodigital.data.pedidos.model

import com.fiap.cardapiodigital.domain.entities.ProdutoCardapioEntity

class PedidoModel (val numeroPedido:Long,
                   val descricaoPedido:String,
                   val listaProdutos: List<ProdutoCardapioEntity>,
                   val valor: Long,
                   val statusPedido : String,
                   val tempoEstimado: String,
                   val valorFrete: Long){


}