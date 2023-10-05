package com.menesdurak.graphqlrickandmorty.domain

class GetCharactersUseCase(
    private val characterClient: CharacterClient
) {

    suspend fun execute(): List<SimpleCharacter> {
        return characterClient
            .getCharacters()
            .sortedBy { it.name }
    }
}