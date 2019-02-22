package com.yamshikovdima.modernandroidkotlinapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.socks.library.KLog
import com.yamshikovdima.modernandroidkotlinapp.api.PostApi
import com.yamshikovdima.modernandroidkotlinapp.base.BaseViewModel
import com.yamshikovdima.modernandroidkotlinapp.model.Post
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostListViewModel : BaseViewModel() {

    @Inject
    lateinit var postApi: PostApi

    val posts = MutableLiveData<String>()

    val isProgress = MutableLiveData<Boolean>().apply { value = true }

    init {

        loadPosts()
    }

    private fun loadPosts() {

        disposable.add(
            postApi.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    onRetrievePostListStart()
                }
                .subscribe({
                    onRetrievePostListSuccess(it)
                },
                    {
                        onRetrievePostListError()
                    })
        )
    }

    private fun onRetrievePostListStart() {

        isProgress.postValue(true)

    }

    private fun onRetrievePostListFinish() {

    }

    private fun onRetrievePostListSuccess(postList: List<Post>) {

        posts.postValue(postList[0].title)

        KLog.e("PostList", "" + postList[0].title)

        isProgress.postValue(false)
    }

    private fun onRetrievePostListError() {

    }
}