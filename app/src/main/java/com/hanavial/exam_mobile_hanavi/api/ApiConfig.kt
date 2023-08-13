package com.hanavial.exam_mobile_hanavi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    const val baseUrl = "https://data.bmkg.go.id/DataMKG/TEWS/"

    fun getRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService() : ApiService{
        return getRetrofit().create(ApiService::class.java)
    }
}