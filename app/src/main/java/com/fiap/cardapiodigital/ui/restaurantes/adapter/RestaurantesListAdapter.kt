package com.fiap.cardapiodigital.ui.restaurantes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fiap.cardapiodigital.R
import com.fiap.cardapiodigital.domain.entities.RestauranteEntity


class RestaurantesListAdapter : RecyclerView.Adapter<RestaurantesListViewHolder>(){

    var list: ArrayList<RestauranteEntity> = arrayListOf();

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantesListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_restaurante,parent, false)
        return RestaurantesListViewHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RestaurantesListViewHolder, position: Int) {
        holder.bind(list[position])
    }

}