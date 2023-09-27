package com.jluqgon214.actividad01

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declarar variables de clase
    private lateinit var boton: Button
    private lateinit var textView: TextView
    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar las variables de clase
        boton = findViewById(R.id.boton)
        textView = findViewById(R.id.texto)

        //Acción cada vez que se pulsa el botón
        boton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                contador++
                actualizarTexto()
            }
        })
    }

    //Funcion que actuliza el texto
    private fun actualizarTexto() {
        if (contador <= 5) {
            textView.text = "Has hecho click $contador veces!"
            textView.textSize = 24f
        } else if (contador <= 10) {
            textView.text = "Has hecho click varias veces ($contador)!"
            textView.textSize = 22f
        } else {
            textView.text = "Te has pasado de clicks!"
            boton.isEnabled = false
            showToast("El botón ha sido deshabilitado")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
