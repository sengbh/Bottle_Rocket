package com.sengbh.bottle_rocket

import retrofit2.Call
import retrofit2.http.GET

interface ParsingRetrofit {
    @GET("stores.json")
    fun getStore(): Call<Stores>
}
