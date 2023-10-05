package com.menesdurak.graphqlrickandmorty.data

import com.menesdurak.CharactersQuery
import com.menesdurak.graphqlrickandmorty.domain.SimpleCharacter

fun CharactersQuery.Characters.toSimpleCharacter(): List<SimpleCharacter> {
    return results!!.map {
        SimpleCharacter(
            id = it!!.id,
            name = it.name
        )
    }
}