package com.example.appempty

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager

import com.example.appempty.ViewModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_lista.*

class ListaFragment : Fragment() {
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lista, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel.usuario.observe(this@ListaFragment as LifecycleOwner, androidx.lifecycle.Observer {
            val itemAdapter = ItemAdapter(
                myDataset = it ?: emptyList()
            ) {             if (resources.getBoolean(R.bool.isTablet)) {
                val navHostFragment =
                    childFragmentManager.findFragmentById(R.id.fragment2) as NavHostFragment
                navHostFragment.navController.navigate(R.id.SecondFragment)

            } else {
                findNavController().navigate(R.id.action_listaFragment_to_SecondFragment)
            }
            }
            rvLista_usuarios.adapter = itemAdapter
            var manager = GridLayoutManager(activity,2)
            rvLista_usuarios.layoutManager = manager



        })

    }
}