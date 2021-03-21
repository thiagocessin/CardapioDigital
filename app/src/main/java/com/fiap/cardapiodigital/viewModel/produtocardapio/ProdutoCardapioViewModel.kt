package com.fiap.cardapiodigital.viewModel.produtocardapio

import androidx.lifecycle.ViewModel
import com.fiap.cardapiodigital.domain.usecases.cardapio.GetProdutosCardapioContract

class ProdutoCardapioViewModel(
    private val contract: ProdutoCardapioContract,//interface com a view
    private val getProdutosCardapio : GetProdutosCardapioContract//use case
) :ViewModel() {

    //val produtosCardapio = getProdutosCardapio.getProdutosCardapio();
    //val produtos = MutableLiveData<ArrayList<ProdutoCardapioEntity>>();



    fun onCreate(){
        //contract.goToMainActivity()
    }





}