package com.example.youtube.repository

import android.telecom.Call
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.viewbinding.BuildConfig
import com.example.youtube.data.model.Playlist
import com.example.youtube.core.network.RetrofitClient
import com.example.youtube.remote.ApiService
import retrofit2.Response
import javax.security.auth.callback.Callback

class Repository {

    private val apiService : ApiService by lazy {
        RetrofitClient.create()
    }

    fun getPlaylists() : LiveData<Playlist> {
        val data = MediatorLiveData<Playlist>()

        apiService.getPlaylists("snippet,contentDetails" , "UCshNYNzkggNqtKD09vLq3SQ" ,
            BuildConfig.API_KEY, 30)
            .enqueue(object : Callback <Playlist> {
                override fun onResponse(call: Call <Playlist>, response: Response<Playlist>) {
                    if (response.isSuccessful) {
                        data.value = response.body()
                    }
                }
                override fun onFailure(call: Call <Playlist>, t: Throwable) {
                }
            })
        return data
    }
}