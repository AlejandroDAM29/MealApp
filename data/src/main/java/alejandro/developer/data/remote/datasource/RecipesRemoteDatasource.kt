package alejandro.developer.data.remote.datasource

import alejandro.developer.data.remote.model.exception.RemoteException
import alejandro.developer.data.remote.service.RecipeService
import alejandro.developer.domain.model.RecipeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class RecipesRemoteDatasource @Inject constructor(
    private val recipeService: RecipeService
) {
    @Throws(IOException::class, NullPointerException::class)
    fun getAllRecipes(): Flow<List<RecipeModel>> = flow {
        val response = recipeService.getAllRecipes()
        emit(
            if (response.isSuccessful) response.body()!!.map { it.toRecipeModel()}
            else throw RemoteException(
                response.code(),
                response.errorBody()?.string()
            )
        )
    }
}