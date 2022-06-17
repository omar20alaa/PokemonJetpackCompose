package app.pokemon.repository

import app.pokemon.di.data.remote.PokeApi
import app.pokemon.di.data.remote.responses.Pokemon
import app.pokemon.di.data.remote.responses.PokemonList
import app.pokemon.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {

    suspend fun getPokeList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokeList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred!")
        }
        return Resource.Success(response)
    }

    suspend fun getPokeInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokeInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred!")
        }
        return Resource.Success(response)
    }

}