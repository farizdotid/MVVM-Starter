package com.app.mvvmstarter.binding

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import com.app.mvvmstarter.R
import com.google.android.material.appbar.MaterialToolbar

fun AppCompatActivity.simpleToolbarWithHome(toolbar: MaterialToolbar, title_: String = "") {
    setSupportActionBar(toolbar)
    supportActionBar?.run {
        setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
        setDisplayHomeAsUpEnabled(true)
        title = title_
    }
}

@BindingAdapter("simpleToolbarWithHome", "simpleToolbarTitle")
fun bindToolbarWithTitle(toolbar: MaterialToolbar, activity: AppCompatActivity, title: String) {
    activity.simpleToolbarWithHome(toolbar, title)
}