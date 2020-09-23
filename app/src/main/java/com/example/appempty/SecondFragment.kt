package com.example.appempty

import android.os.Build
import android.os.Bundle
import android.telephony.PhoneNumberUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.appempty.ViewModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_second.*
import java.util.*

class SecondFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userViewModel: UserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)



       userViewModel.usuario.observe(this, androidx.lifecycle.Observer { result ->
         var resultado = result.first()
          fullname.text = resultado.name?.first ?: "No First Name"
          username.text = resultado.login?.username ?: "No User Name"

           state.text = resultado.location?.state ?: "No State"
           email.text = resultado.email
           phone.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
               PhoneNumberUtils.formatNumber(resultado.phone, Locale.US.isO3Country.toString())
           } else resultado.phone // No format for old OS versions
           country.text = resultado.location?.country ?: "No Country"
           city.text = resultado.location?.city ?: "No City"
           resultado.picture?.let { picture ->
               Glide.with(this@SecondFragment)
                   .load(picture.large)
                   .into(imageView)
           }


        }  )

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fullname.setOnClickListener {

            if (resources.getBoolean(R.bool.isTablet)) {
                val navHostFragment = childFragmentManager.findFragmentById(R.id.fragment2) as NavHostFragment
                navHostFragment.navController.navigate(R.id.SecondFragment)

            } else {
                findNavController().navigate(R.id.action_SecondFragment_to_listaFragment)
            }
        }
    }
}


