package com.menesdurak.graphqlrickandmorty.data

import com.apollographql.apollo3.ApolloClient
import com.menesdurak.CharactersQuery
import com.menesdurak.graphqlrickandmorty.domain.CharacterClient
import com.menesdurak.graphqlrickandmorty.domain.SimpleCharacter

class ApolloCharacterClient(
    private val apolloClient: ApolloClient
): CharacterClient {
    override suspend fun getCharacters(): List<SimpleCharacter> {
        return apolloClient
            .query(CharactersQuery())
            .execute()
            .data
            ?.characters
            ?.toSimpleCharacter()
            ?: emptyList()
    }

}