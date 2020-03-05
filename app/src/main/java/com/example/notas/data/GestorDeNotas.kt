package com.example.notas.data

import androidx.lifecycle.MutableLiveData

class GestorDeNotas(val database: Database) {

    fun getNotas() = database.obterNotas()
    fun addNota(nota: Nota){
        database.inserirNota(nota)
    }
}