package com.example.appempty.ViewModel

import androidx.lifecycle.MutableLiveData
import com.example.appempty.RandomUserResponse
import com.example.appempty.RandomUserService
import com.example.appempty.UserProfile
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserListViewModel {
    val lista = MutableLiveData<UserProfile>()

    init {
        loadUserlist()
    }

    fun loadUserlist() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val userCall = retrofit.create(RandomUserService::class.java).getUserList(10)

        userCall.enqueue(object : Callback<RandomUserResponse> {
            override fun onFailure(call: Call<RandomUserResponse>, t: Throwable) {}

            override fun onResponse(
                call: Call<RandomUserResponse>,
                response: Response<RandomUserResponse>
            ) {
                if (!response.isSuccessful) throw Throwable("error1")

                val result: UserProfile = response.body()?.results?.firstOrNull() ?: UserProfile()
                lista.value = result
            }
        })
    }
}