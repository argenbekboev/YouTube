package com.example.youtube

import android.content.Intent
import android.net.ConnectivityManager
import android.view.LayoutInflater
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.youtube.databinding.ActivityPlaylistBinding
import com.example.youtube.data.model.Items
import com.example.youtube.core.network.Connection
import com.example.youtube.databinding.ActivityInfoPlaylistrBinding
import com.example.youtube.playlists.MainViewModel
import com.example.youtube.playlists.PlaylistAdapter
import com.example.youtube.ui.BaseActivity

class PlaylistActivity : BaseActivity<MainViewModel, ActivityPlaylistBinding>() {

    private lateinit var adapter: PlaylistAdapter

    override val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityInfoPlaylistrBinding {
        return ActivityInfoPlaylistrBinding.inflate(layoutInflater)
    }

    private fun clickListener(id : String) {
        Intent(this , InfoPlaylistActivity::class.java).apply {
            putExtra(KEY_FOR_ID ,id)
            startActivity(this)
        }
    }

    override fun initViewModel() {
        viewModel.playlist().observe(this) {
            if (it != null) {
                adapter = PlaylistAdapter(it.items as ArrayList<Items> , this ::clickListener)
            }
            binding.ryPlaylists.adapter = adapter
        }
    }

    override fun checkInternet() {
        Connection((getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager))
            .observe(this) {
                binding.includedInternet.constInternet.isVisible = !it
                binding.ryPlaylists.isVisible  = it
                if (it == true) {
                    initViewModel()
                }
            }
    }

    companion object {
        val KEY_FOR_ID = "HELLO"
    }
}