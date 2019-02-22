package com.yamshikovdima.modernandroidkotlinapp.binding

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("visibility")
fun View.setVisibility(value: Boolean?) {
    visibility = if (value != false) View.VISIBLE else View.GONE
}