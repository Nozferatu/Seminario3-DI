package com.cmj.seminario3_di

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuEj4Activity : AppCompatActivity() {
    private lateinit var botonEspana: AppCompatButton
    private lateinit var botonFrancia: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_ej4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        botonEspana = findViewById(R.id.botonEspana)
        botonEspana.setOnClickListener {
            val pais = Pais("España", 48797875, R.drawable.bandera_espana)

            val intent = Intent(this, MenuEj4InfoActivity::class.java)
            intent.putExtra("pais", pais)

            startActivity(intent)
        }

        botonFrancia = findViewById(R.id.botonFrancia)
        botonFrancia.setOnClickListener {
            val pais = Pais("Francia", 68042591, R.drawable.bandera_francia)

            val intent = Intent(this, MenuEj4InfoActivity::class.java)
            intent.putExtra("pais", pais)

            startActivity(intent)
        }
    }
}