package com.example.youtube.playlists

import androidx.lifecycle.LiveData
import com.example.youtube.App
import com.example.youtube.data.model.Playlist
import com.example.youtube.ui.BaseViewModel

class MainViewModel : BaseViewModel() {

    fun playlist() : LiveData<Playlist> {
        return App().repository.getPlaylists()
    }
}