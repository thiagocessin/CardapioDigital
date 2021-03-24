package com.fiap.cardapiodigital.viewModel.produtocardapio

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fiap.cardapiodigital.domain.entities.ProdutoCardapioEntity
import com.fiap.cardapiodigital.domain.helpers.TiposRestauranteEnum
import com.fiap.cardapiodigital.domain.usecases.cardapio.GetProdutosCardapioContract
import com.fiap.cardapiodigital.viewModel.BaseViewModel

class ProdutoCardapioViewModel(
    private val contract: ProdutoCardapioContract,//interface com a view
    private val getProdutosCardapio : GetProdutosCardapioContract//use case
) :BaseViewModel() {

    //val produtosCardapio = getProdutosCardapio.getProdutosCardapio();
    val produtos = MutableLiveData<ArrayList<ProdutoCardapioEntity>>();

    fun listarProdutosCardapioPorTipo(tipoRestaurante: TiposRestauranteEnum){
        getProdutosCardapio.listarprodutosPorTipo(tipoRestaurante){produto ->
            Log.e("VM",produto.size.toString())
            this.produtos.postValue(produto)
        }
    }





}