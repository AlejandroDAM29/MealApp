package alejandro.developer.data.repository

import alejandro.developer.data.remote.datasource.RecipesRemoteDatasource
import alejandro.developer.domain.model.RecipeModel
import alejandro.developer.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val recipesRemoteDatasource: RecipesRemoteDatasource
): RecipeRepository {
    override fun getAllRecipes(): Flow<List<RecipeModel>> = recipesRemoteDatasource.getAllRecipes()

}