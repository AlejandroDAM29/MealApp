package alejandro.developer.data.di

import alejandro.developer.data.repository.RecipeRepositoryImpl
import alejandro.developer.domain.repository.RecipeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRecipeRepository(repository: RecipeRepositoryImpl): RecipeRepository
}