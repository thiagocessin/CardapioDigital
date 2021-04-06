package com.fiap.cardapiodigital.data.pedidos.usecases

import android.util.Log
import com.fiap.cardapiodigital.domain.entities.PedidoEntity
import com.fiap.cardapiodigital.domain.entities.ProdutoCardapioEntity
import com.fiap.cardapiodigital.domain.usecases.pedidos.ListarPedidosContract
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class ListarPedidos : ListarPedidosContract {

    val db = FirebaseFirestore.getInstance()
    val user= Firebase.auth.currentUser!!


    override fun listarTodosPedidos(onResult: (ArrayList<PedidoEntity>) -> Unit) {

        db.collection("pedidos")
            //.whereEqualTo("tipoRestaurante",tipoRestaurante)
            .addSnapshotListener(){ value, _ ->
                val listaRetorno = arrayListOf<PedidoEntity>()
                for(document in value!!){

                    val numeroPedido: Long = document["numero"] as Long
                    val valor: Long = document["valor"] as Long
                    var listaProdutos: List<ProdutoCardapioEntity> = document["listaProdutos"] as ArrayList<ProdutoCardapioEntity>
                    val valorFrete: Long = document["valorFrete"] as Long

                    val pedido = PedidoEntity(
                        numeroPedido,
                        document["descricao"].toString(),
                        listaProdutos,
                        valor,
                            document["statusPedido"].toString(),
                            document["tempoEstimado"].toString(),
                            valorFrete
                    )

                    listaRetorno.add(pedido)
                }

                Log.i("#LISTARPEDIDOS",listaRetorno.toString())
                onResult(listaRetorno)
            }

    }

    override fun listarPedidosPorCliente(onResult: (ArrayList<PedidoEntity>) -> Unit) {
        db.collection("pedidos").whereEqualTo("usuario",user.uid)
                .addSnapshotListener(){ value, _ ->
                    val listaRetorno = arrayListOf<PedidoEntity>()
                    for(document in value!!){

                        val numeroPedido: Long = document["numero"] as Long
                        val valor: Long = document["valor"] as Long
                        var listaProdutos: List<ProdutoCardapioEntity> = document["listaProdutos"] as ArrayList<ProdutoCardapioEntity>
                        val valorFrete: Long = document["valorFrete"] as Long

                        val pedido = PedidoEntity(
                                numeroPedido,
                                document["descricao"].toString(),
                                listaProdutos,
                                valor,
                                document["statusPedido"].toString(),
                                document["tempoEstimado"].toString(),
                                valorFrete
                        )

                        listaRetorno.add(pedido)
                    }

                    Log.i("#LISTARPEDIDOS",listaRetorno.toString())
                    onResult(listaRetorno)
                }
    }


}