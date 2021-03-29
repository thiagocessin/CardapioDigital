package com.fiap.cardapiodigital.viewModel.restaurantes

import android.util.Log
import android.widget.Toast

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fiap.cardapiodigital.data.restaurantes.model.RestaurantesModel
import com.fiap.cardapiodigital.domain.entities.RestauranteEntity
import com.fiap.cardapiodigital.domain.usecases.restaurantes.ListarRestaurantesContract
import com.fiap.cardapiodigital.viewModel.BaseViewModel

class RestaurantesViewModel(
    private val contract: RestaurantesContract,
    private val listarRestaurantesContract: ListarRestaurantesContract):
    BaseViewModel() {

    val restaurantes = MutableLiveData<ArrayList<RestauranteEntity>>()

    fun onCreate(){
        listarTodosRestaurantes()
    }

    fun listarTodosRestaurantes() {
        listarRestaurantesContract.listarTodosRestaurantes(){restaurantes->
          this.restaurantes.postValue(restaurantes)
        }
    }

    fun criarListaRestaurantes(){
        listarRestaurantesContract.criarLitaRestaurantes()
    }

    fun onClickRestaurante(){
        Log.e("RESTA", "CLICK REST")
        contract.goToProdutoCardapioActivity()

    }



}