package com.example.tarea_activityeintent

import android.widget.Button
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referenciamos el TextView
        val textViewDatoRecibido = findViewById<TextView>(R.id.textViewDatoRecibido)

        // Recuperamos el dato que enviamos de la actividad anterior o pestaña anterior
        val datoRecibido = intent.getStringExtra("dato")

        // Lo mostramos en el textView
        textViewDatoRecibido.text = "¡Has enviado este dato!\n\n\"$datoRecibido\""

        val botonVolver = findViewById<Button>(R.id.btnVolver)
        botonVolver.setOnClickListener {
            finish() // Esto cierra Activity2 y vuelve a MainActivity
        }

    }
}
