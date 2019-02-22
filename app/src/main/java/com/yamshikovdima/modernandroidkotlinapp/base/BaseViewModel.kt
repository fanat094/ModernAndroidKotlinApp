package com.yamshikovdima.modernandroidkotlinapp.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModel
import com.yamshikovdima.modernandroidkotlinapp.injection.component.DaggerViewModelInjector
import com.yamshikovdima.modernandroidkotlinapp.injection.component.ViewModelInjector
import com.yamshikovdima.modernandroidkotlinapp.injection.module.NetworkModule
import com.yamshikovdima.modernandroidkotlinapp.presentation.viewmodel.PostListViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel(), LifecycleOwner {

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
            //is PostViewModel -> injector.inject(this)
        }
    }


    //
    private val lifecycle: LifecycleRegistry = LifecycleRegistry(this)

    protected val disposable = CompositeDisposable()

    init {
        lifecycle.markState(Lifecycle.State.RESUMED)
    }

    override fun getLifecycle() = lifecycle

    public override fun onCleared() {
        lifecycle.markState(Lifecycle.State.DESTROYED)
        disposable.clear()
    }
}