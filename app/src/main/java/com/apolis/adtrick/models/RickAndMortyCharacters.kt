package com.apolis.adtrick.models

import com.apolis.adtrick.models.Location

data class RickAndMortyCharacters(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val image: String,
    val location: Location
)