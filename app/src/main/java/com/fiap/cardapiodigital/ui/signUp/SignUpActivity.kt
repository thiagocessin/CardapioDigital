package com.fiap.cardapiodigital.ui.signUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.fiap.cardapiodigital.R
import com.fiap.cardapiodigital.databinding.ActivitySignUpBinding
import com.fiap.cardapiodigital.domain.entities.RestauranteEntity
import com.fiap.cardapiodigital.ui.produtocardapio.ProdutoCardapioActivity
import com.fiap.cardapiodigital.ui.restaurantes.RestaurantesActivity
import com.fiap.cardapiodigital.viewModel.signUp.SignUpContract
import com.fiap.cardapiodigital.viewModel.signUp.SignUpViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.core.parameter.parametersOf
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpActivity : AppCompatActivity(),SignUpContract {

    private lateinit var binding: ActivitySignUpBinding
    private val viewModel: SignUpViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        binding.viewModel = viewModel

        /*criação da autenticação feita no DATA*/
        val auth = Firebase.auth

    }

    override fun showGenericErrorMessage() {
        Toast.makeText(this, "Falha ao realizar login", Toast.LENGTH_SHORT).show()
    }

    override fun goToMainActivity() {
        startActivity(Intent(this, RestaurantesActivity::class.java))
    }
}