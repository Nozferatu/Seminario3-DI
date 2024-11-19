package com.cmj.seminario3_di

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuEj4InfoActivity : AppCompatActivity() {
    private lateinit var nombrePaisTV: TextView
    private lateinit var banderaIV: ImageView
    private lateinit var numHabitantesTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_ej4_info)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        nombrePaisTV = findViewById(R.id.nombrePaisTV)
        banderaIV = findViewById(R.id.banderaIV)
        numHabitantesTV = findViewById(R.id.numHabitantesTV)

        val pais = intent.getParcelableExtra<Pais>("pais") ?: Pais("", -1, -1)

        nombrePaisTV.text = pais.nombre
        banderaIV.setImageResource(pais.bandera)
        numHabitantesTV.text = "${pais.habitantes} habitantes"
    }
}