package com.yamshikovdima.modernandroidkotlinapp.injection

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yamshikovdima.modernandroidkotlinapp.presentation.viewmodel.PostListViewModel

class ViewModelFactory (private val activity: Fragment): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PostListViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}