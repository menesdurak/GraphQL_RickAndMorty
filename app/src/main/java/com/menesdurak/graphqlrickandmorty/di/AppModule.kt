package com.menesdurak.graphqlrickandmorty.di

import com.apollographql.apollo3.ApolloClient
import com.menesdurak.graphqlrickandmorty.data.ApolloCharacterClient
import com.menesdurak.graphqlrickandmorty.domain.CharacterClient
import com.menesdurak.graphqlrickandmorty.domain.GetCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://rickandmortyapi.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun provideCharacterClient(apolloClient: ApolloClient): CharacterClient {
        return ApolloCharacterClient(apolloClient)
    }

    @Provides
    @Singleton
    fun provideGetCharactersUseCase(characterClient: CharacterClient): GetCharactersUseCase {
        return GetCharactersUseCase(characterClient)
    }
}