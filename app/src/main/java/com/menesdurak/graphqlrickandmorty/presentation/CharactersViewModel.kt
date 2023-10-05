package com.menesdurak.graphqlrickandmorty.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.menesdurak.graphqlrickandmorty.domain.GetCharactersUseCase
import com.menesdurak.graphqlrickandmorty.domain.SimpleCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {

    private val _charactersList = MutableLiveData<List<SimpleCharacter>>()
    val characterList: LiveData<List<SimpleCharacter>> = _charactersList

    fun getCharacters() {
        viewModelScope.launch {
            _charactersList.value = getCharactersUseCase.execute()
        }
    }
}