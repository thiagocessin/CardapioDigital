package com.fiap.cardapiodigital.ui.produtocardapio.adapter

import android.view.Gravity
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.fiap.cardapiodigital.domain.entities.ProdutoCardapioEntity
import com.fiap.cardapiodigital.domain.entities.RestauranteEntity
import kotlinx.android.synthetic.main.item_produto_list.view.*

class ProductListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(produto: ProdutoCardapioEntity,onItemTap: (item: ProdutoCardapioEntity) -> Unit) {
        itemView.nomeProduto.text = produto.nome
        itemView.valorProduto.text = produto.valor.toString()
        itemView.detalheProduto.text = produto.descricao


        itemView.setOnClickListener{
            onItemTap(produto)
        }
    }


}