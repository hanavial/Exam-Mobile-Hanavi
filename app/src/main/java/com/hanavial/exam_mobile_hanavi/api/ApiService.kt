package com.hanavial.exam_mobile_hanavi.api

import com.hanavial.exam_mobile_hanavi.model.ResponseLatest
import com.hanavial.exam_mobile_hanavi.model.ResponseMagnitude
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("gempaterkini.json")
    fun getMagnitude() : Call<ResponseMagnitude>

    @GET("autogempa.json")
    fun getLatest() : Call<ResponseLatest>
}