package com.app.mvvmstarter.extensions

import android.view.View

/** makes visible a view. */
fun View.visible() {
    visibility = View.VISIBLE
}

/** makes gone a view. */
fun View.gone(shouldBeGone: Boolean) {
    if (shouldBeGone) visibility = View.GONE
    else visible()
}