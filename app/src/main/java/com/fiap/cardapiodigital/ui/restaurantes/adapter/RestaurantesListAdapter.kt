package com.fiap.cardapiodigital.ui.restaurantes.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fiap.cardapiodigital.R
import com.fiap.cardapiodigital.domain.entities.RestauranteEntity
import com.fiap.cardapiodigital.ui.produtocardapio.ProdutoCardapioActivity


class RestaurantesListAdapter(val list: ArrayList<RestauranteEntity>,
    private val onItemTap: (index: Int) -> Unit) : RecyclerView.Adapter<RestaurantesListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantesListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_restaurante,parent, false)

        return RestaurantesListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RestaurantesListViewHolder, position: Int) {
        Log.e("#onBindViewHolder","onBindVH")
        holder.bind(list[position],onItemTap)
    }

}