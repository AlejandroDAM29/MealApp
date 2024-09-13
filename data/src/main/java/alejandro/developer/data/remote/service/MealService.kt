package alejandro.developer.data.remote.service

import alejandro.developer.data.remote.model.MealListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealService {
    @GET("search.php")
    suspend fun searchMealsByName(@Query("s") searchName: String): Response<MealListResponse>
}