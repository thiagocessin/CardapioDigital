package com.fiap.cardapiodigital.ui.pedidos.adapter

import android.graphics.Typeface
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.fiap.cardapiodigital.domain.entities.PedidoEntity
import com.fiap.cardapiodigital.domain.entities.RestauranteEntity
import kotlinx.android.synthetic.main.item_pedido.view.*

class PedidosViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){


    fun bind(pedido: PedidoEntity){

        itemView.numeroPedido.text = "Nº Pedido: "+ pedido.numeroPedido.toString()
        itemView.descricaoPedido.text = pedido.descricaoPedido.toString()
        itemView.valorPedido.text = "Valor total: R$" + pedido.valor.toString()
        itemView.statusPedido.text = "Status: " + pedido.statusPedido
        itemView.tempoEstimado.text = "Tempo estimado para entrega: "+ pedido.tempoEstimado
        itemView.valorFrete.text = "Valor frete: "+ pedido.valorFrete

    }
}