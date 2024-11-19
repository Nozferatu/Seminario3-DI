package com.cmj.seminario3_di

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuEj3InfoActivity : AppCompatActivity() {
    private lateinit var cadenasPasadasTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_ej3_info)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        cadenasPasadasTV = findViewById(R.id.cadenasPasadasTV)

        var listaCadenas = intent.getStringArrayExtra("lista")
        var contenido = "Las cadenas pasadas son:\n"

        var it = 0

        if (listaCadenas != null) {
            while(it < listaCadenas.size){
                contenido += listaCadenas[it]

                if(it + 1 < listaCadenas.size) contenido += ", "

                it++
            }

            cadenasPasadasTV.text = contenido
        }
    }
}