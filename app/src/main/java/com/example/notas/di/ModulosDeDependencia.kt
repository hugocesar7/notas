package com.example.notas.di

import com.example.notas.data.Database
import com.example.notas.data.GestorDeNotas
import com.example.notas.viewmodels.NotasViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

object ModulosDeDependencia {
    val moduloDoApp = module {
        single { Database() }
        factory { GestorDeNotas(get()) }
        viewModel { NotasViewModel(get()) }
    }
}