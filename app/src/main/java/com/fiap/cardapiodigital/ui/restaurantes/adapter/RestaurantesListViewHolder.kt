package com.fiap.cardapiodigital.ui.restaurantes.adapter


import android.view.View
import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.fiap.cardapiodigital.domain.entities.RestauranteEntity
import com.fiap.cardapiodigital.domain.helpers.TiposRestauranteEnum
import com.fiap.cardapiodigital.ui.produtocardapio.ProdutoCardapioActivity
import kotlinx.android.synthetic.main.item_restaurante.view.*
import kotlinx.coroutines.withContext


class RestaurantesListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    fun bind(restaurante: RestauranteEntity, onItemTap: (item: RestauranteEntity) -> Unit) {
        itemView.descricaoRestaurante.text= restaurante.nome

        val descricaoTipoRestaurante = when(TiposRestauranteEnum.valueOf(restaurante.tipo.name)){
            TiposRestauranteEnum.MEXICANO -> "Restaurante Mexicano"
            TiposRestauranteEnum.ITALIANO -> "Restaurante Italiano"
            TiposRestauranteEnum.JAPONES -> "Restaurante Japonês"
            TiposRestauranteEnum.VARIADO -> "Comidas típicas variadas"
            else -> "Tipo do Restaurante desconhecido"
        }

        itemView.tipoRestaurante.text = descricaoTipoRestaurante

        itemView.setOnClickListener{
            Log.e("#RestaurantesListVH","setOnClickListener")
            onItemTap(restaurante)
        }

    }

}