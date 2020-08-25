package com.example.appempty.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.load.engine.Resource
import com.example.appempty.RandomUserResponse
import com.example.appempty.RandomUserService
import com.example.appempty.UserProfile
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserViewModel : ViewModel() {

 //  val userresult = MutableLiveData<List<UserProfile>>()
        val usuario =MutableLiveData<UserProfile>()
    init {
        loadUser()
    }

    fun loadUser() {

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
                usuario.value = result
            }
        })
    }
}