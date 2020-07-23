package com.example.appempty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.details_personas.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val persona = Personas( "Amaury", "amaurycb", 34,  12)
    val persona2 = Personas("William", "Willimail",36,13 )
    val listaPersonas = listOf(persona, persona2)

    val adapter = PersonaAdapter(this, listaPersonas)

    lista.adapter = adapter
    }
}

