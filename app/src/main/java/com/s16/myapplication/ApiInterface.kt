package com.s16.myapplication

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiInterface {
    @GET("rishab_jain@ait.edu")
    suspend fun getDataFromUrl(): Response<List<MyDataItemItem>>
}