package com.menesdurak.graphqlrickandmorty.domain

interface CharacterClient {
    suspend fun getCharacters(): List<SimpleCharacter>
}