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
import java.lang.StringBuilder

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


    fun retornaDescricaoPedido():String{

        var sb = StringBuilder()
        var map = HashMap<String,Int>()

        for(item:ProdutoCardapioEntity in listaProdutosSelecionados){
            if(map.contains(item.nome)){
                val m = map.get(item.nome)
                val cont = m!!.toInt()+1
                Log.e("cont: ",cont.toString())
                map.put(item.nome,cont)
            }else {
                map.put(item.nome,1)
            }
        }

        sb.append("Descrição do Pedido").append("\n")

        for((k,v)in map){
            sb.append(v).append("x").append(" - ").append(k).append("\n")
        }


        return sb.toString()

    }

    fun onFinalizarPedidoClick(){

        val descricao = retornaDescricaoPedido();

        val pedido =
                PedidoEntity(0, descricao.toString(),listaProdutosSelecionados,
                        0,"Em Andamento", "1",10)

        criarPedidoContract.inserir(pedido,
            {
                contract.onSuccesCriarPedido()
            },{it->
                Log.e("VM", "Erro: " + it.toString())
            })

    }








}