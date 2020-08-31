package com.example.appempty

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_lista.*


/**
 * A simple [Fragment] subclass.
 * Use the [ListaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaFragment : Fragment() {

    var personas : ArrayList<UserProfile>? = null
    var adapter : rvAdapter?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_lista, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        rvLista_usuarios.layoutManager = GridLayoutManager(applicationContext, 1)!!
        rvLista_usuarios.setHasFixedSize(true)


        view.findViewById<TextView>(R.id.text).setOnClickListener {
            findNavController().navigate(R.id.action_listaFragment_to_SecondFragment)




        }
    }



}