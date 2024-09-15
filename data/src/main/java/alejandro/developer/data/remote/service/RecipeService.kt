package alejandro.developer.data.remote.service

import alejandro.developer.data.remote.model.RecipeResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeService {

    @GET("get_all_recipes.php")
    suspend fun getAllRecipes(): Response<List<RecipeResponse>>
}