package com.fiap.cardapiodigital.ui.produtocardapio.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fiap.cardapiodigital.domain.entities.ProdutoCardapioEntity
import com.fiap.cardapiodigital.R
import com.fiap.cardapiodigital.domain.entities.RestauranteEntity

class ProductListAdapter(val list: ArrayList<ProdutoCardapioEntity>) : RecyclerView.Adapter<ProductListViewHolder>() {

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produto_list,parent, false)
        return ProductListViewHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        holder.bind(list[position])
    }



}