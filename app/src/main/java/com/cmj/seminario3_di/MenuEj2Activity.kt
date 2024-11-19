package com.cmj.seminario3_di

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MenuEj2Activity : AppCompatActivity() {
    private lateinit var numeroET: TextInputEditText
    private lateinit var textoET: TextInputEditText
    private lateinit var botonPasarDatos: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_ej2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        numeroET = findViewById(R.id.numeroET)
        numeroET.setText((1..9).random())
        textoET = findViewById(R.id.textoET)
        botonPasarDatos = findViewById(R.id.botonPasarDatos)

        botonPasarDatos.setOnClickListener{
            val numero = numeroET.text.toString().toInt()
            val texto = textoET.text.toString()

            val intent = Intent(this, MenuEj2InfoActivity::class.java)
            intent.putExtra("texto", texto)
            intent.putExtra("numero", numero)

            startActivity(intent)
        }
    }
}