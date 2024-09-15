package alejandro.developer.domain.usecase

import alejandro.developer.domain.model.RecipeModel
import alejandro.developer.domain.model.usecase.UseCaseFlow
import alejandro.developer.domain.repository.RecipeRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAllRecipes @Inject constructor(
    private val repository: RecipeRepository
): UseCaseFlow<List<RecipeModel>, Unit>() {

    override fun run(params: Unit?): Flow<List<RecipeModel>> =
        repository.getAllRecipes().flowOn(context = IO)
}