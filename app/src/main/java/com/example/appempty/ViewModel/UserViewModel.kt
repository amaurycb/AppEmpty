package com.example.appempty.ViewModel



import android.os.Build
import android.telephony.PhoneNumberUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.example.appempty.RandomUserResponse
import com.example.appempty.RandomUserService
import com.example.appempty.UserProfile
import kotlinx.android.synthetic.main.fragment_second.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class UserViewModel : ViewModel() {


  private  fun loadUser(){

        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val userCall = retrofit.create(RandomUserService::class.java).getUserList(1)

        userCall.enqueue(object : Callback<RandomUserResponse> {
            override fun onFailure(call: Call<RandomUserResponse>, t: Throwable) {}

            override fun onResponse(
                call: Call<RandomUserResponse>,
                response: Response<RandomUserResponse>
            ) {
                if (!response.isSuccessful) throw Throwable("error1")

                val result: UserProfile = response.body()?.results?.firstOrNull() ?: UserProfile()

              //  return result

            }
        })


    }





}