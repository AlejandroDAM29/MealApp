package alejandro.developer.data.repository

import alejandro.developer.data.remote.datasource.MealsRemoteDatasource
import alejandro.developer.domain.repository.MealRepository
import dagger.Binds
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val remoteDatasource: MealsRemoteDatasource
): MealRepository{

    override fun getRemoteMealListByName(nameRecipe: String) = remoteDatasource.getMealListByName(nameRecipe)

}