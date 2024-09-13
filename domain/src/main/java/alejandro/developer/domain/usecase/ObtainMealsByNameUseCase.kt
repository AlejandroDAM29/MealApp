package alejandro.developer.domain.usecase

import alejandro.developer.domain.model.MealModel
import alejandro.developer.domain.model.usecase.UseCaseFlow
import alejandro.developer.domain.repository.MealRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetMealsByNameUseCase @Inject constructor(
    private val repository: MealRepository
): UseCaseFlow<List<MealModel>, GetMealsByNameUseCase.Parameters>() {

    override fun run(params: Parameters?): Flow<List<MealModel>> =
        repository.getRemoteMealListByName(params!!.nameRecipe).flowOn(context = IO)

    class Parameters private constructor(val nameRecipe: String) {

        companion object {
            fun forGetMealsByNameUseCase(recipeName: String) = Parameters(recipeName)
        }
    }
}