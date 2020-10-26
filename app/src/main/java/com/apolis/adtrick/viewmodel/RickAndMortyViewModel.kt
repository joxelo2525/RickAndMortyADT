package com.apolis.adtrick.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apolis.adtrick.repo.Repository
import com.apolis.adtrick.models.RickAndMortyCharacterList

class RickAndMortyViewModel {
    private var _characterList = MutableLiveData<RickAndMortyCharacterList>()
    val characterList: LiveData<RickAndMortyCharacterList> get() = _characterList
    private lateinit var repo: Repository

    init {
        repo = Repository()
        repo.characterList.observeForever{
            _characterList.postValue(it)
        }
    }

    fun getCharacters(): LiveData<RickAndMortyCharacterList> {
        repo.APICall()
        return characterList
    }
}