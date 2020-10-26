package com.apolis.adtrick.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apolis.adtrick.models.RickAndMortyCharacterList
import com.apolis.adtrick.network.Endpoint
import com.apolis.adtrick.network.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    private var _characterList = MutableLiveData<RickAndMortyCharacterList>()
    val characterList: LiveData<RickAndMortyCharacterList> get() = _characterList

    fun APICall(){
        val call = Retrofit.getCharacters()
            .create(Endpoint::class.java)
            .getCharacterSync()
        call.enqueue(object: Callback<RickAndMortyCharacterList>{
            override fun onResponse(
                call: Call<RickAndMortyCharacterList>,
                response: Response<RickAndMortyCharacterList>
            ) {
                _characterList.postValue(response.body())
                Log.d("API", "Success")
            }

            override fun onFailure(call: Call<RickAndMortyCharacterList>, t: Throwable) {
                Log.d("API", "Failed")
            }
        })
    }
}