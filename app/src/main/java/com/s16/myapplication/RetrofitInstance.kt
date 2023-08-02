package com.s16.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: ApiInterface by lazy { Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Utils.BASE)
        .build()
        .create(ApiInterface::class.java) }
}