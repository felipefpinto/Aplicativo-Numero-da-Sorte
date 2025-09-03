package com.example.numerosdasorte

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnmeusnumeros = findViewById<Button>(R.id.meusnumeros)
        btnmeusnumeros.setOnClickListener {
            val trocarpaginamn = Intent(this, MainActivity::class.java)
            startActivity(trocarpaginamn)
        }

        val btnperfisprontos = findViewById<Button>(R.id.perfisprontos)
        btnperfisprontos.setOnClickListener {
            val trocarpaginapp = Intent(this, JogosProntos::class.java)
            startActivity(trocarpaginapp)
        }
    }
}