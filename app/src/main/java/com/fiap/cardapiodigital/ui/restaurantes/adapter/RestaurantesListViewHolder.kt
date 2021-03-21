package com.fiap.cardapiodigital.ui.restaurantes.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.fiap.cardapiodigital.domain.entities.RestauranteEntity
import kotlinx.android.synthetic.main.item_restaurante.view.*

class RestaurantesListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {

    fun bind(restaurante: RestauranteEntity) {
        itemView.descricaoRestaurante.text= restaurante.nome
        itemView.tipoRestaurante.text = restaurante.tipo.name




    }

}