package alejandro.developer.domain.repository

import alejandro.developer.domain.model.MealModel
import kotlinx.coroutines.flow.Flow

interface MealRepository {
    fun getRemoteMealListByName(nameRecipe: String): Flow<List<MealModel>>
}