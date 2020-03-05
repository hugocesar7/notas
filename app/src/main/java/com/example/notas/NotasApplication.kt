package com.example.notas

import android.app.Application
import com.example.notas.di.ModulosDeDependencia
import org.koin.android.ext.android.startKoin

class NotasApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(ModulosDeDependencia.moduloDoApp))
    }

}