package com.fiap.cardapiodigital.ui.pedidos.adapter

import android.graphics.Typeface
import android.icu.text.NumberFormat
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.fiap.cardapiodigital.domain.entities.PedidoEntity
import com.fiap.cardapiodigital.domain.entities.RestauranteEntity
import kotlinx.android.synthetic.main.item_pedido.view.*
import java.text.DecimalFormat

class PedidosViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){


    fun bind(pedido: PedidoEntity){

        itemView.numeroPedido.text = "Nº Pedido: "+ pedido.numeroPedido.toString()
        itemView.descricaoPedido.text = pedido.descricaoPedido.toString()

        val valorTotal = String.format("%.3f", pedido.valor.toDouble()).toDouble()

        itemView.valorPedido.text = "Valor total: R$ $valorTotal"
        itemView.statusPedido.text = "Status: " + pedido.statusPedido

        val tempoEstimado= pedido.tempoEstimado!!.toString().toInt() * 60
        val valorFrete =  String.format("%.3f",pedido.valorFrete.toDouble()).toDouble()

        itemView.tempoEstimado.text = "Tempo estimado: $tempoEstimado Minutos"
        itemView.valorFrete.text = "Valor frete: R$ $valorFrete"

    }
}