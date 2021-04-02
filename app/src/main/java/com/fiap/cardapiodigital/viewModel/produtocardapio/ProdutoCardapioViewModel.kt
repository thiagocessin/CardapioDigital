package com.fiap.cardapiodigital.viewModel.produtocardapio

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fiap.cardapiodigital.domain.entities.PedidoEntity
import com.fiap.cardapiodigital.domain.entities.ProdutoCardapioEntity
import com.fiap.cardapiodigital.domain.helpers.TiposRestauranteEnum
import com.fiap.cardapiodigital.domain.usecases.cardapio.GetProdutosCardapioContract
import com.fiap.cardapiodigital.domain.usecases.pedidos.CriarPedidoContract
import com.fiap.cardapiodigital.viewModel.BaseViewModel

class ProdutoCardapioViewModel(
    private val contract: ProdutoCardapioContract,//interface com a view
    private val getProdutosCardapio : GetProdutosCardapioContract,
    private val criarPedidoContract : CriarPedidoContract//use case
) :BaseViewModel() {

    //val produtosCardapio = getProdutosCardapio.getProdutosCardapio();
    val produtos = MutableLiveData<ArrayList<ProdutoCardapioEntity>>();
    var listaProdutosSelecionados = arrayListOf<ProdutoCardapioEntity>()

    fun listarProdutosCardapioPorTipo(tipoRestaurante: TiposRestauranteEnum){
        getProdutosCardapio.listarprodutosPorTipo(tipoRestaurante){produto ->
            Log.e("VM",produto.size.toString())
            this.produtos.postValue(produto)
        }
    }

    fun onFinalizarPedidoClick(){

        val pedido =  PedidoEntity(123, "Descricao",listaProdutosSelecionados,122)
        Log.e("FINALIZAR","PEDIDO: " +pedido.toString())

        criarPedidoContract.inserir(pedido,
            {
                Log.i("VM", "Inserido")
            },{it->
                Log.e("VM", "Erro: " + it.toString())
            })

    }








}