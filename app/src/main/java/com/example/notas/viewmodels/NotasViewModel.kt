package com.example.notas.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notas.data.Database
import com.example.notas.data.GestorDeNotas
import com.example.notas.data.Nota

class NotasViewModel(val gestorDeNotas: GestorDeNotas) : ViewModel() {
    private var mNotas: MutableLiveData<MutableList<Nota>>? = null

    fun getNotas(): LiveData<MutableList<Nota>> {
        if(mNotas == null){
            mNotas = gestorDeNotas.getNotas()
        }
        return mNotas!!
    }

    fun salvarNota(nota: Nota) = gestorDeNotas.addNota(nota)
}