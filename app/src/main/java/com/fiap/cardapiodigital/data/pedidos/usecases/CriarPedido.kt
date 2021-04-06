package com.fiap.cardapiodigital.data.pedidos.usecases

import android.util.Log
import com.fiap.cardapiodigital.domain.entities.PedidoEntity
import com.fiap.cardapiodigital.domain.entities.ProdutoCardapioEntity
import com.fiap.cardapiodigital.domain.helpers.DomainError
import com.fiap.cardapiodigital.domain.usecases.pedidos.CriarPedidoContract
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlin.random.Random

class CriarPedido() : CriarPedidoContract{

    val db = FirebaseFirestore.getInstance()
    val user= Firebase.auth.currentUser!!

    private val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
    var STRING_LENGTH = 10;

    override fun inserir(
        pedido: PedidoEntity,
        onSuccessListener: () -> Unit,
        onFailureListener: (DomainError) -> Unit
    ) {

       val randomPedidoNumero = (0..100000).random()

        val docData = hashMapOf(
            "descricao" to pedido.descricaoPedido,
            "numero" to  randomPedidoNumero,
            "valor" to calculaValorTotalPedido(pedido),
            "listaProdutos" to pedido.listaProdutos,
            "usuario" to user.uid,
            "statusPedido" to pedido.statusPedido,
            "tempoEstimado" to pedido.tempoEstimado,
            "valorFrete" to pedido.valorFrete
        )


        val randomString = (1..STRING_LENGTH)
            .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("");

        db.collection("pedidos")
            .document(randomString)
            .set(docData)
            .addOnSuccessListener {
                Log.i("onlistenerSucces1","Documento inserido com sucesso")
                onSuccessListener()
            }
            .addOnFailureListener {
                Log.e("onFailureListener","Erro ao gravar documento")
                onFailureListener(DomainError.GENERIC_ERROR)
            }

    }


    fun calculaValorTotalPedido(pedido: PedidoEntity) : Long{

        var valorTotal = 0L;
        for(item : ProdutoCardapioEntity in pedido.listaProdutos){
            valorTotal +=item.valor
        }
        return valorTotal
    }
}