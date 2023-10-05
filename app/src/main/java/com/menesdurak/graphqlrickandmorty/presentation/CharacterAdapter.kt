package com.menesdurak.graphqlrickandmorty.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.menesdurak.graphqlrickandmorty.databinding.ItemCharacterBinding
import com.menesdurak.graphqlrickandmorty.domain.SimpleCharacter

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterHolder>() {

    private val characters = mutableListOf<SimpleCharacter>()

    inner class CharacterHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(character: SimpleCharacter) {
                binding.tvId.text = character.id
                binding.tvName.text = character.name
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val bind = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterHolder(bind)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        holder.bind(characters[position])
    }

    fun updateCharacters(newList: List<SimpleCharacter>) {
        characters.clear()
        characters.addAll(newList)
        notifyDataSetChanged()
    }
}