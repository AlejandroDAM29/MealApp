package alejandro.developer.data.remote.datasource

import alejandro.developer.data.remote.model.MealListResponse
import alejandro.developer.data.remote.model.exception.RemoteException
import alejandro.developer.data.remote.service.MealService
import alejandro.developer.domain.model.MealModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class MealsRemoteDatasource @Inject constructor(
    private val mealService: MealService
) {
    @Throws(IOException::class, NullPointerException::class)
    fun getMealListByName(nameRecipe: String): Flow<List<MealModel>> = flow {
        val response = mealService.searchMealsByName(nameRecipe)
        emit(
            if (response.isSuccessful) response.body()!!.meals.map { it.toMealModel() }
            else throw RemoteException(
                response.code(),
                response.errorBody()?.string()
            )
        )
    }

}