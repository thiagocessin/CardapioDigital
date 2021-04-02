package com.fiap.cardapiodigital.ui.pedidos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fiap.cardapiodigital.R
import com.fiap.cardapiodigital.domain.entities.PedidoEntity
import com.fiap.cardapiodigital.domain.entities.RestauranteEntity

class PedidosAdapter(val list: ArrayList<PedidoEntity>): RecyclerView.Adapter<PedidosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PedidosViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pedido,parent, false)

        return PedidosViewHolder(view)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: PedidosViewHolder, position: Int) {
        holder.bind(list[position])
    }


}