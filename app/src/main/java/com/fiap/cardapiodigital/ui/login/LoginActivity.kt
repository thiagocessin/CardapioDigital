package com.fiap.cardapiodigital.ui.login


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil

import com.fiap.cardapiodigital.R
import com.fiap.cardapiodigital.databinding.ActivityLoginBinding
import com.fiap.cardapiodigital.ui.produtocardapio.ProdutoCardapioActivity
import com.fiap.cardapiodigital.ui.restaurantes.RestaurantesActivity
import com.fiap.cardapiodigital.ui.signUp.SignUpActivity
import com.fiap.cardapiodigital.viewModel.login.LoginContract
import com.fiap.cardapiodigital.viewModel.login.LoginViewModel
import org.koin.core.parameter.parametersOf
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity(),LoginContract {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel : LoginViewModel by viewModel { parametersOf(this)}

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        binding.viewModel = viewModel
        viewModel.onCreate()

    }

    override fun showGenericErrorMessage() {
        Toast.makeText(this, "Falha ao realizar login", Toast.LENGTH_SHORT).show()
    }

    override fun goToMainActivity() {
        startActivity(Intent(this, RestaurantesActivity::class.java))
        finish()
    }

    override fun goToSignUpActivity() {
        startActivity(Intent(this, SignUpActivity::class.java))
    }


}