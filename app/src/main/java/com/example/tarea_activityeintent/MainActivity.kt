package com.example.tarea_activityeintent

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Declaro las variables con los ids
        val editText = findViewById<EditText>(R.id.editTextDato)
        val boton = findViewById<Button>(R.id.btnEnviar)

        // Programo el OnClickListener
        boton.setOnClickListener {
            // Obtengo el texto del campo EditText
            val dato = editText.text.toString()

            // Creo el Intent para ir a la segunda actividad
            val intent = Intent(this, Activity2::class.java)

            // Paso el dato al intent
            intent.putExtra("dato", dato)

            // Y finalmente inicio la segunda actividad
            startActivity(intent)
        }
    }
}
