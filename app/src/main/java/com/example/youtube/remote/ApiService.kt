package com.example.youtube.remote

import android.telecom.Call
import com.example.youtube.data.model.Playlist
import com.example.youtube.model.Playlists
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    fun getPlaylists(
        @Query("part") part : String,
        @Query("channelId") channelId : String,
        @Query("key") key : String,
        @Query("maxResults") maxResults : Int
    ) : Call <Playlist>
}