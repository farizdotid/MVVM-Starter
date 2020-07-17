package com.app.mvvmstarter.di

import com.app.mvvmstarter.network.LoremPicsumService
import com.app.mvvmstarter.network.RequestInterceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl(
                "https://picsum.photos/v2/"
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(LoremPicsumService::class.java) }
}