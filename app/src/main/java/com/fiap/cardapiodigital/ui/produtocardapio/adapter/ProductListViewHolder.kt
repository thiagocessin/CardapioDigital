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
        itemView.valorProduto.text = "R$ "+ produto.valor.toString()
        itemView.detalheProduto.text = produto.descricao
        itemView.quantidadeTexto.text = "Quantidade: "


        itemView.addButton.setOnClickListener{
            onItemTap(produto)

            if(itemView.quantidade.text.toString().isNullOrEmpty()){
                itemView.quantidade.text = "0";
            }
            val cont = itemView.quantidade.text.toString().toInt()
            itemView.quantidade.text = (cont+1).toString()
        }

        itemView.removeButton.setOnClickListener{
            onItemTap(produto)
            if(itemView.quantidade.text.toString().isNullOrEmpty()){
                itemView.quantidade.text = "0";
            }
                val cont = itemView.quantidade.text.toString().toInt()

                if(cont > 0) {
                    itemView.quantidade.text = (cont - 1).toString()
                }

        }
        /*
        itemView.setOnClickListener{
            onItemTap(produto)
        }*/
    }


}