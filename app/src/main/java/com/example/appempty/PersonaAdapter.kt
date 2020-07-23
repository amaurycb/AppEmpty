package com.example.appempty

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.appempty.Personas
import com.example.appempty.R
import kotlinx.android.synthetic.main.details_personas.view.*


class PersonaAdapter(private val mContext: Context, private val listaPersonas: List<Personas>) : ArrayAdapter<Personas>(mContext, 0, listaPersonas) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.details_personas, parent, false)

        val persona = listaPersonas[position]

        layout.nombre.text = persona.nombre
        layout.username.text = persona.username


        return layout
    }
}