package com.xjh.queryuser.mvvm

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.xjh.queryuser.R
import com.xjh.queryuser.databinding.ActivityMvvmBinding

class MVVMActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = DataBindingUtil.setContentView<ActivityMvvmBinding>(this, R.layout.activity_mvvm)
        var mvvmViewModel = MVVMViewModel()
        binding.viewModel = mvvmViewModel
    }
}
