package com.fiap.cardapiodigital.ui.restaurantes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.fiap.cardapiodigital.R
import com.fiap.cardapiodigital.databinding.ActivityRestaurantesBinding

import com.fiap.cardapiodigital.ui.produtocardapio.ProdutoCardapioActivity
import com.fiap.cardapiodigital.ui.restaurantes.adapter.RestaurantesListAdapter
import com.fiap.cardapiodigital.viewModel.restaurantes.RestaurantesContract
import com.fiap.cardapiodigital.viewModel.restaurantes.RestaurantesViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

import kotlinx.android.synthetic.main.activity_restaurantes.*
import kotlinx.android.synthetic.main.activity_restaurantes.lista
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class RestaurantesActivity : AppCompatActivity(), RestaurantesContract {

    var adapter = RestaurantesListAdapter()
    private lateinit var binding: ActivityRestaurantesBinding
    private val viewModel: RestaurantesViewModel by viewModel { parametersOf(this) }

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurantes)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_restaurantes)
        binding.viewModel = viewModel
        viewModel.onCreate()

         setupView()
         carregaListaViewModel()
        val userName = Firebase.auth.currentUser!!.displayName
        Log.e("userName", "$userName")
        nomeUsuario?.text = "Olá $userName"
    }

    private fun setupView(){
        Log.i("RestaurantesActivity", "SetUp")
        lista.adapter= adapter
        lista.layoutManager = LinearLayoutManager(this)



    }

    override fun goToMainActivity() {
        startActivity(Intent(this, ProdutoCardapioActivity::class.java))
        finish()
    }

    private fun carregaListaViewModel(){

        Log.e("#activity","chamada listar")
        viewModel.listarTodosRestaurantes()

        viewModel.restaurantes.observe(this, Observer{
            Log.e("#activityR",it.toString())
            adapter.list = it
            adapter.notifyDataSetChanged()
        })
    }
}