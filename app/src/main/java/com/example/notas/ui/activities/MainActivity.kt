package com.example.notas.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notas.ui.NotasAdapter
import com.example.notas.R
import com.example.notas.data.Nota
import com.example.notas.viewmodels.NotasViewModel
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_ui.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val notasViewModel: NotasViewModel by viewModel()
    private val notasAdapter: NotasAdapter by lazy {
        NotasAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toobar)
        recycler_view.adapter = notasAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)

        notasViewModel.getNotas().observe(this, Observer { data ->
            data?.let{
                if(it.isEmpty()){
                    Toast.makeText(this, "Lista vazia!", Toast.LENGTH_SHORT).show()
                } else {
                    notasAdapter.addNotas(it)
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_adicionar){
            dialogAddNota()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun dialogAddNota() {
        val layout = LayoutInflater.from(this).inflate(R.layout.dialog_ui, null, false)
        val inputNota = layout.inputNota
        val dialog = AlertDialog.Builder(this)
        dialog.setView(layout)
        dialog.setNegativeButton("Cancelar", null)
        dialog.setPositiveButton("Salvar", {d, i ->
            //Salvar a nota
            val nota = Nota(0, inputNota.text.toString())
            notasViewModel.salvarNota(nota)
        })
        dialog.create().show()
    }
}
