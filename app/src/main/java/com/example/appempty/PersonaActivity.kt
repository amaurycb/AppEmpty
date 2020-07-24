package com.example.appempty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_persona.*

class PersonaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persona)

        val persona = intent.getSerializableExtra("persona") as Personas
        nombre_persona.text = persona.nombre
        username_persona.text = persona.username
        age_persona.text= persona.age.toString()
        degree_persona.text = persona.degree.toString()

    }
}