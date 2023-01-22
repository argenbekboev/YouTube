package com.example.youtube.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.youtube.databinding.ActivityInfoPlaylistBinding
import com.example.youtube.databinding.ActivityInfoPlaylistrBinding

abstract class BaseActivity<VM : BaseViewModel, VB : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: VB
    protected abstract val viewModel: VM

    protected abstract fun inflateViewBinding(inflater: LayoutInflater): ActivityInfoPlaylistrBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateViewBinding(layoutInflater)
        setContentView(binding.root)

        checkInternet()
        initViewModel()
        initView()
        initListener()
    }

    open fun initView() {}
    open fun initListener() {}
    open fun checkInternet() {}
    open fun initViewModel() {}
}