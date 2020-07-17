package com.app.mvvmstarter.repository

import androidx.databinding.ObservableBoolean

/** Repository is an interface for configuring base repository classes. */
interface Repository {
    // this override property is for saving network loading status.
    var isLoading: ObservableBoolean
}