package com.example.youtube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.youtube.databinding.ActivityInfoPlaylistrBinding

class InfoPlaylistActivity : AppCompatActivity() {

    private lateinit var binding : ActivityInfoPlaylistrBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoPlaylistrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getSerializableExtra(PlaylistActivity.KEY_FOR_ID) as String
        Toast.makeText(this , id , Toast.LENGTH_SHORT).show()
    }
}