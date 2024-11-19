package com.cmj.seminario3_di

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MenuEj3Activity : AppCompatActivity() {
    private lateinit var textoET: TextInputEditText
    private lateinit var cadenasInsertadasTV: TextView
    private lateinit var botonInsertarDato: AppCompatButton
    private lateinit var botonPasarDatos: AppCompatButton

    private var cadenasInsertadas: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_ej3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textoET = findViewById(R.id.textoET)
        cadenasInsertadasTV = findViewById(R.id.cadenasInsertadasTV)
        botonInsertarDato = findViewById(R.id.botonInsertarDato)
        botonPasarDatos = findViewById(R.id.botonPasarDatos)

        botonInsertarDato.setOnClickListener {
            val texto = textoET.text.toString()

            if(texto.isNotEmpty()){
                cadenasInsertadas.add(texto)
                actualizarVistaCadenas()

                textoET.setText("")
            }
        }

        botonPasarDatos.setOnClickListener {
            if(cadenasInsertadas.isNotEmpty()){
                val intent = Intent(this, MenuEj3InfoActivity::class.java)
                intent.putExtra("lista", cadenasInsertadas.toTypedArray())

                startActivity(intent)
            }
        }
    }

    fun actualizarVistaCadenas(){
        var contenido = "Cadenas insertadas: \n"

        for(i in cadenasInsertadas.indices){
            contenido += cadenasInsertadas[i]

            if(i + 1 < cadenasInsertadas.size) contenido += ", "
        }

        cadenasInsertadasTV.text = contenido
    }
}