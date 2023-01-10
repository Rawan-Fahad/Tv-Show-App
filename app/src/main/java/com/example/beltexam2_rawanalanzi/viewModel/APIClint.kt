package com.example.beltexam2_rawanalanzi.viewModel

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
// https://api.tvmaze.com/search/shows?q=girls
class APIClint {
    var retrofit:Retrofit? = null
    fun getClint(): Retrofit? {
       retrofit = Retrofit.Builder()
        .baseUrl("https://api.tvmaze.com/search/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        return retrofit
    }
}