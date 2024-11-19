package com.cmj.seminario3_di

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.children

class MenuEj1Activity : AppCompatActivity() {
    private lateinit var textoEstadoPartida: TextView
    private lateinit var botonReinicar: AppCompatButton
    private lateinit var tablero: LinearLayout
    private lateinit var arrayTablero: Array<Array<Int>> // 1 = Jugador | 2 = Maquina
    private var partidaTerminada: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_ej1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textoEstadoPartida = findViewById(R.id.estadoPartida)

        botonReinicar = findViewById(R.id.botonReiniciar)
        botonReinicar.setOnClickListener { recreate() }

        arrayTablero = arrayOf(
            arrayOf(0, 0, 0),
            arrayOf(0, 0, 0),
            arrayOf(0, 0, 0)
        )

        tablero = findViewById(R.id.tablero)

        tablero.children.forEach { f ->
            var fila: LinearLayout = f as LinearLayout

            fila.children.forEach { imgView ->
                var casilla: ImageView = imgView as ImageView
                var idCasilla = applicationContext.resources.getResourceName(casilla.id).split("/")[1]
                var index = idCasilla.substring(idCasilla.length - 1, idCasilla.length).toInt()
                index--

                casilla.setOnClickListener {
                    if(!partidaTerminada){
                        if(arrayTablero[index/3][index%3] == 0){
                            Log.i("Tablero", "Cambiando a cruz")
                            arrayTablero[index/3][index%3] = 1
                            casilla.setImageResource(R.drawable.casilla_cruz)

                            comprobarPartida()
                            jugadaMaquina()
                        }
                    }
                }
            }
        }
    }

    fun jugadaMaquina(){
        if(!partidaTerminada){
            var eleccionPuesta = false
            var min = 0
            var max = 8
            var random: Int

            while(!eleccionPuesta){
                random = (min..max).random()

                if(arrayTablero[random/3][random%3] == 0){
                    arrayTablero[random/3][random%3] = 2
                    var fila: LinearLayout = tablero.children.elementAt(random/3) as LinearLayout
                    var casilla: ImageView = fila.children.elementAt(random%3) as ImageView

                    casilla.setImageResource(R.drawable.casilla_circulo)

                    eleccionPuesta = true
                }
            }

            comprobarPartida()
        }
    }

    fun comprobarPartida(){
        //Comprobar horizontales
        for(fila in arrayTablero){
            if(fila[0] == 1 && fila[1] == 1 && fila[2] == 1){
                partidaTerminada = true

                textoEstadoPartida.text = "Victoria"
            }else if(fila[0] == 2 && fila[1] == 2 && fila[2] == 2){
                partidaTerminada = true

                textoEstadoPartida.text = "Derrota"
            }
        }

        //Comprobar verticales
        var col = 0

        while(col <= 2){
            if(arrayTablero[0][col] == 1 && arrayTablero[1][col] == 1 && arrayTablero[2][col] == 1){
                partidaTerminada = true

                textoEstadoPartida.text = "Victoria"
            }else if(arrayTablero[0][col] == 2 && arrayTablero[1][col] == 2 && arrayTablero[2][col] == 2){
                partidaTerminada = true

                textoEstadoPartida.text = "Derrota"
            }

            col++
        }

        //Diagonales
        if((arrayTablero[0][0] == 1 && arrayTablero[1][1] == 1 && arrayTablero[2][2] == 1) ||
            (arrayTablero[0][2] == 1 && arrayTablero[1][1] == 1 && arrayTablero[2][0] == 1)){
            partidaTerminada = true

            textoEstadoPartida.text = "Victoria"
        }else if((arrayTablero[0][0] == 2 && arrayTablero[1][1] == 2 && arrayTablero[2][2] == 2) ||
            (arrayTablero[0][2] == 2 && arrayTablero[1][1] == 2 && arrayTablero[2][0] == 2)){
            partidaTerminada = true

            textoEstadoPartida.text = "Derrota"
        }
    }

    fun mostrarTablero(){
        for(fila in arrayTablero){
            Log.i("Tablero", fila.toList().toString())
        }
    }
}