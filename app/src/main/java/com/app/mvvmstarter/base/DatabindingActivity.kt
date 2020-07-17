package com.app.mvvmstarter.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * DatabindingActivity is an abstract class for providing [DataBindingUtil].
 * provides implementations of only [ViewDataBinding] from an abstract information.
 * Do not modify this class. This is a first-level abstraction class.
 * If you want to add more specifications, make another class which extends [DatabindingActivity].
 */
abstract class DatabindingActivity : AppCompatActivity() {

    protected inline fun <reified T : ViewDataBinding> binding(
        @LayoutRes resId: Int
    ): Lazy<T> = lazy { DataBindingUtil.setContentView<T>(this, resId) }
}