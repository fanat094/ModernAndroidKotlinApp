package com.yamshikovdima.modernandroidkotlinapp.injection.component

import com.yamshikovdima.modernandroidkotlinapp.injection.module.NetworkModule
import com.yamshikovdima.modernandroidkotlinapp.presentation.viewmodel.PostListViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(postListViewModel: PostListViewModel)
    //fun inject(postViewModel: PostViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}