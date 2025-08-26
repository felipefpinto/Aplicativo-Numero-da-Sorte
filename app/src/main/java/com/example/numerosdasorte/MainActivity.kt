package com.example.numerosdasorte

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun sortear(view: View){
        val textResultado = findViewById< TextView>(R.id.text_resultado)
        val numerostart = findViewById<EditText>(R.id.numero_inicio).text.toString().toInt()
        val numeroFinal = findViewById<EditText>(R.id.numero_final).text.toString().toInt()
        val numero = Random.nextInt(numerostart,numeroFinal + 1)

        textResultado.setText("Numero Sorteado: $numero")
    }
}