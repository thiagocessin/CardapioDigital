package com.fiap.cardapiodigital.ui.pedidos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.fiap.cardapiodigital.R
import com.fiap.cardapiodigital.databinding.ActivityPedidosBinding
import com.fiap.cardapiodigital.ui.pedidos.adapter.PedidosAdapter
import com.fiap.cardapiodigital.ui.produtocardapio.ProdutoCardapioActivity
import com.fiap.cardapiodigital.viewModel.pedidos.PedidosContract
import com.fiap.cardapiodigital.viewModel.pedidos.PedidosViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_pedidos.*
import org.koin.core.parameter.parametersOf
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*
import androidx.lifecycle.Observer


class PedidosActivity : AppCompatActivity(), PedidosContract {

    var adapter = PedidosAdapter(arrayListOf())

    private lateinit var binding: ActivityPedidosBinding
    private val viewModel: PedidosViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedidos)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_pedidos)
        binding.viewModel = viewModel

        viewModel.onCreate()

        carregaListaViewModel()
        val userName = Firebase.auth.currentUser!!.displayName
        Log.e("userName", "$userName")
        //nomeUsuario?.text = "Bem vindo(a) $userName"
    }

    private fun carregaListaViewModel(){

        viewModel.pedidos.observe(this, Observer{
            adapter = PedidosAdapter(it)
            //   adapter.list = it
            adapter.notifyDataSetChanged()
            listaPedidos.adapter= adapter
            listaPedidos.layoutManager = LinearLayoutManager(this)
        })
    }

    override fun showGenericError() {
        Toast.makeText(this, "Falha ao realizar o pedido", Toast.LENGTH_SHORT).show()

    }

    override fun showSuccessMessage() {
        Toast.makeText(this, "Pedido Realizado com sucesso", Toast.LENGTH_SHORT).show()

    }

}