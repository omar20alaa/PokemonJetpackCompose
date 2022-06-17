package app.pokemon.pokemon_details

import androidx.lifecycle.ViewModel
import app.pokemon.di.data.remote.responses.Pokemon
import app.pokemon.repository.PokemonRepository
import app.pokemon.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokeInfo(pokemonName)
    }

}