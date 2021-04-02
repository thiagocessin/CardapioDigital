package com.fiap.cardapiodigital.viewModel.pedidos

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.fiap.cardapiodigital.domain.entities.PedidoEntity
import com.fiap.cardapiodigital.domain.usecases.pedidos.CriarPedidoContract
import com.fiap.cardapiodigital.domain.usecases.pedidos.ListarPedidosContract
import com.fiap.cardapiodigital.viewModel.BaseViewModel

class PedidosViewModel(
    private val contrac: PedidosContract,
    private val listarPedidosContract: ListarPedidosContract,
    private val criarPedidoContract: CriarPedidoContract
    ) : BaseViewModel(){

    val pedidos = MutableLiveData<ArrayList<PedidoEntity>>()

    fun onCreate(){
        listarPedidosContract.listarTodosPedidos(){pedidos->
            this.pedidos.postValue(pedidos)
        }
    }



}