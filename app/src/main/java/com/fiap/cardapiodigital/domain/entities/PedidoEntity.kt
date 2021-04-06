package com.fiap.cardapiodigital.domain.entities

class PedidoEntity(
    val numeroPedido:Long,
    val descricaoPedido:String,
    val listaProdutos: List<ProdutoCardapioEntity>,
    val valor: Long,
    val statusPedido : String,
    val tempoEstimado: String,
    val valorFrete: Long) {
}