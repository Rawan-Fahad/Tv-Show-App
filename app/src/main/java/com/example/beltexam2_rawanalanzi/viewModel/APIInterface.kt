package com.example.beltexam2_rawanalanzi.viewModel

import com.example.beltexam2_rawanalanzi.model.data.TvShowItemItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// https://api.tvmaze.com/search/shows?q=:girls
//shows?q=:query
interface APIInterface
{
        @GET("shows")
         fun getAllTvShows(@Query("q") search:String): Response<ArrayList<TvShowItemItem>>


}