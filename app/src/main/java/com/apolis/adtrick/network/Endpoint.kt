package com.apolis.adtrick.network

import com.apolis.adtrick.models.RickAndMortyCharacterList
import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {
    @GET("character")
    fun getCharacterSync(): Call<RickAndMortyCharacterList>
}