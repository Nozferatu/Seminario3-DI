package com.cmj.seminario3_di

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuEj2InfoActivity : AppCompatActivity() {
    private lateinit var infoNumero: TextView
    private lateinit var infoTexto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_ej2_info)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        infoNumero = findViewById(R.id.infoNumero)
        infoTexto = findViewById(R.id.infoTexto)

        val numero = intent.getIntExtra("numero", 0)
        val texto = intent.getStringExtra("texto")

        infoNumero.text = "Hemos recibido el número: ${numero}"
        infoTexto.text = "Hemos recibido el texto: ${texto}"
    }
}