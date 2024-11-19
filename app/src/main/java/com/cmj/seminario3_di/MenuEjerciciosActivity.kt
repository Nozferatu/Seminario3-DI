package com.cmj.seminario3_di

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuEjerciciosActivity : AppCompatActivity() {
    private lateinit var botonEj1: AppCompatButton
    private lateinit var botonEj2: AppCompatButton
    private lateinit var botonEj3: AppCompatButton
    private lateinit var botonEj4: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_ejercicios)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        botonEj1 = findViewById(R.id.botonEj1)
        botonEj2 = findViewById(R.id.botonEj2)
        botonEj3 = findViewById(R.id.botonEj3)
        botonEj4 = findViewById(R.id.botonEj4)

        botonEj1.setOnClickListener{
            val intent = Intent(this, MenuEj1Activity::class.java)
            startActivity(intent)
        }

        botonEj2.setOnClickListener{
            val intent = Intent(this, MenuEj2Activity::class.java)
            startActivity(intent)
        }

        botonEj3.setOnClickListener{
            val intent = Intent(this, MenuEj3Activity::class.java)
            startActivity(intent)
        }

        botonEj4.setOnClickListener{
            val intent = Intent(this, MenuEj4Activity::class.java)
            startActivity(intent)
        }
    }
}