package com.fiap.cardapiodigital.data.produtocardapio.usecases

import android.util.Log
import com.fiap.cardapiodigital.domain.entities.ProdutoCardapioEntity
import com.fiap.cardapiodigital.domain.entities.RestauranteEntity
import com.fiap.cardapiodigital.domain.helpers.TiposRestauranteEnum
import com.fiap.cardapiodigital.domain.usecases.cardapio.GetProdutosCardapioContract
import com.google.firebase.firestore.FirebaseFirestore

//fazem uma única funcão
//para cada funcionalidade do data um useCases
class GetProdutosCardapio () :GetProdutosCardapioContract{

    val db = FirebaseFirestore.getInstance()

    override fun listarprodutosPorTipo(tipoRestaurante: TiposRestauranteEnum,onResult: (ArrayList<ProdutoCardapioEntity>) -> Unit) {

        db.collection("produtos").whereEqualTo("tipoRestaurante",tipoRestaurante)
            .addSnapshotListener(){ value, _ ->
                val listaRetorno = arrayListOf<ProdutoCardapioEntity>()
                for(document in value!!){
                    val tiposRestauranteEnum = TiposRestauranteEnum.valueOf(document["tipoRestaurante"].toString())
                    val valor: Long = document["valor"] as Long

                    val produto = ProdutoCardapioEntity(
                        document["nome"].toString(),
                        valor,
                        document["descricao"].toString(),
                        TiposRestauranteEnum.valueOf(  document["tipoRestaurante"].toString())
                    )

                    listaRetorno.add(produto)
                }

                Log.e("#LISTARRESTAURANTES",listaRetorno.toString())
                onResult(listaRetorno)
            }
    }


}