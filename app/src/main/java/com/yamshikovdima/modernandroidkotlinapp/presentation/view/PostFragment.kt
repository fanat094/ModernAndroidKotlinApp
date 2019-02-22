package com.yamshikovdima.modernandroidkotlinapp.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.yamshikovdima.modernandroidkotlinapp.R
import com.yamshikovdima.modernandroidkotlinapp.databinding.FragmentPostBinding
import com.yamshikovdima.modernandroidkotlinapp.injection.ViewModelFactory
import com.yamshikovdima.modernandroidkotlinapp.presentation.viewmodel.PostListViewModel


class PostFragment : Fragment() {

    private lateinit var viewModel: PostListViewModel

    /*override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProviders.of(this, ViewModelFactory(this))
            .get(PostListViewModel::class.java)

        return inflater.inflate(R.layout.fragment_post, container, false)
    }*/

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        viewModel = ViewModelProviders.of(this, ViewModelFactory(this))
            .get(PostListViewModel::class.java)

        return DataBindingUtil.inflate<FragmentPostBinding>(inflater, R.layout.fragment_post, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        DataBindingUtil.getBinding<FragmentPostBinding>(view)?.apply {

            setLifecycleOwner(this@PostFragment)

            vm = viewModel
        }
    }
}