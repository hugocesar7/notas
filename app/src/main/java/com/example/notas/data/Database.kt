package com.example.notas.data

import androidx.lifecycle.MutableLiveData

class Database {
    private val mDatabase: MutableLiveData<MutableList<Nota>> = MutableLiveData()

    fun inserirNota(nota: Nota){
        var temp = mDatabase.value
        if(temp == null){
            temp = mutableListOf()
            temp?.add(nota)
        } else{
            temp?.add(nota)
        }
        mDatabase.postValue(temp)
    }
    fun obterNotas() = mDatabase
}