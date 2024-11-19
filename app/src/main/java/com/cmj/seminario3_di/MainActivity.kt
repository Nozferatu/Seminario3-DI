package com.cmj.seminario3_di

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var contexto = this
    private lateinit var botonEj1: AppCompatButton
    private lateinit var botonEj3: AppCompatButton
    private lateinit var botonEj4: AppCompatButton
    private lateinit var botonEj5: AppCompatButton
    private lateinit var botonMenuEj: AppCompatButton
    //private lateinit var bind: ActivityEj1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //bind = ActivityEj1Binding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        botonEj1 = findViewById(R.id.botonEj1)
        botonEj3 = findViewById(R.id.botonEj3)
        botonEj4 = findViewById(R.id.botonEj4)
        botonEj5 = findViewById(R.id.botonEj5)
        botonMenuEj = findViewById(R.id.botonMenuEj)

        botonEj1.setOnClickListener {
            val intent = Intent(contexto, LambdaActivity::class.java)
            intent.putExtra("layout", R.layout.activity_ej1)

            startActivity(intent)
        }

        botonEj3.setOnClickListener {
            val intent = Intent(contexto, LambdaActivity::class.java)
            intent.putExtra("layout", R.layout.activity_ej3)

            startActivity(intent)
        }

        botonEj4.setOnClickListener {
            val intent = Intent(contexto, LambdaActivity::class.java)
            intent.putExtra("layout", R.layout.activity_ej4)

            startActivity(intent)
        }

        botonEj5.setOnClickListener {
            val intent = Intent(contexto, LambdaActivity::class.java)
            intent.putExtra("layout", R.layout.activity_ej5)

            startActivity(intent)
        }

        botonMenuEj.setOnClickListener {
            val intent = Intent(contexto, MenuEjerciciosActivity::class.java)

            startActivity(intent)
        }
    }
}