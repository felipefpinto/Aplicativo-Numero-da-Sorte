package com.example.numerosdasorte

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class JogosProntos : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_jogos_prontos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var jogoselecionado: String? = null
        val btnsortear: Button = findViewById(R.id.sortear_JP)
        val spinner: Spinner = findViewById(R.id.spinner)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.jogos,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) { jogoselecionado = (parent?.getItemAtPosition(position) as String?).toString() }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        btnsortear.setOnClickListener {
            when(jogoselecionado){
                "Mega-Sena"-> megasena()
                "Lotofácil"-> lotofacil()
                "Quina"->quina()
                "Lotomania"->lotomania()

            }
        }

        val btnhome = findViewById<ImageButton>(R.id.btnhome)
        btnhome.setOnClickListener {
            val trocarpagina = Intent(this, Home::class.java)
            startActivity(trocarpagina)
        }
    }

    fun megasena(){
        val textResultado = findViewById< TextView>(R.id.resultadojp)
        val numeros = mutableListOf<Int>()
        while (numeros.size < 6){
            val num_sorte = Random.nextInt(1,61)
            if (num_sorte !in numeros){
                numeros.add(num_sorte)
            }
        }

        textResultado.setText("Numeros Sorteado: $numeros")
    }
}

private fun JogosProntos.lotomania() {
    val textResultado = findViewById< TextView>(R.id.resultadojp)
    val numeros = mutableListOf<Int>()
    while (numeros.size < 20){
        val num_sorte = Random.nextInt(0,100)
        if (num_sorte !in numeros){
            numeros.add(num_sorte)
        }
    }

    textResultado.setText("Numeros Sorteado: $numeros")
}

private fun JogosProntos.quina() {
    val textResultado = findViewById< TextView>(R.id.resultadojp)
    val numeros = mutableListOf<Int>()
    while (numeros.size < 5){
        val num_sorte = Random.nextInt(1,81)
        if (num_sorte !in numeros){
            numeros.add(num_sorte)
        }
    }

    textResultado.setText("Numeros Sorteado: $numeros")
}

private fun JogosProntos.lotofacil() {
    val textResultado = findViewById< TextView>(R.id.resultadojp)
    val numeros = mutableListOf<Int>()
    while (numeros.size < 15){
        val num_sorte = Random.nextInt(1,25)
        if (num_sorte !in numeros){
            numeros.add(num_sorte)
        }
    }

    textResultado.setText("Numeros Sorteado: $numeros")
}


