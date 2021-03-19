package com.fiap.cardapiodigital.ui.produtocardapio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.fiap.cardapiodigital.R
import com.fiap.cardapiodigital.databinding.ActivityProdutoCardapioBinding
import com.fiap.cardapiodigital.domain.entities.ProdutoCardapioEntity
import com.fiap.cardapiodigital.ui.produtocardapio.adapter.ProductListAdapter
import com.fiap.cardapiodigital.viewModel.produtocardapio.ProdutoCardapioContract
import com.fiap.cardapiodigital.viewModel.produtocardapio.ProdutoCardapioViewModel
import kotlinx.android.synthetic.main.activity_produto_cardapio.*
import org.koin.core.parameter.parametersOf
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProdutoCardapioActivity : AppCompatActivity(), ProdutoCardapioContract{

    val adapter = ProductListAdapter()

    private lateinit var binding: ActivityProdutoCardapioBinding
    private val viewModel: ProdutoCardapioViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_produto_cardapio)
        binding.viewModel = viewModel

        viewModel.onCreate()
        setupView()
        carregaListaViewModel()
    }

    private fun setupView(){
        lista.adapter= adapter
        lista.layoutManager = LinearLayoutManager(this)
    }

    private fun carregaListaViewModel(){
         val list : ArrayList<ProdutoCardapioEntity> = arrayListOf()
         list.add(ProdutoCardapioEntity("",10.00,"Lasanha a bolonhesa"))
         list.add(ProdutoCardapioEntity("",20.00,"Spaguetti quatro queijos"))
         list.add(ProdutoCardapioEntity("",50.00,"Nhoque ao sugo"))
         list.add(ProdutoCardapioEntity("",100.00,"Lagosta cozida"))
         adapter.list = list
    }

    override fun goToMainActivity() {
        TODO("Not yet implemented")
    }
}