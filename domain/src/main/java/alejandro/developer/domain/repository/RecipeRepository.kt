package alejandro.developer.domain.repository

import alejandro.developer.domain.model.RecipeModel
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    fun getAllRecipes(): Flow<List<RecipeModel>>
}