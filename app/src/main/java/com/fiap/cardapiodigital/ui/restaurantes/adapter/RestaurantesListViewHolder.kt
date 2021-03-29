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
import com.fiap.cardapiodigital.R


class RestaurantesListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    fun bind(restaurante: RestauranteEntity, onItemTap: (item: RestauranteEntity) -> Unit) {
        itemView.descricaoRestaurante.text= restaurante.nome

        var descricaoTipoRestaurante ="";


        when(TiposRestauranteEnum.valueOf(restaurante.tipo.name)){
            TiposRestauranteEnum.MEXICANO ->{
                descricaoTipoRestaurante = "Restaurante Mexicano"
                itemView.imagemRestaurante.setImageResource(R.drawable.img_rest_mexicano);
            }
            TiposRestauranteEnum.ITALIANO -> {
                descricaoTipoRestaurante = "Restaurante Italiano"
                itemView.imagemRestaurante.setImageResource(R.drawable.img_rest_italiano);
            }
            TiposRestauranteEnum.JAPONES -> {
                descricaoTipoRestaurante = "Restaurante Japonês"
                itemView.imagemRestaurante.setImageResource(R.drawable.img_rest_japones);
            }
            TiposRestauranteEnum.VARIADO -> {
                descricaoTipoRestaurante = "Comidas Típicas Variadas"
                itemView.imagemRestaurante.setImageResource(R.drawable.img_rest_variado);
            }
            else -> {
                descricaoTipoRestaurante = "Tipo do Restaurante desconhecido"
                itemView.imagemRestaurante.setImageResource(R.drawable.img_restaurante);
            }
        }


        itemView.tipoRestaurante.text = descricaoTipoRestaurante

        itemView.setOnClickListener{
            Log.e("#RestaurantesListVH","setOnClickListener")
            onItemTap(restaurante)
        }

    }

}