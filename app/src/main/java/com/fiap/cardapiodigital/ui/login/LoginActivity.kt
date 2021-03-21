package com.fiap.cardapiodigital.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fiap.cardapiodigital.R
import com.fiap.cardapiodigital.viewModel.login.LoginContract

class LoginActivity : AppCompatActivity(),LoginContract {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun showGenericErrorMessage() {
        Toast.makeText(this, "Falha ao realizar login", Toast.LENGTH_SHORT).show()
    }

    override fun goToMainActivity() {
       // startActivity(Intent(this, ChatActivity::class.java))
        finish()
    }


}