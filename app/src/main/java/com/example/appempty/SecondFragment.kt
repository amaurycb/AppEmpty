package com.example.appempty

import android.os.Build
import android.os.Bundle
import android.telephony.PhoneNumberUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.appempty.ViewModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_second.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class SecondFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val randomuser : UserViewModel

        val  result= randomuser.loadUser()


        fullname.text = result.name?.first ?: "No First Name"
        username.text = result.login?.username ?: "No User Name"
        state.text = result.location?.state ?: "No State"
        email.text = result.email
        phone.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            PhoneNumberUtils.formatNumber(result.phone, Locale.US.isO3Country.toString())
        } else result.phone // No format for old OS versions
        country.text = result.location?.country ?: "No Country"
        city.text = result.location?.city ?: "No City"
        result.picture?.let { picture ->
            Glide.with(this@SecondFragment)
                .load(picture.large)
                .into(imageView)
        }

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
            findNavController().navigate(R.id.action_SecondFragment_to_listaFragment)
        }
    }
}