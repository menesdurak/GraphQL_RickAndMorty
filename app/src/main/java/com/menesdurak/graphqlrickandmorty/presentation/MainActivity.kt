package com.menesdurak.graphqlrickandmorty.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.menesdurak.graphqlrickandmorty.R
import com.menesdurak.graphqlrickandmorty.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val charactersViewModel by viewModels<CharactersViewModel>()
    private val characterAdapter by lazy { CharacterAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        charactersViewModel.getCharacters()
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = characterAdapter
        }
        charactersViewModel.characterList.observe(this) { characters ->
            characterAdapter.updateCharacters(characters)
        }
    }
}