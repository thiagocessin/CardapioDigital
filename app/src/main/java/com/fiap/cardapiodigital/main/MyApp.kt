package com.fiap.cardapiodigital.main

import android.app.Application
import com.fiap.cardapiodigital.main.di.DataModules
import com.fiap.cardapiodigital.main.di.ViewModelModules
import org.koin.core.context.startKoin

class MyApp : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin{
            modules(
                    DataModules.modules + ViewModelModules.modules
            )
        }

    }
}
